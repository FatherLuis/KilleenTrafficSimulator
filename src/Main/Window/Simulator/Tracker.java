/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Window.Simulator;

import Main.Database;
import Main.Normalization;

/**
 *
 * @author fathe
 */
public class Tracker 
{
    public Tracker()
    {
    }    
    

    
    
    
    public int find(double lon, double lat)
    {
        
        boolean isFound = false;
        
        int k = 0;
        //System.out.println("LON:  " + lon + "  LAT: " + lat);
        for(int i=0; i < Database.getVehicleListSize();i++)
        {
            //System.out.println(" \nV LON:  " + vehicleList.get(i).getCorX() + "  V LAT: " + vehicleList.get(i).getCorY());
            
        
            if(distance(lon,lat,Database.getVehicle(i).getCorX(),Database.getVehicle(i).getCorY()))
            {
                if(!isFound)
                {
                    k = i;
                    Database.getVehicle(i).setTrackable(true);
                    isFound = true;
                }
                else
                {
                    Database.getVehicle(i).setTrackable(false);
                }

                
                //System.out.println("\n\nFOUND\n\n");
            }
            else
            {
                Database.getVehicle(i).setTrackable(false);
            }
        }
        
        if(isFound)
        {
            return k;
        }
        else
        {
            return -1;
        }
        
        //System.out.println("DID NOT FIND\n\n");
        
    }
    
    
    private boolean distance(double x1, double y1, double x2, double y2)
    {
        
        //System.out.println(Math.sqrt(Math.pow(y2-y1,2) + Math.pow(x2-x1,2)) );
        return Math.sqrt(Math.pow(y2-y1,2) + Math.pow(x2-x1,2)) < 1.5*Math.pow(10,-4);
    
    
    
    } 
    
    
    
    
    
    
    
}
