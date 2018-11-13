/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Operators;

import Main.Init.Point;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;

/*******************************************************************************
***CLASS NAME: StopSign
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: TAKE A POINT OBJECT AND CONVERT TO STOP SIGN OBJECT
********************************************************************************
***DATE: OCTOBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class StopSign extends Intersection
{  
    
    ArrayList<Vehicle> queueVehicles;

    
    /***************************************************************************
    ***METHOD NAME: StopSign()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: POINT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/
    public StopSign(Point p) 
    {
        super(p); 
        //queueVehicles = new ArrayList();
    }
    
    
    public void addToQueue(Vehicle vehicle)
    {
        queueVehicles.add(vehicle);
        
    
    }
    
    public void updateQueue()
    {
        
        
    
    
    }
    
    
    
    
    
}
