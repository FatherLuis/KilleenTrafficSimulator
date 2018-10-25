package Main.Vehicles;

import Main.Init.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Vehicle 
{
    Color color;
    Instructions GPS;

   
    public Vehicle(Instructions GPS)
    {        
        this.GPS = GPS;   
    }
    public Point getPoint(){return GPS.getPoint();}
    public void setPoint(Point p){GPS.setPoint(p);}

    
    public void move()
    {
        GPS.move();
    }
    

    public Color getColor(){return color;}
    public void setColor(Color color){ this.color = color;}
    
        
    public void draw(Graphics2D g,double x1,double y1, double d1,double d2)
    {}
    

}
