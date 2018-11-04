/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles.Instructions;

import Main.Normalization;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author fathe
 */
public class Tracker 
{
    
    private ArrayList<Vehicle> vehicleList;
    private double[] Bounds;
    
    private double width;
    private double height;
    
    private Normalization normCalcX;
    private Normalization normCalcY;
    
    public Tracker(ArrayList<Vehicle> vehicleList, double[] bounds, double width, double height)
    {
        this.vehicleList = vehicleList;
        this.Bounds = bounds;
        
        this.width = width;
        this.height = height;
        
    }
    
    
    
    public void find(double lon, double lat)
    {
        normalizeZone();
    
        
        for(int i=0; i < vehicleList.size();i++)
        {
        
            if(distance(lon,lat,vehicleList.get(i).getCorX(),vehicleList.get(i).getCorY()))
            {
                System.out.println("FOUND");
            }
        }
        
        System.out.println("DID NOT FIND\n\n");
        
    }
    
    
    private boolean distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(y2-y1,2) + Math.pow(x2-x1,2)) < 1.0*Math.pow(10,-6);
    
    
    
    }
    
    private void normalizeZone()
    {
        //FIRST PARAMATER IS THE MAX LONGITUDE
        //SECOND PARAMETER IS THE MIN LONGITUDE
        //THIRD PARAMETER IS THE MAX X COORDINATE
        //FOURTH PARAMETER IS THE MIN X COORDINATE
        normCalcX = new Normalization(this.Bounds[3],this.Bounds[1], this.width, 0 );
                
        //FIRST PARAMATER IS THE MAX LATITUDE
        //SECOND PARAMETER IS THE MIN LATITUDE
        //THIRD PARAMETER IS THE MAX X LATITUDE
        //FOURTH PARAMETER IS THE MIN X LATITUDE
        normCalcY = new Normalization(this.Bounds[2],this.Bounds[0], this.height, 0 );
    }    
    
    
    
    public void setWidth(double width)
    {
        this.width = width;
    }
    
    public void setHeight(double height)
    {   
        this.height = height;
    }
    
    
    
    
    
    
    
}
