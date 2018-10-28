/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Operators;

import Main.Init.Point;

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
public class StopSign extends Point
{  
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
        super(p.getID()); 
        this.latitude = p.getLatitude();
        this.longitude = p.getLongitude();
        this.parentList = p.getParentList();
    }
    
}
