/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles.Instructions;

import Main.Database;
import Main.Init.Point;
import Main.MapBuilder.RoadNode;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author fathe
 */
public class CollisionDetection
{

    public CollisionDetection()
    {
    
    
    }
    
    
    public boolean isNearObsticles(int vehicleID, RoadNode incomingPoint)
    {
        
        Vehicle v1 = Database.getVehicle(vehicleID);
        
        ArrayList listVehicles = incomingPoint.getIncomingVehicles();
        
        
        
        if(!listVehicles.isEmpty())
        {
            for(int i=0; i < listVehicles.size(); i++)
            {
                if(
                        isCloseDistance(v1, Database.getVehicle(Integer.parseInt(String.valueOf(listVehicles.get(i))))) && 
                        v1.getID()!=Database.getVehicle(Integer.parseInt(String.valueOf(listVehicles.get(i)))).getID() &&
                        v1.getDistanceFromPoint() > Database.getVehicle(Integer.parseInt(String.valueOf(listVehicles.get(i)))).getDistanceFromPoint() &&
                        v1.getPosition().equals(Database.getVehicle(Integer.parseInt(String.valueOf(listVehicles.get(i)))).getPosition())
                        
                  )
                {
                    return true;

                }


            }
        }
        
        return false;
    }
    
    
    
    public boolean isCloseDistance(Vehicle v1, Vehicle v2)
    {
        
        return Math.abs(v1.getDistanceFromPoint() - v2.getDistanceFromPoint()) < 1.0 * Math.pow(10, -4);
        
        
    }
    

    
}
