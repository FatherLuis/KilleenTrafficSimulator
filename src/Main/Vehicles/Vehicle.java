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
    
    private String lanePosition;
    
    private int RoadIndex;
    private int NodeIndex;
    
    private Random rand = new Random();
    
    private int changePrb;
    
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
        Random rand = new Random();
        int  n;
        int k;
        
        
        
            RoadIndex = rand.nextInt(this.RoadList.size());
        
            curRoad = this.RoadList.get(RoadIndex);
            
            NodeIndex = rand.nextInt(curRoad.getRef().size());

            String ID = (String) curRoad.getRef().get(NodeIndex);

            curPoint = PHT.getPoint(ID);
            
            int direction = rand.nextInt(100);
                
            if(direction > 55){lanePosition = "RIGHT"; color = Color.BLUE;}else{lanePosition = "LEFT";color = Color.RED;}
            
            //lanePosition = "RIGHT"; color = Color.BLUE;

    }
   
    
    private void forwardLoop()
    {
        if(NodeIndex < this.curRoad.getRef().size()-1)
        {
            //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getRef().size());

            this.NodeIndex += 1;
            String ID = (String) curRoad.getRef().get(NodeIndex);

            curPoint = PHT.getPoint(ID);

        }    
    }
    
    private void reverseLoop()
    {
        if(NodeIndex > 0)
        {
            //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getRef().size());

            this.NodeIndex -= 1;
            String ID = (String) curRoad.getRef().get(NodeIndex);

            curPoint = PHT.getPoint(ID);
        }    
    }
    
    
    private void move()
    {
        if(curPoint.getParentList().size() == 1)
        {
            if(lanePosition.equals("FL"))
            {
                forwardLoop();
            }
            else if(lanePosition.equals("RL"))
            {
                reverseLoop();
            }
        
        
        }
        else if(curPoint.getParentList().size() > 1)
        {
            int possible = rand.nextInt(100);
            
            if(possible > 80)
            {
                relocate();
            }
            else
            {
                if(lanePosition.equals("FL"))
                {
                    forwardLoop();
                }
                else if(lanePosition.equals("RL"))
                {
                    reverseLoop();
                }            
            }
            
            
            //cornerRoad();
        }
    }
    
    
    private void cornerRoad(){}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public void move()
//    {
//        if(lanePosition.equals("RIGHT"))
//        {
//            RightLaners();
//        }
//        else if(lanePosition.equals("LEFT"))
//        {
//            LeftLaners();
//        }
//    }
//    
//    private void LeftLaners()
//    {
//        if(curPoint.getParentList().size() > 1)
//        {
//            int dec = rand.nextInt(100);
//                
//            if(dec > 75)
//            {
//                relocate();
//            }
//        }
//
//        if(NodeIndex > 0)
//        {
//            //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getRef().size());
//
//            this.NodeIndex -= 1;
//            String ID = (String) curRoad.getRef().get(NodeIndex);
//
//            curPoint = PHT.getPoint(ID);
//
//        }
//        else if(NodeIndex <= 0)
//        {
//            relocate();
//        }       
//        else
//        {
//            System.out.println("SOMEONE CRACKED");
//        }                
//    }
//    
//    private void RightLaners()
//    {
//        if(curPoint.getParentList().size() > 1)
//        {
//            int dec = rand.nextInt(100);
//                
//            if(dec > 75)
//            {
//                relocate();
//            }
//        }
//
//        
//        if(NodeIndex < this.curRoad.getRef().size()-1)
//        {
//            //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getRef().size());
//
//            this.NodeIndex += 1;
//            String ID = (String) curRoad.getRef().get(NodeIndex);
//
//            curPoint = PHT.getPoint(ID);
//
//        }
//        else if(NodeIndex >= this.curRoad.getRef().size()-1)
//        {
//            relocate();
//        }          
//        else
//        {
//            System.out.println("SOMEONE CRACKED");
//        } 
//            
//    
//    }
//    
//    private void relocate()
//    {
//        ArrayList<Road> arr;
//        arr = curPoint.getParentList();
//
//        //System.out.println("curPoint: " + curPoint.getID());
//        if(arr.size() > 1)
//        {
//            //System.out.println("ParentSize: " + arr.size());
//            
//            int r = rand.nextInt(arr.size());
//           
//            curRoad = arr.get(r);
//            
//            for(int i = 0; i < curRoad.getRef().size();i++)
//            {
//                if(curPoint.getID().equals(curRoad.getRef().get(i)))
//                {
//                    NodeIndex = i;
//                    
//                    int direction = rand.nextInt(100);
//
//                    if(direction > 85){lanePosition = "RIGHT";color = Color.BLUE;}else{lanePosition = "LEFT"; color =Color.RED;}  
//                    
//                    if((NodeIndex == curRoad.getRef().size()-1) )
//                    {
//                        lanePosition = "LEFT"; color = Color.RED;
//                    }       
//                    else if(NodeIndex == 0)
//                    {
//                        lanePosition = "RIGHT"; color = Color.BLUE;
//                    }
//                    break;
//                }
//                
//
//            }
//            
//
//        }
//        else if(arr.size() == 1 )
//        {
//            //System.out.println("ParentSize: " + arr.size());
//            //System.out.println("NO PARENT HELP");
//               
//
//            int direction = rand.nextInt(100);
//
//            if(direction >85){lanePosition = "RIGHT";color = Color.BLUE;}else{lanePosition = "LEFT"; color = Color.RED;}
//                               
//        }  
//        else
//        {
//        
//            //System.out.println("ParentSize: " + arr.size());
//            //System.out.println("SOMEONE CRACKED");
//        }
//    }
//    
    public Color getColor(){return color;}
    

}
