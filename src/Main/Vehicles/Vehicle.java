package Main.Vehicles;

import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Init.Road;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;




/*******************************************************************************
***CLASS NAME:
***CLASS AUTHOR:
********************************************************************************
***PURPOSE OF CLASS:
********************************************************************************
***DATE:
********************************************************************************
***LIST OF CHANGES WITH DATES:
********************************************************************************
***SPECIAL NOTES: 
*** 
***
*******************************************************************************/
public class Vehicle 
{
    ArrayList<Road> RoadList;
    PointHashTable PHT;   
    
    private Road curRoad;
    private Point curPoint;
    
    private String position;
    
    private int RoadIndex;
    private int NodeIndex;
    
    private Random rand = new Random();
    
    private boolean isMoved = true;
    
    private int randNum;
    
    
    Color color;

    /***************************************************************************
    ***METHOD NAME: 
    ***METHOD AUTHOR:
    ****************************************************************************
    ***PURPOSE OF THE METHOD:
    ***METHOD USED:
    ***METHOD PARAMETERS:
    ***RETURN VALUE:
    ****************************************************************************
    ***DATE:
    ***************************************************************************/     
    public Vehicle(ArrayList<Road> RoadList, PointHashTable PHT)
    {
        this.RoadList = RoadList;
        this.PHT = PHT;
        SetUp();
    }
    
    public void setRoadList(ArrayList arr){this.RoadList = arr;}
    public void setPointHashTable(PointHashTable PHT){this.PHT = PHT;}
    
    public Point getPoint(){return curPoint;}
    public void setPoint(Point p){this.curPoint = p;}
    
    private void SetUp()
    {
        RoadIndex = rand.nextInt(this.RoadList.size());

        curRoad = this.RoadList.get(RoadIndex);

        NodeIndex = rand.nextInt(curRoad.getDetailedRef().size());

        String ID = (String) curRoad.getDetailedRef().get(NodeIndex);

        curPoint = PHT.getPoint(ID);

        randNum = rand.nextInt(100);

        if(randNum > 55){position = "FL"; color = Color.BLUE;}else{position = "RL";color = Color.RED;}

        //lanePosition = "RIGHT"; color = Color.BLUE;

    }
   
    
    private void forwardLoop()
    {
        //System.out.println("      FL INDEX " + this.NodeIndex  );
        
        if(NodeIndex < this.curRoad.getDetailedRef().size()-1)
        {
            //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getDetailedRef().size());

            this.NodeIndex += 1;
            String ID = (String) curRoad.getDetailedRef().get(NodeIndex);
            
            //System.out.println( "written " +ID);
            //System.out.println(" " + PHT.getPoint(ID).getID()); 
            curPoint = PHT.getPoint(ID);
            
            
            isMoved = true;

        }
        else if(!isMoved)
        {
            if(position.equals("FL"))
            {
                position = "RL";
                reverseLoop();
                isMoved = true;
            }
            else if(position.equals("RL"))
            {
                position = "FL";
                forwardLoop();
                isMoved = true;
            }        
        }
        else
        {
            isMoved = false;
            forwardLoop();
        }
    }
    
    private void reverseLoop()
    {
        //System.out.println("       RL INDEX " + this.NodeIndex  );
        
        if(NodeIndex > 0)
        {
            //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getDetailedRef().size());

            this.NodeIndex -= 1;
            String ID = (String) curRoad.getDetailedRef().get(NodeIndex);
            
            //System.out.println( "written " +ID);

            
            //System.out.println(" " + PHT.getPoint(ID).getID());
            
            try
            {
                curPoint = PHT.getPoint(ID);
            }catch(Exception ex)
            {
                System.out.println("  BRING SOMETHING" );
            }
            
            
            
            
            
            isMoved = true;
        } 
        else if(!isMoved)
        {
            if(position.equals("FL"))
            {
                position = "RL";
                reverseLoop();
                isMoved = true;
            }
            else if(position.equals("RL"))
            {
                position = "FL";
                forwardLoop();
                isMoved = true;
            }        
        }
        else
        {
            isMoved = false;
            reverseLoop();
        }    
    }
    
    public void move()
    {
        //System.out.println("move INDEX " + this.NodeIndex +  "   Size: " + this.curRoad.getDetailedRef().size()  );
        
        
        if(!(NodeIndex <=0 || NodeIndex >= this.curRoad.getDetailedRef().size() -1))
        {
            
            if(curPoint.getParentList().size() == 1)
            {

                if(position.equals("FL"))
                {
                    //System.out.println("CHECKED IN");
                    forwardLoop();
                }
                else if(position.equals("RL"))
                {
                    //System.out.println("CHECKED IN");
                    reverseLoop();
                }
            }
            else if(curPoint.getParentList().size() > 1)
            {
                randNum = rand.nextInt(100);

                if(randNum > 80)
                {
                    relocate();
                }
                else
                {
                    if(position.equals("FL"))
                    {
                        forwardLoop();
                    }
                    else if(position.equals("RL"))
                    {
                        reverseLoop();
                    }            
                }
            }
        }
        else
        {
            if(curPoint.getParentList().size() > 1)
            {
                relocate();
            }
            else
            {
                cornerRoad();
            }
            
        }
        
        //System.out.println("\n\nPOINT ID: " + this.curPoint.getID() + "  ("  +this.curPoint.getLongitude() + " , " + this.curPoint.getLatitude() + " )");
        //System.out.println("Node Index: "  + this.NodeIndex  + "    ref Size: " + this.curRoad.getDetailedRef().size()  + "   position: " + this.position);
        
        //for (Object ref : this.curRoad.getDetailedRef()) 
        //{
        //    System.out.print(ref + " , ");
        //}
        
        //System.out.println("OUT");
    }
    
    private void cornerRoad()
    {
        randNum = rand.nextInt(100);
        
        if(randNum >= 20)
        {
            if(position.equals("FL"))
            {
                position = "RL";
                reverseLoop();
            }
            else if(position.equals("RL"))
            {
                position = "FL";
                forwardLoop();
            } 
        }
        else
        {
            //System.out.println("I'm Stuck:  "  + randNum);
            //SetUp();     
        }
    }
    
    private void relocate()
    {
        randNum = rand.nextInt(curPoint.getParentList().size());
        
        Road tempRoad = (Road) curPoint.getParentList().get(randNum);
        
        if(!curRoad.getID().equals(tempRoad.getID()))
        {
            curRoad = tempRoad;
            
            for(int i=0; i < curRoad.getDetailedRef().size(); i++)
            {
                if(curPoint.getID().equals(curRoad.getDetailedRef().get(i)))
                {
                    this.NodeIndex = i;
                    
                    if(position.equals("RL"))
                    {
                        reverseLoop();
                    }
                    else if(position.equals("FL"))
                    {
                        forwardLoop();
                    } 

                    break;              
                }
            }
        }
        else
        {
            if(!(NodeIndex <=0 || NodeIndex >= this.curRoad.getDetailedRef().size() -1))
            {
                if(position.equals("FL"))
                {
                    forwardLoop();
                }
                else if(position.equals("RL"))
                {
                    reverseLoop();
                } 
            }
            else if(NodeIndex <=0 || NodeIndex >= this.curRoad.getDetailedRef().size() -1)
            {        
                do
                {
                    randNum = rand.nextInt(curPoint.getParentList().size());
                
                }while(randNum == NodeIndex);
 
                curRoad = (Road) curPoint.getParentList().get(randNum);

                for(int i=0; i < curRoad.getDetailedRef().size(); i++)
                {
                    if(curPoint.getID().equals(curRoad.getDetailedRef().get(i)))
                    {
                        this.NodeIndex = i;

                        if(position.equals("RL"))
                        {
                            reverseLoop();
                        }
                        else if(position.equals("FL"))
                        {
                            forwardLoop();
                        } 


                        break;              
                    }
                }
                                 
            }
            else
            {
                System.out.println("BROKEN");
            }
        }
        
        
    
    
    }
    
    
    
 
    public Color getColor(){return color;}
    

}
