/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

import Main.Init.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author fathe
 */
public class Bus extends Vehicle
{
    Ellipse2D.Double shape;
    
    public Bus(Instructions GPS) 
    {
        super(GPS);
        this.GPS = GPS; 
        color = Color.YELLOW;
    }

    @Override
    public void move()
    {
        GPS.move();
    }

    @Override
    public void draw(Graphics2D g,double x1,double y1, double d1,double d2)
    {
                
        Area a1 = new Area(new Ellipse2D.Double(x1,y1,d1,d2));   
        //shape = new Ellipse2D.Double(x1,y1,d1,d2);
        //g.draw(shape);
        g.fill(a1);
    
    }
    
    
    
}
