/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Operators;

import Main.Init.Point;
import Main.Init.Road;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;





public class Intersection extends Point
{      
    protected ArrayList<Road> parentList;
    protected ArrayList<Vehicle> incomingVehicles;
    
    public Intersection(Point point) 
    {
        super(point.getID()); 
        this.latitude = point.getLatitude();
        this.longitude = point.getLongitude();
        
        parentList = new ArrayList();
        incomingVehicles = new ArrayList();
    }
    
    
     /***************************************************************************
    ***METHOD NAME: getParentList()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN ParentList
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: ArrayList
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/
    public ArrayList<Road> getParentList() {
        return this.parentList;
    }

    /***************************************************************************
    ***METHOD NAME: setParentList()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE ParentList
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: String
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/
    public void addParent(Road parentID) 
    {
        if(!this.parentList.isEmpty())
        {
            if(!this.parentList.contains(parentID))
            {
                this.parentList.add(parentID);
            }
        }
        else
        {
            this.parentList.add(parentID);
        }
            
    } 
    
    public boolean hasParents()
    {
        return this.parentList.size() > 1;
    }    
    
    
    
    public void addIncomingVehicle(Vehicle vehicle)
    {
        incomingVehicles.add(vehicle);
    }
    
    public void removeIncomingVehicle(Vehicle vehicle)
    {
        incomingVehicles.remove(vehicle);
    }
    
    
    
}
