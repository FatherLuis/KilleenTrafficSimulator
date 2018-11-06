/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Building;

import Main.Init.Point;
import java.time.LocalTime;

/**
 *
 * @author emilyfarias
 */

/*
    In the XML file, the schools have a key of "amenity" and a value of "school"
*/
public class School extends Point
{
    
    private String name;

    public School(Point p) 
    {
        super(p.getID()); 
        this.latitude = p.getLatitude();
        this.longitude = p.getLongitude();
    }
    
    public void SetName(String name)
    {
        this.name = name;
    }
    
    public String GetName()
    {
        return name;
    }
    /***************************************************************************
    ***METHOD NAME: IsActive
    ****************************************************************************
    ***PURPOSE OF THE METHOD: Returns true if school-zone should have lower speed.
    * will return true if the string sent indicates that the current time is between 
    * 6:45 and 9:00 or between 2:30 and 4:30 . This method does not take into
    * account the difference between AM or PM.
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: String 
    ***RETURN VALUE: boolean
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/
    public boolean IsActive(String currentTime)
    {
        LocalTime theCurrentTime = LocalTime.parse(currentTime);
        
        return 
        (
            (theCurrentTime.isAfter(LocalTime.parse("07:00:00")) && theCurrentTime.isBefore(LocalTime.parse("09:00:00"))) 
                
                ||
                
            (theCurrentTime.isAfter(LocalTime.parse("14:30:00")) && theCurrentTime.isBefore(LocalTime.parse("16:30:00")))
                
        );

    }
    
    
    
    
    
}
