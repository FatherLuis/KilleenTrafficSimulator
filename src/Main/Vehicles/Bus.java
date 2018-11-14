/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

import Main.Vehicles.Instructions.Instructions3;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/*******************************************************************************
***CLASS NAME: Bus
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: MORE DETAILED VEHICLE 
********************************************************************************
***DATE: OCTOBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class Bus extends Vehicle
{
    private Ellipse2D.Double shape;
    
    /***************************************************************************
    ***METHOD NAME: Bus
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INSTRUCTIONS3
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 28, 2018
    ***************************************************************************/     
    public Bus() 
    {
        super(); 
        color = Color.YELLOW;
        speed = 25;
    }
    
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
    @Override
    public void move(double rate)
    {
        GPS.move(rate*speed*500);
        speed = GPS.getSpeed();
    }
    
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
    @Override
    public void draw(Graphics2D g,double x1,double y1, double d1,double d2,double scalar)
    {
        if(trackable)
        {
             g.draw(new Rectangle2D.Double(x1 - (d1), y1-(d1), 3*d1, 3*d1 ));
        
        }
        
        if(GPS.getInAccident())
        {
            g.setColor(Color.RED);
            
            if(count == 0)
            {
                g.draw(new Ellipse2D.Double(x1 - (d1), y1-(d1), d2*3, d2*3));
                count++;
            }
            else
            {
                count--;
            }
        }
        
                
        //COVERS AREA OF THE SHAPE
        Area a1 = new Area(new Ellipse2D.Double(x1,y1,d1,d2));   
        
        //shape = new Ellipse2D.Double(x1,y1,d1,d2);
        //g.draw(shape);
        
        //SHAPE IS FILLED
        g.fill(a1);
    
    }
    
    
    
}
