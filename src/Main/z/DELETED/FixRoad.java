/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.z.DELETED;

import Main.z.DELETED.FixRoadThread;
import Main.Init.Point;
import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Init.PointHashTable;
import Main.Init.Road;
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
    private Random rand;
    
    public FixRoad(PointHashTable PHT)
    {   
        this.PHT = PHT;
        this.rand = new Random();
    }
    
//    
//    public ArrayList newRef(Road curRoad) throws InterruptedException
//    {
//              
//        ArrayList curRef = (ArrayList)curRoad.getRef().clone();
//
//        int length = curRef.size();
//        
//        //System.out.println("LENGTH  " + length);
//        int size = 0;
//        
//        String[] copy = null;
//        String[] copy2 = null;
//        
//        
//        
//        
//        if(length >= 10)
//        {
//            if(length % 2 == 0)
//            {
//                //System.out.println(  "           EVEN" );
//
//                size = length / 2;
//                //System.out.println("SIZE  " + size);
//
//                copy = new String[size];
//                copy2 = new String[size];
//
//                int count  = 0;
//
//                for (int n = 0; n < length; n++)
//                {
//                    //System.out.print("iteration   "  + n);
//
//                    if(n < size)
//                    {
//                        //System.out.println(  n + " ");
//                        copy[count] = (String)curRef.get(n);
//
//                        //System.out.print("   COPY 1  \n");
//                        count++;           
//
//                        if( count == size)
//                        {
//                            count = 0;
//
//                        }
//
//                    }
//                    else if(n >= size && n < length)
//                    {                   
//                        //System.out.println(  n + " ");
//                        copy2[count] = (String)curRef.get(n);
//                        //System.out.print("   COPY 2  \n");
//                        count++;
//
//                    }
//
//
//                } 
//            }     
//            else
//            {
//                //System.out.println(  "           ODD" );
//
//                size = length / 2;
//                //System.out.println("SIZE  " + size);
//
//                copy = new String[size];
//                copy2 = new String[size+1];
//
//                int count  = 0;
//
//                for (int n = 0; n < length; n++)
//                {
//                    //System.out.print("iteration   "  + n);
//
//                    if(n < size)
//                    {
//                        //System.out.println(  n + " ");
//                        copy[count] = (String)curRef.get(n);
//
//                        //System.out.print("   COPY 1  \n");
//                        count++;           
//
//                        if( count == size)
//                        {
//                            count = 0;
//
//                        }
//
//                    }
//                    else if(n >= size && n < length)
//                    {                   
//                        //System.out.println(  n + " ");
//                        copy2[count] = (String)curRef.get(n);
//                        //System.out.print("   COPY 2  \n");
//                        count++;
//
//                    }
//
//                }   
//            }    
//            
//            //System.out.println("Copy One Size: " + copy.length);
//            //System.out.println("Copy Two Size: " + copy2.length);
//
//
//            FixRoadThread FRT1 = new FixRoadThread(this.PHT, copy, 1);
//            FixRoadThread FRT2 = new FixRoadThread(this.PHT, copy2, 2);
//
//            FRT1.start();
//            FRT2.start();
//
//            FRT1.join();
//            FRT2.join();
//
//    //        while(FRT1.isAlive() || FRT2.isAlive())
//    //        {
//    //
//    //
//    //        }
//    //        
//            //System.out.println("Thread 1 "+FRT1.getNewRef().size());
//            //System.out.println("Thread 2 "+FRT2.getNewRef().size());
//
//            
//            
//            this.newRef =  FRT1.getNewRef();
//
//            this.newRef.addAll(FRT2.getNewRef());
//            
//            //System.out.println("COMBINE SIZE: " + this.newRef.size());
//            //System.out.println("\n");
//            
//
//            
//            
//            
//            
//            
//        }
//        else
//        {
//            copy = new String[length];
//            
//            for(int n=0; n < length; n++)
//            {
//                copy[n] = (String)curRef.get(n);
//            }   
//            
//            FixRoadThread FRT1 = new FixRoadThread(this.PHT, copy, 3);
//            
//            FRT1.start();
//            FRT1.join();
//            
//            //System.out.println("Copy 3 Size: " + copy.length);
//            //System.out.println("Thread 3 "+FRT1.getNewRef().size());
//            
//
//            this.newRef =  FRT1.getNewRef();
//            
//            //System.out.println("EL SIZE: " + this.newRef.size() + " \n");
//            
//        }
//        
//
//
//
//       //this.newRef =
//
//
//
//        
//
//        return this.newRef;
//        
//        //return curRef;
//        
//    }
//    
//    
    
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList newRef(Road curRoad)
    {
        
        double distance = 0;
        
        newRef = new ArrayList();
        
        ArrayList curRef = (ArrayList)curRoad.getRef().clone();
                
        Point p1 = null;
        Point p2 = null;
        
        
        double desiredDistance = (1.0 * Math.pow(10, -5)); // -9
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
