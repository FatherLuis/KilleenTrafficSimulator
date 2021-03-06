/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Vehicles.Instructions;

import Main.Database;
import Main.Init.Point;
import Main.Init.Road;
import Main.Operators.Intersection;
import Main.Operators.RoadNode;
import Main.Operators.StopSign;
import java.util.Random;

/**
 *
 * @author fathe
 */
public class Instructions3 
{
    private Route route;
    
    private Road curRoad;
    
    private RoadNode curPoint;   
    
    private String position;  
    private int RoadIndex;
    private int NodeIndex;  
    private Random rand = new Random();
    
    
    private boolean isMoveable = true; 
    private boolean inAccident = false;
    
    
    private int randNum;
    
    
    
    private double rate = 1;
    
    private double speed;
        
    private int wait = 0; 
    
    public double x;
    public double y;
    
    

    private String vehicleID;
    public Instructions3(int vehicleID)
    {
        this.route = new Route();
        this.setUpLocation();
        
        this.vehicleID = String.valueOf(vehicleID);
    }
    
    
    private void setUpLocation()
    {
        RoadIndex = rand.nextInt(Database.getRoadListSize());

        curRoad = Database.getRoad(RoadIndex);

        NodeIndex = rand.nextInt(curRoad.getRef().size());

        String ID = (String) curRoad.getRef().get(NodeIndex);

        curPoint = (RoadNode)Database.getPoint(ID);
        
        this.speed = curRoad.getSpeed();
        
        x = curPoint.getLongitude();
        y = curPoint.getLatitude();
        
        if(rand.nextInt(101) > 99 && rand.nextInt(101) > 99)
        {
            inAccident = true;
            isMoveable = false;
            Database.addAccident();
        
        }


        randNum = rand.nextInt(100);

        if(randNum > 55)
        {
            position = "FL";
        }
        else
        {
            position = "RL";

        }
        
        if(curRoad.isOneWay()){position = "FL";}
        
        
        

    }
    
    
    public Point getPoint(){return curPoint;}
    public void setPoint(Point p){this.curPoint = (Intersection)p;}
    public double getSpeed(){return speed;}
    public Road getRoad(){return curRoad;}  
    
    public void setInAccident(boolean inAccident)
    { 
        this.inAccident = inAccident;
        
        if(inAccident == true){Database.addAccident();}else{Database.subAccident();}
    }
    public boolean getInAccident(){ return this.inAccident;}
    
    public void setIsMovable(boolean isMove){ this.isMoveable = isMove;}
    
    
    
    public String getDirection()
    {
        return position;
    }
    
    
    private void basicMove()
    {                  
        if(position.equals("FL"))
        {
            forwardLoop(); 
        }
        else if(position.equals("RL"))
        {
            reverseLoop();
        }
    }
    
    
    private void forwardLoop()
    {
        String ID;
            
        if(!route.onRoute())
        {    
            if(NodeIndex < this.curRoad.getRef().size()-1)
            {
                
                ID = (String) curRoad.getRef().get(NodeIndex);
                Point p1 = Database.getPoint(ID);

                if((curPoint instanceof StopSign && this.curRoad.getType().equals("residential")))
                {
                    isMoveable = false;
                    wait = 5;
                }                
                
                
                //System.out.println("FL   old: " + NodeIndex + " new: " + (NodeIndex+1));
                NodeIndex++;
                ID = (String) curRoad.getRef().get(NodeIndex);
                
                //curPoint.removeVehicle(vehicleID);
                curPoint = (RoadNode)Database.getPoint(ID);
                //curPoint.addVehicle(vehicleID);

                route.newRoute(p1, curPoint);
                           
                this.x = route.getLongitude();
                this.y = route.getLatitude();
                route.update(rate);
                
                //possibleRelocate();
                
               
                
                
            }
            else
            {
                //System.out.println("FL PROBLEM");
            
            }
        }
        else if (route.onRoute())
        {
            this.x = route.getLongitude();
            this.y = route.getLatitude();
            route.update(rate);    
            
            if(!route.onRoute())
            {
                move(rate);
            }
        }
        else
        {
            //System.out.println("FL PROBLEM");
        }
        
        
        
        
    }
    
    private void reverseLoop()
    {   

        String ID;

        if(!route.onRoute())
        {        
            if(NodeIndex > 0)
            {
                ID = (String) curRoad.getRef().get(NodeIndex);
                Point p1 = Database.getPoint(ID);

                //System.out.println("RL   old: " + NodeIndex + " new: " + (NodeIndex-1));

                if((curPoint instanceof StopSign && this.curRoad.getType().equals("residential")))
                {
                    isMoveable = false;
                    wait = 5;
                }                
                
                NodeIndex--;
                ID = (String) curRoad.getRef().get(NodeIndex);
                
                //curPoint.removeVehicle(vehicleID);
                curPoint = (RoadNode)Database.getPoint(ID);
                //curPoint.addVehicle(vehicleID);

                route.newRoute(p1, curPoint);
                         
                this.x = route.getLongitude();
                this.y = route.getLatitude();
                route.update(rate);
                
                //possibleRelocate();

                
                
            }           
            else
            {
                //System.out.println("RL PROBLEM");
            
            }
        }
        else if (route.onRoute())
        {
            this.x = route.getLongitude();
            this.y = route.getLatitude();
            route.update(rate);
            
            if(!route.onRoute())
            {
                move(rate);
            }
            
            
        }
        else
        {
            //System.out.println("RL PROBLEM");
        }
        
        
        
    }
    
    public void move(double rate)
    {
        this.rate = rate;
        


        if(isMoveable)
        {
            if(!route.onRoute())
            {      
                if(NodeIndex == 0 || NodeIndex == curRoad.getRef().size() - 1)
                { 
                    if(curPoint instanceof Intersection )
                    {
                        if(((Intersection)curPoint).hasParents())
                        {
                            //System.out.println("\n1REL?");
                            relocate();
                            //System.out.println("2REL?");

                            basicMove();
                        }
                        else
                        {
                            cornerRoad(); 
                        }
                    }
                    else
                    {
                        //System.out.println("\n1CR?");
                        cornerRoad(); 
                        //System.out.println("2CR?");
                    }   
                }    
                else
                {
                    possibleRelocate();
                    basicMove();
                }
            }
            else
            {
                basicMove();
            }

        }
        else
        {
            //System.out.println("WAITING");
            
            if(!inAccident)
            {
                wait--;

                if(wait ==0){isMoveable = true;}
            }
        }


        
    }
    
    private void relocate()
    {
        Road tempRoad;
        Intersection p = (Intersection) curPoint;
        
        do
        {        
            randNum = rand.nextInt(p.getParentList().size());
            tempRoad = (Road) p.getParentList().get(randNum);
            
            
            //System.out.print("LOOP  ");

                

        }while(curRoad.getID().equals(tempRoad.getID()));
        
        //System.out.println();

        curRoad = tempRoad; 
        
        this.speed = curRoad.getSpeed();
        
        for(int i=0; i < curRoad.getRef().size(); i++)
        {
            if(curPoint.getID().equals(curRoad.getRef().get(i)))
            {
                this.NodeIndex = i;
                
                if(NodeIndex == 0)
                {
                    position = "FL";
                }
                else if(NodeIndex == curRoad.getRef().size() - 1 )
                {
                    position = "RL";
                }
                else
                {
                    randNum = rand.nextInt(100);
                    
                    if(randNum > 70)
                    {                
                        position = "FL";
                    }
                    else
                    {
                        position = "RL";
                    }
                }
                
                if(curRoad.isOneWay()){position = "FL";}
                         
 
                break;              
            }
        }
    }   
         
    private void cornerRoad()
    {
        
        setUpLocation();
//        randNum = rand.nextInt(100);
//        
//        if(randNum >= 20)
//        {
//            
//            if(NodeIndex == 0)
//            {
//                position = "FL"; 
//            }
//            else if(NodeIndex == curRoad.getRef().size() - 1 )
//            {
//                position = "RL";  
//            } 
//            
//            basicMove();
//        }
//        else
//        {
//            //System.out.println("I'm Stuck");
//            setUpLocation();    
//        }
    }
    
    private void possibleRelocate()
    {
        Intersection p;
        randNum = rand.nextInt(100);
 
        if(curPoint instanceof Intersection && randNum > 70)
        {
            p = (Intersection) curPoint;
            randNum = rand.nextInt(p.getParentList().size());
            Road tempRoad = (Road) p.getParentList().get(randNum);

            if(!(curRoad.getID().equals(tempRoad.getID())))
            {
                //System.out.println("\nold Road: " + curRoad.getID());
                //System.out.println("new Road: " + tempRoad.getID());
                
                
                curRoad = tempRoad; 
                this.speed = curRoad.getSpeed();

                for(int i=0; i < curRoad.getRef().size(); i++)
                {
                    if(curPoint.getID().equals(curRoad.getRef().get(i)))
                    {
                        this.NodeIndex = i;

                        if(NodeIndex == 0)
                        {
                            position = "FL";
                        }
                        else if(NodeIndex == curRoad.getRef().size() - 1 )
                        {
                            position = "RL";
                        }
                        else
                        {
                            randNum = rand.nextInt(100);

                            if(randNum > 70)
                            {                
                                position = "FL";
                            }
                            else
                            {
                                position = "RL";
                            }
                        }

                        //System.out.println("Node ID: " + curPoint.getID() +"   MADE THE CHANGE");     
                        if(curRoad.isOneWay()){position = "FL";}
                        
                        //basicMove();
                        
                        break;              
                    }
                }
            }
            else
            {//System.out.println("Node ID: " + curPoint.getID() +"   DIDNT MAKE THE CHANGE");
                
            }
        }


        
    }   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    private void forwardLoop()
//    {
//        System.out.println("Forward     " + NodeIndex);
//
//        if(NodeIndex < this.curRoad.getRef().size() - 1)
//        {        
//            if(!route.onRoute())
//            {
//                NodeIndex++; 
//                
//                if(NodeIndex != this.curRoad.getRef().size())
//                {
//                             
//                    String ID = (String) curRoad.getRef().get(NodeIndex);
//                    Point p1 = PHT.getPoint(ID);
//
//                    ID = (String) curRoad.getRef().get(NodeIndex + 1);
//                    Point p2 = PHT.getPoint(ID);
//
//                    route.newRoute(p1, p2);
//                }
//                else
//                {
//                    String ID = (String) curRoad.getRef().get(NodeIndex);
//                    curPoint = PHT.getPoint(ID); 
//                    possibleRelocate();
//                
//                }
//            }
//            else
//            {
//                route.update(this.rate);
//                
//                this.x = route.getLongitude();
//                this.y = route.getLatitude();
//                
//                System.out.println("x: " + route.getLongitude() + "  y: " + route.getLatitude() );
//                
//            }
//            
//                       
//            if((curPoint instanceof StopSign))
//            {
//                isMoveable = false;
//                wait = 5;
//            }
//         }     
//        else
//        {
//            //System.out.println("Node Index on FL  "  + NodeIndex);
//        }
//
//    }
//    
//    private void reverseLoop()
//    {        
//        if(NodeIndex > 0)
//        {            
//            if(!route.onRoute())
//            {
//                NodeIndex--; 
//                
//                if(NodeIndex != 0)
//                {
//                             
//                    String ID = (String) curRoad.getRef().get(NodeIndex);
//                    Point p1 = PHT.getPoint(ID);
//
//                    ID = (String) curRoad.getRef().get(NodeIndex - 1);
//                    Point p2 = PHT.getPoint(ID);
//
//                    route.newRoute(p1, p2);
//                }
//                else
//                {
//                    String ID = (String) curRoad.getRef().get(NodeIndex);
//                    curPoint = PHT.getPoint(ID); 
//                    possibleRelocate();
//                
//                }
//            }
//            else
//            {
//                route.update(this.rate);
//                this.x = route.getLongitude();
//                this.y = route.getLatitude();
//                
//                System.out.println("x: " + route.getLongitude() + "  y: " + route.getLatitude() );
//                
//            }
//            
//                       
//            if((curPoint instanceof StopSign))
//            {
//                isMoveable = false;
//                wait = 5;
//            }
//        }
//        else
//        {
//            //System.out.println("Node Index on RL  "  + NodeIndex);
//        }
//            
//
//    }
//    

    
    
}