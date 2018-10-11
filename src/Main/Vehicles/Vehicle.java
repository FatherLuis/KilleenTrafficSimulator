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
    
    private double longitude;
    private double latitude;
    
    private Road curRoad;
    private Point curPoint;
    
    
    
    private int RoadIndex;
    private int NodeIndex;

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

    }
    
    public void move()
    {
        
        ArrayList arr;
        Random rand = new Random();

        if(NodeIndex < this.curRoad.getRef().size()-1)
        {
            //System.out.println("NodeIndex: " + NodeIndex + "   Size: " + this.curRoad.getRef().size());
            
            this.NodeIndex+= 1;
            String ID = (String) curRoad.getRef().get(NodeIndex);
            
            curPoint = PHT.getPoint(ID);
        
        }
        else if(NodeIndex == this.curRoad.getRef().size())
        {
            
            NodeIndex = 0;
            String ID = (String) curRoad.getRef().get(NodeIndex);
            curPoint = PHT.getPoint(ID);
//            arr = PHT.getPoint((String) curRoad.getRef().get(NodeIndex)).getParentList();
//            
//            if(!arr.isEmpty())
//            {
//                int n = rand.nextInt(3);
//
//                this.curRoad = (Road) arr.get(n);
                
                
//            }   
        }
        
        
        
    
    }
    
    
    
}
