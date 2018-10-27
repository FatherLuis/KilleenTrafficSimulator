/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Init.Road;
import Main.Operators.StopSign;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fathe
 */
public class Instructions2 
{
 
    ArrayList<Road> RoadList;
    PointHashTable PHT;   
    
    private Road curRoad;
    private Point curPoint;   
    private String position;  
    private int RoadIndex;
    private int NodeIndex;  
    private Random rand = new Random();
    private boolean isMoveable = true; 
    private int randNum;
    
    
    private int wait = 0; 
    

    public Instructions2(ArrayList<Road> RoadList, PointHashTable PHT)
    {
        this.RoadList = RoadList;
        this.PHT = PHT;
        this.setUpLocation();
    }
    
    
    private void setUpLocation()
    {
               
        RoadIndex = rand.nextInt(this.RoadList.size());

        curRoad = this.RoadList.get(RoadIndex);

        NodeIndex = rand.nextInt(curRoad.getDetailedRef().size());

        String ID = (String) curRoad.getDetailedRef().get(NodeIndex);

        curPoint = PHT.getPoint(ID);

        randNum = rand.nextInt(100);

        if(randNum > 55){position = "FL"; }else{position = "RL";}

    }
    
    
    public void setRoadList(ArrayList arr){this.RoadList = arr;}
    public void setPointHashTable(PointHashTable PHT){this.PHT = PHT;}
    
    public Point getPoint(){return curPoint;}
    public void setPoint(Point p){this.curPoint = p;}

    
    private void forwardLoop()
    {

        
        
        if(NodeIndex < this.curRoad.getDetailedRef().size() -1)
        {          
            NodeIndex++;       
            String ID = (String) curRoad.getDetailedRef().get(NodeIndex);
            curPoint = PHT.getPoint(ID); 
            possibleRelocate();

            if((curPoint instanceof StopSign))
            {
                isMoveable = false;
                wait = 5;
            }
         }     
        else
        {
            System.out.println("Node Index on FL  "  + NodeIndex);
        }

    }
    
    private void reverseLoop()
    {        
       
       
        if(NodeIndex > 0)
        {            
            NodeIndex--;
            String ID = (String) curRoad.getDetailedRef().get(NodeIndex);
            curPoint = PHT.getPoint(ID);
            possibleRelocate();

            if((curPoint instanceof StopSign))
            {
                isMoveable = false;
                wait = 5;
            }
        }
        else
        {
            System.out.println("Node Index on RL  "  + NodeIndex);
        }
            

    }
    
    public void move()
    {
        if(isMoveable)
        {
            if(NodeIndex == 0 || NodeIndex == curRoad.getDetailedRef().size() - 1)
            {   
                if(curPoint.hasParents())
                {
                    //System.out.println("\n1REL?");
                    relocate();
                    //System.out.println("2REL?");

                    if(position.equals("FL"))
                    {
                        forwardLoop(); 
                    }
                    else if(position.equals("RL"))
                    {
                        reverseLoop();
                    }   
                }
                else
                {
                    //System.out.println("\n1CR?");
                    cornerRoad(); 
                    //System.out.println("2CR?");
                }   

            }
            else
            {       
                switch (position) {
                    case "FL":
                        forwardLoop();
                        break;
                    case "RL":
                        reverseLoop();
                        break;
                    default:
                        System.out.println("Messed up someone loop?");
                        break;
                }
            }
        }
        else
        {
            wait--;
            
            if(wait ==0){isMoveable = true;}
        }


        
    }
    
    private void relocate()
    {
        Road tempRoad;

        do
        {        
            randNum = rand.nextInt(curPoint.getParentList().size());
            tempRoad = (Road) curPoint.getParentList().get(randNum);

                

        }while(curRoad.getID().equals(tempRoad.getID()));

        curRoad = tempRoad; 
        
        for(int i=0; i < curRoad.getDetailedRef().size(); i++)
        {
            if(curPoint.getID().equals(curRoad.getDetailedRef().get(i)))
            {
                this.NodeIndex = i;
                
                if(NodeIndex == 0)
                {
                    position = "FL";
                }
                else if(NodeIndex == curRoad.getDetailedRef().size() - 1 )
                {
                    position = "RL";
                }
                else
                {
                    randNum = rand.nextInt(100);
                    
                    if(randNum > 70)
                    {                
                        position = "FL";
                    }
                    else
                    {
                        position = "RL";
                    }
                }
                         
 
                break;              
            }
        }
        
        


        
        
    
    }   
         
    private void cornerRoad()
    {
        randNum = rand.nextInt(100);
        
        if(randNum >= 20)
        {
            
            if(NodeIndex == 0)
            {
                position = "FL";
                forwardLoop();
            }
            else if(NodeIndex == curRoad.getDetailedRef().size() - 1 )
            {
                position = "RL";
                reverseLoop();
            } 
        }
        else
        {
            //System.out.println("I'm Stuck");
            //SetUp();     
        }
    }
    
       
    private void possibleRelocate()
    {
        
        randNum = rand.nextInt(100);
 
        if(curPoint.hasParents() && randNum > 70)
        {
            randNum = rand.nextInt(curPoint.getParentList().size());
            Road tempRoad = (Road) curPoint.getParentList().get(randNum);

            if(!(curRoad.getID().equals(tempRoad.getID())))
            {
                //System.out.println("\nold Road: " + curRoad.getID());
                //System.out.println("new Road: " + tempRoad.getID());
                
                
                curRoad = tempRoad; 

                for(int i=0; i < curRoad.getDetailedRef().size(); i++)
                {
                    if(curPoint.getID().equals(curRoad.getDetailedRef().get(i)))
                    {
                        this.NodeIndex = i;

                        if(NodeIndex == 0)
                        {
                            position = "FL";
                        }
                        else if(NodeIndex == curRoad.getDetailedRef().size() - 1 )
                        {
                            position = "RL";
                        }
                        else
                        {
                            randNum = rand.nextInt(100);

                            if(randNum > 70)
                            {                
                                position = "FL";
                            }
                            else
                            {
                                position = "RL";
                            }
                        }

                        //System.out.println("Node ID: " + curPoint.getID() +"   MADE THE CHANGE");      
                        switch (position) 
                        {
                            case "FL":
                                forwardLoop();
                                break;
                            case "RL":
                                reverseLoop();
                                break;
                            default:
                                System.out.println("Messed up someone loop?");
                                break;
                        }
                        
                        break;              
                    }
                }
            }
            else
            {//System.out.println("Node ID: " + curPoint.getID() +"   DIDNT MAKE THE CHANGE");
                
            }
        }


        
    }   
      
    
    
    
    
    
    
    
    
    
    
}
