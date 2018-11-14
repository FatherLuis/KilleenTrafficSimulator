/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Operators;

import Main.Init.Point;
import Main.Init.Road;
import java.util.ArrayList;

/**
 *
 * @author fathe
 */
public class RoadNode extends Point
{    
    protected ArrayList incomingVehicles;
    
    private Road road;
    
    public RoadNode(Point point) 
    {
        super(point.getID());    
        latitude = point.getLatitude();
        longitude = point.getLongitude();
        this.incomingVehicles = new ArrayList();
    }    
    
    
    public void addVehicle(String vehicleID)
    {
        
        this.incomingVehicles.add(vehicleID);
    
    }
    
    public void removeVehicle(String vehicleID)
    {
        this.incomingVehicles.remove(vehicleID);
    }
    
    public ArrayList getIncomingVehicles(){return this.incomingVehicles;}
    
    public void setRoad(Road road){this.road = road;}
    public Road getRoad(){return road;}
    
    
    
}
