package Main.Init;

import java.util.ArrayList;

/*******************************************************************************
***CLASS NAME: Point
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
***CO-AUTHOR: NONE 
********************************************************************************
***PURPOSE OF CLASS: POINTS ARE A COLLECTION OF COORDINATES FOR A GIVEN ROAD
* POINTS COULD ALSO BE USED TO REPRESENT INTERSECTIONS, STOP SIGNS, AND OTHER
********************************************************************************
***DATE: SEPTEMBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class Point
{
    String nodeID;
    private double longitude;
    private double latitude;
    
    private ArrayList<Road> parentList;
 
    
    /***************************************************************************
    ***METHOD NAME: Point()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public Point(String nodeID)
    {
        this.nodeID = nodeID;
        parentList = new ArrayList();
    }
    
    
    /***************************************************************************
    ***METHOD NAME: getID()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN NODE'S ID
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: STRING
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/    
    public String getID(){return this.nodeID;}
    
    
    /***************************************************************************
    ***METHOD NAME: getLongitude()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE LONGITUDE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: DOUBLE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/
    public double getLongitude() 
    {
        return longitude;
    }

    /***************************************************************************
    ***METHOD NAME: setLongitude
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE LONGITUDE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: DOUBLE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /***************************************************************************
    ***METHOD NAME: getLatitude()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN LATITUDE()
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: DOUBLE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/
    public double getLatitude() {
        return latitude;
    }

    /***************************************************************************
    ***METHOD NAME: setLatitude()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE LATITUDE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: DOUBLE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/
    public void setLatitude(double latitude) 
    {
        this.latitude = latitude;
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
    public ArrayList getParentList() {
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
        this.parentList.add(parentID);
    }    
}
