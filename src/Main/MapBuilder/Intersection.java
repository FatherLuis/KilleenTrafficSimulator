/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.MapBuilder;

import Main.Init.Road;
import java.util.ArrayList;

/**
 *
 * @author fathe
 */
public class Intersection extends RoadNode
{    
    protected ArrayList<Road> parentList;
    

    
    public Intersection(RoadNode p) 
    {
        super(p);
        this.parentList = new ArrayList();

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
    public ArrayList<Road> getParentList() 
    {
        return this.parentList;
    }
    
    
    public void addParent(Road road)
    {
        boolean pass = true;
        
        //System.out.println("\n\nCOMING IN:  " + road.getName() + "   " +road.getID());
        
        if(!this.parentList.isEmpty())
        {
            
            for(int i=0; i < parentList.size(); i++)
            {
                //System.out.print("Already Here:  " + this.parentList.get(i).getID() + ",  ");
                
                if(this.parentList.get(i).getID().equals(road.getID()))
                {
                    pass = false;
                }

            }
            
            if(pass)
            {
                
                this.parentList.add(road);
            }
            
        }
        else
        {
            this.parentList.add(road);
        
        }
    }
    
    public boolean hasParents()
    {
        return this.parentList.size() > 1;
    }   
    
    

    
}
