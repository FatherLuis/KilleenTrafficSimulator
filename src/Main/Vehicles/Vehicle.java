package Main.Vehicles;

import Main.Init.Point;
import java.awt.Color;
import java.util.Random;

public class Vehicle 
{
    Color color;
    Instructions GPS;

   
    public Vehicle(Instructions GPS)
    {
        SetUp();
        
        this.GPS = GPS;
        
    }
    public Point getPoint(){return GPS.getPoint();}
    public void setPoint(Point p){GPS.setPoint(p);}
    
    private void SetUp()
    {
        Random rand = new Random();
        
        if(rand.nextInt(100) > 55)
        {
            color = Color.BLUE;
        }
        else
        {
            color = Color.RED;
        }
        
        
        
    }
    
    public void move()
    {
        GPS.move();
    }
    
   

    
    public Color getColor(){return color;}
    

}
