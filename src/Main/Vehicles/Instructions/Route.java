package Main.Vehicles.Instructions;

import Main.Init.Point;

/*******************************************************************************
***CLASS NAME: Route
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: HELP VEHICLE MOVE FROM ONE POINT TO ANOTHER
********************************************************************************
***DATE: OCTOBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class Route 
{
    
    private final double standardInc = 5.0 * Math.pow(10,-9);
    
    private double increments;
    
    private double x1;
    private double y1;
    
    private double newX;
    private double newY;
    
    private double slope;
    private String direction;
    
    private boolean isMoving;
    
    private Point finalP;
    
    private boolean isUsable;
    
    private double prev;
    
    /***************************************************************************
    ***METHOD NAME: Route()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/ 
    public Route()
    {
        isMoving = false;
        direction = "";
        isUsable = true;
        prev = 1.0;
    }
    
    /***************************************************************************
    ***METHOD NAME: newRoute()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: NEW FORMULA CONSTRUCTED FOR VEHICLE
    ***METHOD USED: increments()
    ***METHOD PARAMETERS: Point, Point
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOTOBER 28, 2018
    ***************************************************************************/     
    public void newRoute(Point FROM_p1, Point TO_p2)
    {       
        isUsable = true;
        isMoving = true;
        prev = 1.0;
        
        double deltaX = TO_p2.getLongitude() - FROM_p1.getLongitude();    
        double deltaY = TO_p2.getLatitude() - FROM_p1.getLatitude();
        
        x1 = FROM_p1.getLongitude();
        y1 = FROM_p1.getLatitude();
        newX = FROM_p1.getLongitude();
        newY = FROM_p1.getLatitude();
        
        finalP = TO_p2;
        
        
        if(deltaX != 0)
        {
            this.slope = deltaY/deltaX;
            
            increments = increments(deltaY,deltaX, "x");

            newX = FROM_p1.getLongitude();
            newY = FROM_p1.getLatitude();

            if(FROM_p1.getLongitude() < TO_p2.getLongitude())
            {
                direction = "+";         
            }
            else if(FROM_p1.getLongitude() > TO_p2.getLongitude())
            {
                direction = "-";
            }
            else if(FROM_p1.getLongitude() == TO_p2.getLongitude())
            {
                System.out.println("THERE ARE EQUAL");
            } 
            else
            {
                System.out.println("OPERAND");
            }
        }
        else if(deltaX == 0)
        {
            isUsable = false;
            
            increments = increments(deltaY, deltaX, "y");
                    
            if(FROM_p1.getLatitude() < TO_p2.getLatitude())
            {
                direction = "+";         
            }
            else if(FROM_p1.getLatitude() > TO_p2.getLatitude())
            {
                direction = "-";
            }
        }
        else
        {
            System.out.println("MISSING SOMETHING");
        }
        
        
        
    }
    
    /***************************************************************************
    ***METHOD NAME: update()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: UPDATE THE LOCATION OF THE OBJECT
    ***METHOD USED: isTooFar()
    ***METHOD PARAMETERS: INT
    ***RETURN VALUE: none
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/     
    public void update(double rate)
    {
        double oldx = newX;
        double oldy = newY;
        
        if(isUsable)
        {
            if(direction.equals("+"))
            {
                newX += increments * rate;
                newY = slope * (newX  - x1) + y1;

            }
            else if(direction.equals("-"))
            {
                newX -= increments * rate;
                newY = slope * ((newX) - x1) + y1;
            }  
            else
            {
                System.out.println("DIRECTION NOT SET");
            }
        }  
        else
        {
            if(direction.equals("+"))
            {
                newY += increments * rate;

            }
            else if(direction.equals("-"))
            {
                newY -= increments * rate;
            }      
            else
            {
                System.out.println("DIRECTION NOT SET");
            }            
        }
        
        
        
                
        if(isTooFar())
        {
            newX = oldx;
            newY = oldy;
            //System.out.println("roo foo");
            isMoving = false;
        }  
        
        
    }
    
    /***************************************************************************
    ***METHOD NAME:  increments()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE STANDARD INCREMENTS OBJECT WILL TAKE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: DOUBLE, DOUBLE, STRING
    ***RETURN VALUE: DOUBLE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/     
    private double increments(double dY, double dX,String variable)
    {   
        double d = Math.sqrt((Math.pow(dY,2) + Math.pow(dX,2)));
        
        if(variable.equals("x"))
        {
            return Math.abs(dX) / (d / standardInc);
        }   
        else
        {
            return Math.abs(dY) / (d / standardInc);
        }
        
        
        
        
    
    }
    
    /***************************************************************************
    ***METHOD NAME: isTooFar()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHECKS IF VEHICLE PASS THE FINAL POINT
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: BOOLEAN
    ****************************************************************************
    ***DATE: OCTOBER 28 2018
    ***************************************************************************/     
    private boolean isTooFar()
    {       
        double dY = finalP.getLatitude() - newY;
        double dX = finalP.getLongitude() - newX;
        
        double d = Math.sqrt((Math.pow(dY,2) + Math.pow(dX,2)));
        
        if( prev > d)
        {
            prev = d;
            
            return false;
        }
        else
        {   
            return true;
        
        }    
    }

    /***************************************************************************
    ***METHOD NAME: onRoute()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHECKS IF THE OBJECT IS STILL ABLE TO MOVE 
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: BOOLEAN
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/     
    public boolean onRoute()
    {
        return isMoving;
    }
    
    /***************************************************************************
    ***METHOD NAME: getLontitude()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN LONGITUDE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: DOUBLE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/     
    public double getLongitude(){ return newX;}
    
    /***************************************************************************
    ***METHOD NAME: getLatitude()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN LATITUDE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: DOUBLE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/  
    public double getLatitude(){ return newY;}   
    
}
