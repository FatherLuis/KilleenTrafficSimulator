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
public class Intersection extends Point
{    
    protected ArrayList<Road> parentList;
    
    protected ArrayList incomingVehicles;
    
    public Intersection(Point p) 
    {
        super(p.getID());
        latitude = p.getLatitude();
        longitude = p.getLongitude();
        this.parentList = new ArrayList();
        this.incomingVehicles = new ArrayList();
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
    
    
    public void addVehicle(String vehicleID)
    {
        
        this.incomingVehicles.add(vehicleID);
    
    }
    
    public void removeVehicle(String vehicleID)
    {
        this.incomingVehicles.remove(vehicleID);
    }
    
    public ArrayList getIncomingVehicles(){return this.incomingVehicles;}
    
    
    
}
