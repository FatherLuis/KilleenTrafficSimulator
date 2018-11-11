package Main.Vehicles;

import Main.Vehicles.Instructions.Instructions3;
import Main.Init.Point;
import Main.Init.Road;
import java.awt.Color;
import java.awt.Graphics2D;



/*******************************************************************************
***CLASS NAME: Vehicle
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: SUPER CLASS FOR CARS OBJECTS
********************************************************************************
***DATE: OCTOBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class Vehicle 
{
    protected Color color;
    protected Instructions3 GPS;
    protected double speed;
    
    protected int vehicleID;
    protected boolean trackable;
    
    private static int vehicleCount;
    
    protected int count;
    


    /***************************************************************************
    ***METHOD NAME: Vehicle
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INSTRUCTIONS3
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/  
    public Vehicle(Instructions3 GPS)
    {        
        vehicleID = vehicleCount;
        this.GPS = GPS;   
        trackable = false;
        
        vehicleCount++;
    }
    
    public int getID()
    {
        return vehicleID;
    }
    
    public Point getPoint(){return GPS.getPoint();}
    public void setPoint(Point p){GPS.setPoint(p);}
    
    public double getCorX(){return GPS.x;}
    public double getCorY(){return GPS.y;}
    
    
    public Road getRoad(){return GPS.getRoad();}
    
    public double getSpeed(){return GPS.getSpeed();}
    
    public void setInAccident(boolean inAccident)
    { 
        GPS.setInAccident(inAccident);
        
        if(inAccident)
        {
            GPS.setIsMovable(false);
        }
        else
        {
            GPS.setIsMovable(true);
        }
    
    }
    public boolean getInAccident(){ return GPS.getInAccident();}
    

    /***************************************************************************
    ***METHOD NAME: move()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: MOVE OBJECT 
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/
    public void move(double rate) { GPS.move(rate*1000); }
    

    public Color getColor(){return color;}
    public void setColor(Color color){ this.color = color;}
    
    public void setTrackable(boolean track){ this.trackable = track;}
    
    /***************************************************************************
    ***METHOD NAME: draw()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: DRAW OBJECT
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: GRAPHICS2D, XCOR, YCOR, DIAMETER(WIDTH), DIAMETER(HEIGHT)
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/    
    public void draw(Graphics2D g,double x1,double y1, double d1,double d2,double scalar){}
    

}
