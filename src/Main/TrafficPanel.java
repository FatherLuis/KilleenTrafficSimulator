package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

/*******************************************************************************
***CLASS NAME:
***CLASS AUTHOR:
********************************************************************************
***PURPOSE OF CLASS:
********************************************************************************
***DATE:
********************************************************************************
***LIST OF CHANGES WITH DATES:
********************************************************************************
***SPECIAL NOTES: 
*** 
***
*******************************************************************************/
public class TrafficPanel extends JPanel implements Runnable, MouseListener
{    
    private ArrayList<Road> AllRoads;
    private double[] MaxMinBounds;
    
    public static  int WIDTH = 1000;
    public static  int HEIGHT = 1000;
    
    private Thread thread;
    private boolean running;
    
    private BufferedImage image;
    private Graphics2D g;
    
    private int FPS = 30;
    private int targetTime = 1000 / FPS;
    
    private Normalization normCalcX;
    private Normalization normCalcY;
    
    private PointHashTable PHT;
    
    
    private int scaler = 1;
    
    
    public TrafficPanel()
    {
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setFocusable(true);
        requestFocus();
    }
    
    public void setAllRoads(ArrayList roads){ this.AllRoads = roads;}
    public void setMaxMinBounds(double[] arr){this.MaxMinBounds = arr; }
    public void setHashTable(PointHashTable pht){this.PHT = pht;}
    
    public void addNotify()
    {
        super.addNotify();
        if(thread == null)
        {
            thread = new Thread(this);
            thread.start();
        }
        
        this.addMouseListener(this);

        
    }
    
    public void run()
    {
        init();
        
        long startTime;
        long urdTime;
        long waitTime;
        
        
        while(running)
        {
            this.HEIGHT = this.getHeight();
            this.WIDTH = this.getWidth();
            
            startTime = System.nanoTime();
            //update();
            render();
            draw();
            urdTime = (System.nanoTime() - startTime)/ 1000000;
            waitTime = targetTime - urdTime;
            
            try{Thread.sleep(500);}catch(Exception ex){}
            
            
                    
        }
        
    }
    
    private void init()
    {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
    
    }

    
    
    
    
    
    
    
    
    
    
   ////////////////////////////////////////////////////
    
    private void normalizeZone()
    {
        normCalcX = new Normalization(this.MaxMinBounds[3],this.MaxMinBounds[1], this.WIDTH, 0 );
        normCalcY = new Normalization(this.MaxMinBounds[2],this.MaxMinBounds[0], this.HEIGHT, 0 );
    }
    
    private double OperationY(double y)
    {
        double newY = -y;
        return newY + this.HEIGHT;
    }
    
    public void drawLines(Graphics g)
    {
        
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
               
        
        for(int i = 0; i < this.AllRoads.size() ; i++)
        {
            
            
            ArrayList<String> curRoadPoints = this.AllRoads.get(i).getRef();
            
            //System.out.println(curRoadPoints.size());
            
            for(int j = 0 ; j < curRoadPoints.size() - 1 ; j++)
            {
                    //System.out.println(curRoadPoints.get(j));
                    Point p =this.PHT.getPoint(curRoadPoints.get(j));
                    double x1 = normCalcX.Normalize(p.getLongitude()) *this.scaler;
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
    
    public void paint(Graphics g)
    {
        normalizeZone();
        super.paint(g);
        drawLines(g);   
    }
    
    
    
    private void update()
    {
    }
    
    private void render()
    {
        repaint();
    }
    
    private void draw()
    {
        paint(g);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) { 
    
          if(me.getButton() == MouseEvent.BUTTON1) 
          {
            this.scaler+= 1;
          }
          if(me.getButton() == MouseEvent.BUTTON3 && this.scaler > 1) 
          {
            this.scaler -= 1;
          } 
          
          System.out.println(this.scaler);
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}


    
    
}
