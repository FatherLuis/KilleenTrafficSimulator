/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles;

import Main.Init.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author fathe
 */
public class PersonalCar extends Vehicle
{
    Ellipse2D.Double shape;
    
    public PersonalCar(Instructions2 GPS) 
    {
        super(GPS);
        this.GPS = GPS; 
        color = Color.GREEN;
        increments = 5;
    }

    @Override
    public void move(int rate)
    {
        GPS.move(rate*increments);
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
