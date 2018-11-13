/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Building.School;
import Main.Vehicles.Vehicle;
import Main.Init.Road;
import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Normalization;
import Main.Window.TrafficPanel;
import Main.Window.TrafficPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

/*******************************************************************************
***CLASS NAME: Drawable
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
***CO-AUTHOR:
********************************************************************************
***PURPOSE OF CLASS: CLASS WILL DRAW OBJECTS FOR TRAFFIC PANEL
********************************************************************************
***DATE: OCTUBER 5, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class Drawable 
{
    
    private Database database;
    
    private Normalization normCalcX;
    private Normalization normCalcY;
    
    private int WIDTH = 10000;
    private int HEIGHT = 9000;
    
    private double scaler = 1;
    double shiftX;
    double shiftY;

    
    
    
    /***************************************************************************
    ***METHOD NAME: Drawable
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/    
    public Drawable()
    {
        //g = TP.getGraphics();
        normalizeZone();
    }


    /***************************************************************************
    ***METHOD NAME: normalizeZone()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: NORMALIZE DATA TO A GIVEN RANGE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/    
    private void normalizeZone()
    {
        //FIRST PARAMATER IS THE MAX LONGITUDE
        //SECOND PARAMETER IS THE MIN LONGITUDE
        //THIRD PARAMETER IS THE MAX X COORDINATE
        //FOURTH PARAMETER IS THE MIN X COORDINATE
        //normCalcX = new Normalization( this.Bounds[3],this.Bounds[1], this.WIDTH, 0 );
        
        normCalcX = new Normalization(database.getBounds(3), database.getBounds(1), this.WIDTH, 0);
                
        //FIRST PARAMATER IS THE MAX LATITUDE
        //SECOND PARAMETER IS THE MIN LATITUDE
        //THIRD PARAMETER IS THE MAX X LATITUDE
        //FOURTH PARAMETER IS THE MIN X LATITUDE
        //normCalcY = new Normalization(this.Bounds[2],this.Bounds[0], this.HEIGHT, 0 );
        normCalcY = new Normalization(database.getBounds(2), database.getBounds(0), this.HEIGHT, 0);
    }


    /***************************************************************************
    ***METHOD NAME: OperationY
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: TRANSFORMS CARTESIAN Y-CORDINATE TO JAVA CORDINATE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/    
    private double OperationY(double y)
    {
        //NEGATIVE VALUE
        //double newY = -y;
        //ADD THE HEIGHT OF WINDOW
        return -y + this.HEIGHT;
    }    
    

    
    /***************************************************************************
    ***METHOD NAME: DrawRoad()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: Draws Roads
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/    
    public void DrawRoad(Graphics g)
    {

        //DRAWING IN A 2D FIELD
        
        //Graphics2D g3 = (Graphics2D) g.create();
        //Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, 0);
        //g3.setStroke(dashed); 
        //g3.setColor(Color.yellow);
        
        
        
        
        /////////////////////////////////////////////////
        Graphics2D pen = (Graphics2D) g.create();
        pen.setStroke(new BasicStroke(1));
        //MAKE THE LINES NICER (?)
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setColor(Color.DARK_GRAY);
        /////////////////////////////////////////////////
        
        Point p ;
        double x1;
        double y1 ;

        Point p2;
        double x2 ;
        double y2;
        
        
        ArrayList<String> curRoadPoints;
        
        //ITERATE BY THE NUMBER OF ROADS ON THE ARRAYLIST
        for(int i = 0; i < database.getRoadListSize() ; i++)
        {
//            if(scaler <= 1 && database.getRoad(i).getType().equals("Residential"))
//            {
            
            
                //USE AS A REFERNCE TO THE CURRENT ROAD REF ARRAYLIST
                curRoadPoints = database.getRoad(i).getRef();

                //ITERATES BY THE SIZE OF THE CURRENT ROAD REF ARRAYLIST
                for(int j = 0 ; j < curRoadPoints.size() - 1 ; j++)
                {
                        //GETS THE OBJECT POINT FROM THE HASHTABLE
                        p =database.getPoint(curRoadPoints.get(j));

                        //GETS THE OBJECT POINT FROM THE HASHTABLE
                        p2 =database.getPoint(curRoadPoints.get(j+1));

                        if(p == null)
                        {
                                System.out.println("p NULL");
                        }
                        if(p2 == null)
                        {
                                System.out.println("p2 NULL");
                        }                    


                        //CONVERT THE POINT'S LONGITUDE TO X COORDINATE
                        x1 = shiftX(normCalcX.Normalize(p.getLongitude()));
                        //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
                        y1 = shiftY(OperationY(normCalcY.Normalize(p.getLatitude())));


                        //CONVERT THE POINT'S LONGITUDE TO X COORDINATE
                        x2 = shiftX(normCalcX.Normalize(p2.getLongitude()));
                        //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
                        y2 = shiftY(OperationY(normCalcY.Normalize(p2.getLatitude())));


                        //DRAW A LINE FROM P1 TO P2
                        pen.draw(new Line2D.Double(x1,y1,x2,y2)); 
                        //g3.draw(new Line2D.Double(x1,y1,x2,y2));


                        //Ellipse2D.Double shape = new Ellipse2D.Double((int)x1-5,(int)y1-5,10,10);

                        //g3.setColor(this.vehicleList.get(i).getColor());
                        //pen.draw(shape);

                        //shape = new Ellipse2D.Double((int)x2-5,(int)y2-5,10,10);

                        //g3.setColor(this.vehicleList.get(i).getColor());
                        //pen.draw(shape);   
                }                 


//            }
        }    
    
    }
    
    

    
    /***************************************************************************
    ***METHOD NAME: DrawCar()
    ***METHOD AUTHOR: 
    ****************************************************************************
    ***PURPOSE OF THE METHOD: DRAWS VEHICLES
    ***METHOD USED: 
    ***METHOD PARAMETERS: 
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/   
    public void DrawCar(Graphics g)
    {
        Graphics2D g3 = (Graphics2D) g.create();
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        //g3.setColor(Color.BLUE);

        
        double x1;
        double y1;
        double d;
        double r;
        
        Ellipse2D.Double shape;
        
        for(int i = 0; i < database.getVehicleListSize(); i++)
        {
            g3.setColor(database.getVehicle(i).getColor());
            
            x1 = shiftX(normCalcX.Normalize(database.getVehicle(i).getCorX()));
            //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
            y1 = shiftY(OperationY(normCalcY.Normalize(database.getVehicle(i).getCorY())));


            //subtract the x and y by the radius
            //since there is a scalar, we'll gonna be to figure out something
            
            d = 4*scaler; 
            r = d/2;
//            
//            
//            shape = new Ellipse2D.Double(x1-r,y1-r,d,d);
//
//            //g3.setColor(this.vehicleList.get(i).getColor());
//            g3.draw(shape);
            database.getVehicle(i).draw(g3, x1-r, y1-r, d, d,scaler);


        }
        
    }
    
    
    public void DrawSchools(Graphics g)
    {       
        Random rand = new Random();
        
        Graphics2D g3 = (Graphics2D) g.create();
    
        double x1;
        double y1;
        double d;
        double r;
        
        Ellipse2D.Double shape;
        
        for(int i = 0; i < database.getSchoolListSize(); i++)
        {
            g3.setColor(Color.cyan);
            
            x1 = shiftX(normCalcX.Normalize(database.getSchool(i).getLongitude()));
            //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
            y1 = shiftY(OperationY(normCalcY.Normalize(database.getSchool(i).getLatitude())));


            //subtract the x and y by the radius
            //since there is a scalar, we'll gonna be to figure out something
            
            d = 6 * (this.scaler)* rand.nextInt(2)+1;
            r = d/2;
//            
//            
            shape = new Ellipse2D.Double(x1-r,y1-r,d,d);

            //g3.setColor(this.vehicleList.get(i).getColor());
            g3.draw(shape);
            //this.schoolList.get(i).draw(g3, x1-r, y1-r, d, d);


        }
    }
    
    
    public void updateVehicles(int rate)
    {
        for(int i = 0; i < database.getVehicleListSize(); i++)
        {
            database.getVehicle(i).move(rate);
        }
    }
    
    
    
    private double shiftX(double x)
    {
        return (x + shiftX)*this.scaler;
    
    }
    
    
    private double shiftY(double y)
    {
        return (y + shiftY)*this.scaler;
    }
    
    
//    public double[] getBounds()
//    {
//        return this.Bounds;
//    
//    
//    }
//    
//    public ArrayList<Vehicle> getVehicles()
//    {
//        return this.vehicleList;
//    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////    
    
//    public void setVehicleList(ArrayList v){this.vehicleList = v;}
//    
//    public void setSchoolList(ArrayList<School> schoolList)
//    {
//        this.schoolList = schoolList;
//    }
//    
    
//     /***************************************************************************
//    ***METHOD NAME: setAllRoads()
//    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
//    ****************************************************************************
//    ***PURPOSE OF THE METHOD: STORE ARRAY OF TYPE ROADS
//    ***METHOD USED: NONE
//    ***METHOD PARAMETERS: ARRAYLIST
//    ***RETURN VALUE: NONE
//    ****************************************************************************
//    ***DATE: OCTUBER 5 , 2018
//    ***************************************************************************/   
//    public void setAllRoads(ArrayList roads){ this.RoadList = roads;}
//    
//    
//    /***************************************************************************
//    ***METHOD NAME: setMaxMinBounds() 
//    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
//    ****************************************************************************
//    ***PURPOSE OF THE METHOD: SET THE BOUNDARY INFORMATION IN VARIABLE
//    ***METHOD USED: NONE
//    ***METHOD PARAMETERS: DOUBLE[]
//    ***RETURN VALUE: NONE
//    ****************************************************************************
//    ***DATE: OCTUBER 5 , 2018
//    ***************************************************************************/
//    public void setMaxMinBounds(double[] arr){this.Bounds = arr; }
//     
//    
//    /***************************************************************************
//    ***METHOD NAME: setHashTable
//    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
//    ****************************************************************************
//    ***PURPOSE OF THE METHOD: SET THE HASHTABLE THAT CONTAINS ALL POINTS
//    ***METHOD USED: NONE
//    ***METHOD PARAMETERS: POINT HASH TABLE
//    ***RETURN VALUE: NONE
//    ****************************************************************************
//    ***DATE: OCTUBER 5 , 2018
//    ***************************************************************************/
//    public void setHashTable(PointHashTable pht){this.PHT = pht;}
    
    /***************************************************************************
    ***METHOD NAME: setWidth()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE WIDTH VARIABLE BY THE WIDTH OF THE FORM
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/    
    public void setWidth(int width){this.WIDTH = width;}

    
    /***************************************************************************
    ***METHOD NAME: setHeight()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE HEIGHT VARIABLE BY THE HEIGHT OF THE FORM
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/
    public void setHeight(int height){this.HEIGHT = height; }
      
     
    /***************************************************************************
    ***METHOD NAME: setScalar()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE SCALE OF THE DRAWINGS IN A VARIABLE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/    
    public void setScalar(double scale){this.scaler = scale;}    
    
    
    
    public void setShiftXY(double shiftX, double shiftY)
    {
        this.shiftX = shiftX;
        this.shiftY = shiftY;
    }
    

    
    
}   

