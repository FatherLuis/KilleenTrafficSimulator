/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Init;

import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Init.Road;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fathe
 */
public class FixRoad 
{
    private ArrayList newRef;
    private PointHashTable PHT;
    
    private Road curRoad;
    
    private Random rand;
    
    public FixRoad(PointHashTable PHT)
    {   
        this.PHT = PHT;
        this.rand = new Random();
    }
    
    
    public ArrayList newRef(Road curRoad)
    {
        
        double distance = 0;
        
        newRef = new ArrayList();
        
        ArrayList curRef = (ArrayList)curRoad.getRef().clone();
                
        Point p1 = null;
        Point p2 = null;
        
        
        double desiredDistance = (5.0 * Math.pow(10, -5)); // -9
        //boolean next = true;
        
        for(int i = 0; i < curRef.size()-1; i++)
        {
            p1 = PHT.getPoint((String)curRef.get(i));
            p2 = PHT.getPoint((String)curRef.get(i+1));
            
            distance = euclideanDistance(p1,p2);
            
            if(i ==0)
            {
                newRef.add(curRef.get(i));
                //System.out.println("--" + curRef.get(i));
            }
            
           // System.out.println(" BEFORE " +  curRef.get(i));
            
            if(distance > desiredDistance)
            {
                createSubPoints(desiredDistance,distance, p1, p2);
            }
             
            newRef.add(curRef.get(i+1));
            //System.out.println("--" + curRef.get(i+1));
            //next = false;
            
            
            //System.out.println(" AFTER " +  curRef.get(i+1) + "\n");
            
        }
        
        
        return this.newRef;
    }
    
    
    private double euclideanDistance(Point p1, Point p2)
    {
        double dY = p2.getLatitude() - p1.getLatitude();
        double dX = p2.getLongitude() - p1.getLongitude();
        
        
        return   Math.sqrt((Math.pow(dY,2) + Math.pow(dX,2)));
    
    }
    
    private void createSubPoints(double desiredDistance,double distance,Point p1, Point p2)
    {
        int extra = rand.nextInt(1000);
        
        
        boolean forwardLoop= true;
        ArrayList subRef = new ArrayList();
        int numSlices = (int) (distance / desiredDistance);
        
        if(numSlices > 2)
        {
            /////////////////////////////////////////////////////////

            double deltaX = p2.getLongitude() - p1.getLongitude();
            double deltaY = p2.getLatitude() - p1.getLatitude();

            

            double slope;
            double x1 = 0;
            double y1 = 0;
            String ID = "";
            double newY = 0;
            double newX = 0;


            Point newPoint = null;

            double change = 0;


            if(deltaX != 0)
            {
                
                
                slope = deltaY/deltaX;
                
                //System.out.println("Distance: " + distance);
                //System.out.println("Desired Distance " + desiredDistance);
                //System.out.println("Change of X: " + deltaX + "   \nChange of Y: " + deltaY);
                //System.out.println("Slope: " + slope);
                //System.out.println("Number of slices " + numSlices);
                //System.out.println("Delta X: " + change);

                change = Math.abs(deltaX) / numSlices ;


                
                if(p2.getLongitude() > p1.getLongitude())
                {
                    //lowest longitude
                    forwardLoop = true;

                    x1 = p1.getLongitude();

                    newX = x1;

                    y1 = p1.getLatitude();

                    ID = p1.getID();
                }
                else if (p2.getLongitude() < p1.getLongitude())
                {
                    //lowest longitude
                    forwardLoop = false;

                    x1 = p2.getLongitude();
                    
                    newX = x1;
                    
                    y1 = p2.getLatitude();
                    
                    ID = p2.getID();
                }
                else
                {
                    System.out.println("\n\n BROKEN \n\n");
                }
                
                
                
                

               ///////////////////////////////////////// 
                for(int i=0; i < numSlices; i++)
                {

                    newX += change;

                    newY = slope * (newX - x1) + y1;

                    newPoint = new Point(ID + "."+ Integer.toString(extra) + "00" + i);
                    newPoint.setLatitude(newY);
                    newPoint.setLongitude(newX);

                    PHT.put(newPoint);

                    subRef.add(ID + "."+ Integer.toString(extra) + "00" + i);
                } 
            }
            else if(deltaX == 0)
            {

                if(p2.getLatitude() > p1.getLatitude())
                {
                    forwardLoop = true;
                    newY = p1.getLatitude();
                    newX = p1.getLongitude();

                    ID = p1.getID();
                }
                else
                {
                    forwardLoop = false;
                    newY = p2.getLatitude();
                    newX = p2.getLongitude();

                    ID = p2.getID();

                }


                change = Math.abs(deltaY) / numSlices;

                for(int i=0; i < numSlices; i++)
                {
                    newY += change;

                    newPoint = new Point(ID + "." + Integer.toString(extra) + "00" + i);
                    newPoint.setLatitude(newY);
                    newPoint.setLongitude(newX);

                    PHT.put(newPoint);

                    subRef.add(ID + "."+ Integer.toString(extra) + "00" + i);
                }                  
            }
            else
            {
                System.out.println("\nBROKEN\n");
            }
            
            
                            
            if(forwardLoop)
            {
                for(int i = 0; i < subRef.size(); i++)
                {
                    this.newRef.add(subRef.get(i));
                    
                    //System.out.println("     " + subRef.get(i));
                }
            }
            else
            {
                for(int i = subRef.size() -1; i >= 0; i--)
                {
                    this.newRef.add(subRef.get(i));    
                    //System.out.println("     " + subRef.get(i));
                }     
            } 
            
            
            
            
        }
    }
    
    
    public PointHashTable getPHT()
    {
        return this.PHT;
    }
    
    
    
    
    
    
}
