/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *
 * @author fathe
 */
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
    
    private void normalizeZone()
    {
        System.out.println(this.Bounds[0]);
        System.out.println(this.Bounds[1]);
        System.out.println(this.Bounds[2]);
        System.out.println(this.Bounds[3]);
        
        
        normCalcX = new Normalization(this.Bounds[3],this.Bounds[1], this.WIDTH, 0 );
        normCalcY = new Normalization(this.Bounds[2],this.Bounds[0], this.HEIGHT, 0 );
    }
    
    private double OperationY(double y)
    {
        double newY = -y;
        return newY + this.HEIGHT;
    }    
    
    
    public void setAllRoads(ArrayList roads){ this.RoadList = roads;}
    public void setMaxMinBounds(double[] arr){this.Bounds = arr; }
    public void setHashTable(PointHashTable pht){this.PHT = pht;}
    
    public void setWidth(int width){this.WIDTH = width;}
    public void setHeight(int height){this.HEIGHT = height; }
    public void setScalar(int scale){this.scaler = scale;}
    
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
    public void draw(Graphics g)
    {
        normalizeZone();
        Graphics2D g2 = (Graphics2D) g;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //g2.drawRect(20, 20, 100, 50);
       
        
        //System.out.println(this.RoadList.size());
        for(int i = 0; i < this.RoadList.size() ; i++)
        {
            ArrayList<String> curRoadPoints = this.RoadList.get(i).getRef();
            
            //System.out.println(curRoadPoints.size());
            
            for(int j = 0 ; j < curRoadPoints.size() - 1 ; j++)
            {
                    //System.out.println(curRoadPoints.get(j));
                    Point p =this.PHT.getPoint(curRoadPoints.get(j));
                    double x1 = normCalcX.Normalize(p.getLongitude()) * this.scaler;
                    double y1 = OperationY(normCalcY.Normalize(p.getLatitude())) *this.scaler;

                    //System.out.println(curRoadPoints.get(j+1));
                    Point p2 =this.PHT.getPoint(curRoadPoints.get(j+1));
                    
                    double x2 = normCalcX.Normalize(p2.getLongitude())*this.scaler;
                    double y2 = OperationY(normCalcY.Normalize(p2.getLatitude()))*this.scaler;

                    //System.out.println("(x1,y1)  " + x1 + ", " + y1);
                    //System.out.println("(x2,y2)  " + x2 + ", " + y2 + "\n");
                    g2.draw(new Line2D.Double(x1,y1,x2,y2)); 

            }
        }    
    
    }


    /***************************************************************************
    ***METHOD NAME: DrawCar()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: Draws Roads
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/    
}
