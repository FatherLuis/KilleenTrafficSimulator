/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.z.DELETED;

import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Init.Road;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author fathe
 */
public class ObstacleSeer 
{
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Road> roads;
    private PointHashTable PHT;
    
    public ObstacleSeer(ArrayList<Vehicle> vehicles,ArrayList<Road> roads , PointHashTable PHT)
    {
        this.vehicles = vehicles;
        this.roads = roads;
        this.PHT = PHT;
    }
    
    
//    public int forSee(Point curPoint, Road curRoad, String position)
//    {
////        int distance;
////        
////        for(int i = 0; i < vehicles.size() ; i++)
////        {
////            if(vehicles.get(i).getRoad().getID().equals(curRoad.getID()) && !(vehicles.get(i).getDirection().equals(position)))
////            {
////                distance = distance(curPoint,vehicles.get(i).getPoint(),curRoad);
////                
////                if(distance > 8)
////                {
////                    return 2;
////                }                
////                else if(distance > 6)
////                {
////                    return 4;
////                }                
////                else if(distance > 4)
////                {
////                    return 6;
////                }
////                                
////                else if(distance > 2)
////                {
////                    return 8;
////                }
////            }
////        }
////        
////        
////        return 1;
//
//    }
    
    
    private int distance(Point p1, Point p2, Road curRoad)
    {
        int p1Index = 0;
        int p2Index = 0;
        
        int k= 0;
        
        for(int i=0; i < curRoad.getDetailedRef().size(); i++)
        {
            if(p1.getID().equals(curRoad.getDetailedRef().get(i)))
            {
                p1Index = i;
                k++;
            }         
            
            if(p2.getID().equals(curRoad.getDetailedRef().get(i)))
            {
                p2Index = i;
                k++;
            }
            
            if(k == 2)
            {
                break;
            }
        }  
        
        
    
    
    
        return Math.abs(p1Index - p2Index);
    }
    
    
    
    
    
    
    
    
    
    
}
