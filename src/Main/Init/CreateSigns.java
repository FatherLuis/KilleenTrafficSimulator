/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Init;

import Main.Database;
import Main.Operators.Intersection;
import Main.Operators.StopSign;
import java.util.ArrayList;

/*******************************************************************************
***CLASS NAME: CreateSigns
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: CREATE STOPSIGNS AND STOP LIGHTS ON MAP
********************************************************************************
***DATE: OCTOBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class CreateSigns 
{   
    
    /***************************************************************************
    ***METHOD NAME: CreateSigns
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: POINTHASHTABLE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/
    public CreateSigns ()
    {   
    }
    
    /***************************************************************************
    ***METHOD NAME: createStopSigns
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHANGE POINT OBJECT TO STOP SIGN OBJECT
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: ROAD
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/
    public void createStopSigns(Road curRoad)
    {
        if(curRoad.getType().equals("residential"))
        {
            //System.out.println("OOOF");
            StopSign ss;
                
            ArrayList curRef = (ArrayList)curRoad.getRef();
                
            Point p1 = null;

            for(int i = 0; i < curRef.size(); i++)
            {
                p1 = Database.getPoint((String)curRef.get(i));
               
                if(p1 instanceof Intersection)
                {        
                    ss = new StopSign((Intersection)p1);
                    Database.addPoint(ss); 
                }   
            }  
        }
    }
    
    
    
    
    
    
    
    
    
    
}
