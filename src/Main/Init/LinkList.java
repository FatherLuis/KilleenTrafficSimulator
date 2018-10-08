package Main.Init;

import Main.Init.Point;

/*******************************************************************************
***CLASS NAME: LinkList
***CLASS AUTHOR: Luis E Vargas Tamayo
********************************************************************************
***PURPOSE OF CLASS: Data Structure of a LinkList
********************************************************************************
***DATE: September 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: none
********************************************************************************
***SPECIAL NOTES: none
*******************************************************************************/
public class LinkList 
{
    
    private Point point;
    private LinkList nextLL;
    
    /***************************************************************************
    ***METHOD NAME: getPoint()
    ***METHOD AUTHOR: Luis E Vargas Tamayo
    ****************************************************************************
    ***PURPOSE OF THE METHOD: return object Point
    ***METHOD USED: none
    ***METHOD PARAMETERS: none
    ***RETURN VALUE: Point
    ****************************************************************************
    ***DATE: September 28, 2018
    ***************************************************************************/
    public Point getPoint()
    {
        return point;
    }  
    
    /***************************************************************************
    ***METHOD NAME: getPoint()
    ***METHOD AUTHOR: Luis E Vargas Tamayo
    ****************************************************************************
    ***PURPOSE OF THE METHOD: getNextLink()
    ***METHOD USED: none
    ***METHOD PARAMETERS: none
    ***RETURN VALUE: LinkList
    ****************************************************************************
    ***DATE: September 28, 2018
    ***************************************************************************/ 
    public LinkList getNextLink()
    {
        return nextLL;
    } 
    
    /***************************************************************************
    ***METHOD NAME: setPoint()
    ***METHOD AUTHOR: Luis E Vargas Tamayo
    ****************************************************************************
    ***PURPOSE OF THE METHOD: set the value for object type Point
    ***METHOD USED: none
    ***METHOD PARAMETERS: Point
    ***RETURN VALUE: none
    ****************************************************************************
    ***DATE: September 28, 2018
    ***************************************************************************/
    public void setPoint(Point point)
    {
        this.point = point;
    } 
    
    /***************************************************************************
    ***METHOD NAME: getPoint()
    ***METHOD AUTHOR: Luis E Vargas Tamayo
    ****************************************************************************
    ***PURPOSE OF THE METHOD: setLinkList
    ***METHOD USED: none
    ***METHOD PARAMETERS: LinkList
    ***RETURN VALUE: none
    ****************************************************************************
    ***DATE: September 28, 2018
    ***************************************************************************/
    public void setLinkList(LinkList link) 
    {
        this.nextLL = link;
    }
    
}
