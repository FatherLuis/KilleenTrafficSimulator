package Main.Vehicles;

import Main.Database;
import Main.Init.Point;
import Main.Init.Road;
import Main.Operators.Intersection;
import Main.Operators.StopSign;
import Main.Vehicles.Instructions.Route;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;



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
    protected double speed;
    protected Instructions GPS;
    
    
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
    public Vehicle()
    {        
        vehicleID = vehicleCount;
        this.GPS = new Instructions();   
        trackable = false;
        
        vehicleCount++;
    }
    
    public int getID(){return vehicleID;}
    
    public Point getPoint(){return GPS.getPoint();}
    public void setPoint(Point p){GPS.setPoint(p);}
    
    public double getCorX(){return GPS.x;}
    public double getCorY(){return GPS.y;}
    
    public Road getRoad(){return GPS.getRoad();}
    public double getSpeed(){return speed;}
    public boolean getInAccident(){ return GPS.getInAccident();}    
    
    public Color getColor(){return color;}
    public void setColor(Color color){ this.color = color;}    
    
    
    public void setMoveable(boolean moveable){ this.GPS.setIsMovable(moveable);}
    
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
      
    public void setTrackable(boolean track){ this.trackable = track;}
    
  
    
    
    
    
    public void move(double input) 
    {
        GPS.move(input); 
    }
    

    


    public void draw(Graphics2D g,double x1,double y1, double d1,double d2,double scalar){}







    protected class Instructions
    {
        private Route route;

        private Road curRoad;
        private Intersection curPoint;  
        
        private String position;  
        
        private int RoadIndex;
        private int NodeIndex;  
        
        
        private Random rand = new Random();
        private boolean isMoveable = true; 
        private boolean inAccident = false;


        private int randNum;
        
        private double rate;
        private int wait; 

        
        
        public double x;
        public double y;



        public Instructions()
        {
            this.route = new Route();
            this.setUpLocation();
        }


        private void setUpLocation()
        {
            RoadIndex = rand.nextInt(Database.getRoadListSize());

            curRoad = Database.getRoad(RoadIndex);

            NodeIndex = rand.nextInt(curRoad.getRef().size());

            String ID = (String) curRoad.getRef().get(NodeIndex);

            curPoint = Database.getPoint(ID);

            speed = curRoad.getSpeed();

            x = curPoint.getLongitude();
            y = curPoint.getLatitude();

            if(rand.nextInt(101) > 99 && rand.nextInt(101) > 99)
            {
                inAccident = true;
                isMoveable = false;
                Database.addAccident();

            }


            

            if(rand.nextInt(100) > 55)
            {
                position = "FL";
            }
            else
            {
                position = "RL";

            }




        }


        public Point getPoint(){return curPoint;}
        public void setPoint(Point p){this.curPoint = (Intersection)p;}
        
        public Road getRoad(){return curRoad;}  

        public void setInAccident(boolean inAccident)
        { 
            this.inAccident = inAccident;

            if(inAccident == true){Database.addAccident();}else{Database.subAccident();}
        }
        public boolean getInAccident(){ return this.inAccident;}

        public void setIsMovable(boolean isMove){ this.isMoveable = isMove;}
        
        public void subWait(){wait--;}
        
 
        
        
        
        public void move(double rate)
        {
            this.rate = rate;
            
            if(isMoveable)
            {
            
            
            
            }
            
            
            
            
            
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

        }

        private void reverseLoop()
        {   


        }



        private void relocate()
        {
        }   

        private void cornerRoad()
        {
        }

        private void possibleRelocate()
        {
        
        
        }

    }   

    
    

}
