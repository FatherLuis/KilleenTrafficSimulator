package Main.Window;

import Main.Drawable;
import Main.Normalization;
import Main.Vehicles.Instructions.Tracker;
import Main.Vehicles.Vehicle;
import Main.Window.Control.Panels.CurrentCarPanel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*******************************************************************************
***CLASS NAME: TrafficPanel
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: PANEL SIMULATE TRAFFIC
********************************************************************************
***DATE: OCTOBER 5, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: 
*** OCTOBER 7, 2018 :(LUIS) I MOVED THE MOUSE LISTENER TO SCROLLPANEL CLASS 
*** ALSO,I WILL BE GETTING RID OF VARIBALE SCALAR SOON, 
*** SINCE I HAVE NO USE FOR IT ANY MORE
*** 
*******************************************************************************/
public class TrafficPanel extends JPanel 
{    
    
    public static  int WIDTH= 1000;
    public static  int HEIGHT = 1000;
    
    private CurrentCarPanel CCP;
    private Drawable Painter;  

    private double scalar = 1;
    
    private double[] Bounds;
    private Tracker tracker;
    
    private Normalization normCalcX;
    private Normalization normCalcY;
     
    /***************************************************************************
    ***METHOD NAME: TrafficPanel()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCT0BER 5, 2018
    ***************************************************************************/ 
    public TrafficPanel(Drawable painter)
    {
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setFocusable(true);
        requestFocus();
        
        this.Painter = painter;
        Cursor hand = new Cursor(Cursor.HAND_CURSOR);
        this.setCursor(hand);

        this.tracker = new Tracker(getVehicles(),getBoundList(),WIDTH, HEIGHT);
       
        this.Bounds = getBoundList();
        
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.addMouseWheelListener(mouseHandler);
        
        
        
    }
    
    /***************************************************************************
    ***METHOD NAME: setPainter()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE PAINTER
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: DRAWABLE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCT0BER 5, 2018
    ***************************************************************************/ 
    public void setPainter(Drawable p)
    {
        this.Painter = p;
    }
    
    public double[] getBoundList()
    {
        return this.Painter.getBounds();
    
    }
    
    public ArrayList<Vehicle> getVehicles()
    {
        return this.Painter.getVehicles();
    }

    
    
    public void setCCP(CurrentCarPanel CCP){this.CCP = CCP;}

 
    private void normalizeZone(double width, double height)
    {
        //FIRST PARAMATER IS THE MAX LONGITUDE
        //SECOND PARAMETER IS THE MIN LONGITUDE
        //THIRD PARAMETER IS THE MAX X COORDINATE
        //FOURTH PARAMETER IS THE MIN X COORDINATE
        normCalcX = new Normalization(this.Bounds[3],this.Bounds[1], width, 0 );
                
        //FIRST PARAMATER IS THE MAX LATITUDE
        //SECOND PARAMETER IS THE MIN LATITUDE
        //THIRD PARAMETER IS THE MAX X LATITUDE
        //FOURTH PARAMETER IS THE MIN X LATITUDE
        normCalcY = new Normalization(this.Bounds[2],this.Bounds[0],height, 0 );
    }   
    
    
    private double OperationY(double y)
    {
        //NEGATIVE VALUE
        //double newY = -y;
        //ADD THE HEIGHT OF WINDOW
        return -y + this.getHeight();
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /***************************************************************************
    ***METHOD NAME: paintComponent()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: DRAW LINES AND CARS
    ***METHOD USED: setWidth(), setHeight(), setScalar()
    ***METHOD PARAMETERS: GRAPHICS
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCT0BER 5, 2018
    ***************************************************************************/
    @Override
    public void paintComponent(Graphics g)
    {
        Painter.setWidth(this.getWidth());
        Painter.setHeight(this.getHeight());
        Painter.setScalar(scalar);
        Painter.setShiftXY(shiftX, shiftY);
        Painter.setDeltaXY(dx, dy);
        
        super.paintComponent(g);
        Painter.DrawRoad(g);
        Painter.DrawCar(g);
        Painter.DrawSchools(g);
        
        g.dispose();
    
    }
    
    
    public void update(int rate)
    {
        Painter.updateVehicles(rate);
    
    }
    
    public double getScalar(){return scalar;}
    public void setScalar(int s){this.scalar = s;}
    
    
  
    
    
    
    
    double shiftX;
    double shiftY;

    double dx;
    double dy;
    
    
    private class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener
    {
        
        int dummyX = 0;
        int dummyY =0;
        
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            if(e.getButton() == MouseEvent.BUTTON1) 
            {
                tracker.setHeight(getHeight());
                tracker.setWidth(getWidth());
                normalizeZone(getWidth(),getHeight());



                Point p = e.getPoint();

                int carIndex = tracker.find(normCalcX.DeNormalize((p.x/scalar) - shiftX), normCalcY.DeNormalize(OperationY((p.y/scalar) - shiftY)));

                //System.out.println(carIndex);
                
                CCP.setCurrentIndex(carIndex);

            }
        }

        @Override
        public void mousePressed(MouseEvent e) 
        {
            
            //System.out.println("\n\n");
            dummyX = e.getX();
            dummyY = e.getY();
            
            //System.out.println("dummyX " + dummyX + "    dummyY " + dummyY);

        }


        @Override
        public void mouseReleased(MouseEvent e) 
        {                 
        }


        public void mouseEntered(MouseEvent e) 
        {
        }


        public void mouseExited(MouseEvent e) 
        {
        }


        @Override
        public void mouseDragged(MouseEvent e) 
        {
            
            dx = (e.getX() - dummyX)*0.5;
            dy = (e.getY() - dummyY)*0.5;
            
            shiftX += dx*0.15;
            shiftY += dy*0.15;
            repaint();
                 
        }

        public void mouseMoved(MouseEvent e) 
        {   
        }


        @Override
        public void mouseWheelMoved(MouseWheelEvent e) 
        {
            int wheelRot=e.getWheelRotation();
            
            //System.out.println("WHEEL: " + wheelRot);

            if(wheelRot < 0)
            {
                scalar += 0.5;
                //System.out.println("scalar" + scalar);
            }
            else if(wheelRot > 0)
            {
                scalar -= 0.5;
                
                if(scalar <= 0)
                {
                    scalar = 0.5;
                    
                }
            }
                            
            repaint();           
        }
    }
        
    
     

}
