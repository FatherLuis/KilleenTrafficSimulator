/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
    
    private double[] Bounds;
    private Normalization Norm;
    private ArrayList<Road> RoadList;
    
    private ArrayList<Vehicle> vehicleList;
    
    private Normalization normCalcX;
    private Normalization normCalcY;
    
    private int WIDTH = 500;
    private int HEIGHT = 500;
    
    private PointHashTable PHT;
    private int scaler = 1;
    
    TrafficPanel TP;
    private Graphics g;
    
    
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
    public Drawable(TrafficPanel TP)
    {
        g = TP.getGraphics();
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
        normCalcX = new Normalization(this.Bounds[3],this.Bounds[1], this.WIDTH, 0 );
                
        //FIRST PARAMATER IS THE MAX LATITUDE
        //SECOND PARAMETER IS THE MIN LATITUDE
        //THIRD PARAMETER IS THE MAX X LATITUDE
        //FOURTH PARAMETER IS THE MIN X LATITUDE
        normCalcY = new Normalization(this.Bounds[2],this.Bounds[0], this.HEIGHT, 0 );
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
        double newY = -y;
        //ADD THE HEIGHT OF WINDOW
        return newY + this.HEIGHT;
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
        //NORMALIZE THE BOUNDARIES SO I CAN CONVERT FROM (LON,LAT) TO (X,Y)
        normalizeZone();
        //DRAWING IN A 2D FIELD
        
        //Graphics2D g3 = (Graphics2D) g.create();
        //Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, 0);
        //g3.setStroke(dashed); 
        //g3.setColor(Color.yellow);
        
        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setStroke(new BasicStroke(1));
        //MAKE THE LINES NICER (?)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        //g2.setColor(Color.WHITE);

        //ITERATE BY THE NUMBER OF ROADS ON THE ARRAYLIST
        for(int i = 0; i < this.RoadList.size() ; i++)
        {
            //USE AS A REFERNCE TO THE CURRENT ROAD REF ARRAYLIST
            ArrayList<String> curRoadPoints = this.RoadList.get(i).getRef();
            
            //ITERATES BY THE SIZE OF THE CURRENT ROAD REF ARRAYLIST
            for(int j = 0 ; j < curRoadPoints.size() - 1 ; j++)
            {
                    //GETS THE OBJECT POINT FROM THE HASHTABLE
                    Point p =this.PHT.getPoint(curRoadPoints.get(j));
                    //CONVERT THE POINT'S LONGITUDE TO X COORDINATE
                    double x1 = normCalcX.Normalize(p.getLongitude());
                    //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
                    double y1 = OperationY(normCalcY.Normalize(p.getLatitude()));

                    //GETS THE OBJECT POINT FROM THE HASHTABLE
                    Point p2 =this.PHT.getPoint(curRoadPoints.get(j+1));
                    //CONVERT THE POINT'S LONGITUDE TO X COORDINATE
                    double x2 = normCalcX.Normalize(p2.getLongitude());
                    //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
                    double y2 = OperationY(normCalcY.Normalize(p2.getLatitude()));

                    
                    ////////////////////////////////////////////////
                    
                    //ANGELICA, THIS IS THE METHOD YOU'LL BE WORKING ON
                    // ABOVE ARE THE POINTS THAT ARE GETTING READY FOR YOU
                    //WHAT YOU NEED TO FIGURE OUT IS......
                    //HOW TO DRAW A ROAD. 
                    ////////////////////////////////////////////////
                    
                    
                    //DRAW A LINE FROM P1 TO P2
                    g2.draw(new Line2D.Double(x1,y1,x2,y2)); 
                    //g3.draw(new Line2D.Double(x1,y1,x2,y2));
                    
                               
                    //Ellipse2D.Double shape = new Ellipse2D.Double((int)x1-5,(int)y1-5,10,10);

                    //g3.setColor(this.vehicleList.get(i).getColor());
                    //g2.draw(shape);
                    
                    //shape = new Ellipse2D.Double((int)x2-5,(int)y2-5,10,10);

                    //g3.setColor(this.vehicleList.get(i).getColor());
                    //g2.draw(shape);                    
                    
                                              
            }
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

        normalizeZone();
        Graphics2D g3 = (Graphics2D) g.create();
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g3.setColor(Color.BLUE);

        for(int i = 0; i < this.vehicleList.size(); i++)
        {
            double x1 = normCalcX.Normalize(this.vehicleList.get(i).getPoint().getLongitude());
            //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
            double y1 = OperationY(normCalcY.Normalize(this.vehicleList.get(i).getPoint().getLatitude()));


            //subtract the x and y by the radius
            //since there is a scalar, we'll gonna be to figure out something
            
            int d = 6 * (this.scaler)/3;
            int r = d/2;
            
            
            Ellipse2D.Double shape = new Ellipse2D.Double(x1-r,y1-r,d,d);

            //g3.setColor(this.vehicleList.get(i).getColor());
            g3.draw(shape);
        }
        
    }
    
    
    public void updateVehicles()
    {
        for(int i = 0; i < this.vehicleList.size(); i++)
        {
            this.vehicleList.get(i).move();
        }
    }
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////    
    
      public void setVehicleList(ArrayList v){this.vehicleList = v;}
    
    
    
    
     /***************************************************************************
    ***METHOD NAME: setAllRoads()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: STORE ARRAY OF TYPE ROADS
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: ARRAYLIST
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/   
    public void setAllRoads(ArrayList roads){ this.RoadList = roads;}
    
    
    /***************************************************************************
    ***METHOD NAME: setMaxMinBounds() 
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE BOUNDARY INFORMATION IN VARIABLE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: DOUBLE[]
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/
    public void setMaxMinBounds(double[] arr){this.Bounds = arr; }
     
    
    /***************************************************************************
    ***METHOD NAME: setHashTable
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE HASHTABLE THAT CONTAINS ALL POINTS
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: POINT HASH TABLE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/
    public void setHashTable(PointHashTable pht){this.PHT = pht;}
    
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
    public void setScalar(int scale){this.scaler = scale;}    
    
    
}   

