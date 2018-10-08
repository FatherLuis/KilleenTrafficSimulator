/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Init.Road;
import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Window.TrafficPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
        Graphics2D g2 = (Graphics2D) g;
        //MAKE THE LINES NICER (?)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

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
                    double x1 = normCalcX.Normalize(p.getLongitude()) * this.scaler;
                    //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
                    double y1 = OperationY(normCalcY.Normalize(p.getLatitude())) *this.scaler;

                    //GETS THE OBJECT POINT FROM THE HASHTABLE
                    Point p2 =this.PHT.getPoint(curRoadPoints.get(j+1));
                    //CONVERT THE POINT'S LONGITUDE TO X COORDINATE
                    double x2 = normCalcX.Normalize(p2.getLongitude())*this.scaler;
                    //CONVERT THE POINT'S LATITUDE TO Y COORDINATE
                    double y2 = OperationY(normCalcY.Normalize(p2.getLatitude()))*this.scaler;

                    
                    ////////////////////////////////////////////////
                    
                    //ANGELICA, THIS IS THE METHOD YOU'LL BE WORKING ON
                    // ABOVE ARE THE POINTS THAT ARE GETTING READY FOR YOU
                    //WHAT YOU NEED TO FIGURE OUT IS......
                    //HOW TO DRAW A ROAD. 
                    ////////////////////////////////////////////////
                    
                    
                    //DRAW A LINE FROM P1 TO P2
                    g2.draw(new Line2D.Double(x1,y1,x2,y2)); 
                                              
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
        // I DONT KNOW HOW YOU'LL BE STORING YOUR COLLECTION OF VEHICLES EMILY,
        //BUT IF YOU NEED AN EXAMPLE, LOOK AT THE DRAW ROAD METHOD ABOVE.
        
        //CODE GOES HERE
        //DONT FORGET TO PLACE METHOD IN PAINTCOMPONENT ON TRAFFIC PANEL
    }
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////    
    
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

