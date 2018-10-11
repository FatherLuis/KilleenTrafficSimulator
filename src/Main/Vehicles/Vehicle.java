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
            
            int direction = rand.nextInt(10);
                
            if(direction > 5){lanePosition = "RIGHT"; color = Color.BLUE;}else{lanePosition = "LEFT";color = Color.RED;}

    }
    
    public void move()
    {
        if(lanePosition.equals("RIGHT"))
        {
            RightLaners();
        }
        else if(lanePosition.equals("LEFT"))
        {
            LeftLaners();
        }
    }
    
    private void LeftLaners()
    {
        if(curPoint.getParentList().size() != 1)
        {
            relocate();
        }

            if(NodeIndex > 0)
            {
                //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getRef().size());

                this.NodeIndex-= 1;
                String ID = (String) curRoad.getRef().get(NodeIndex);

                curPoint = PHT.getPoint(ID);

            }
            else if(NodeIndex == 0)
            {
                relocate();
            }              
            
        
        
    }
    
    private void RightLaners()
    {
        if(curPoint.getParentList().size() != 1)
        {
            relocate();
        }

        
            if(NodeIndex < this.curRoad.getRef().size()-1)
            {
                //System.out.println("FIRST IF      NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getRef().size());

                this.NodeIndex+= 1;
                String ID = (String) curRoad.getRef().get(NodeIndex);

                curPoint = PHT.getPoint(ID);

            }
            else if(NodeIndex == this.curRoad.getRef().size()-1)
            {
                relocate();
            }    
            
    
    }
    
    private void relocate()
    {
            ArrayList<Road> arr;
            arr = curPoint.getParentList();
            
            if(arr.size() > 1)
            {
                int r = rand.nextInt(arr.size());
                curRoad = arr.get(r);
                
                for(int i = 0; i < curRoad.getRef().size();i++)
                {
                    if(curPoint.getID().equals(curRoad.getRef().get(i)))
                    {
                        NodeIndex = i;
                        break;
                    }
                }
                
                
                if(!curRoad.isOneWay())
                {
                    int direction = rand.nextInt(10);
                
                    if(direction > 5){lanePosition = "RIGHT";color = Color.BLUE;}else{lanePosition = "LEFT"; color =Color.RED;}
                
                }
            }
            else
            {
                if(lanePosition.equals("LEFT")){lanePosition = "RIGHT"; color = Color.BLUE;}else{lanePosition = "LEFT"; color = Color.RED;}
            }  
    }
    
    public Color getColor(){return color;}
    

}
