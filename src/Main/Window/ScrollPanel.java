package Main.Window;

import Main.Normalization;
import Main.Vehicles.Instructions.Tracker;
import Main.Vehicles.Vehicle;
import Main.Window.Control.Panels.CurrentCarPanel;
import Main.Window.TrafficPanel;
import com.sun.glass.ui.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

/*******************************************************************************
***CLASS NAME: ScrollPanel
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: CONTAINER FOR THE TRAFFIC PANEL
********************************************************************************
***DATE: OCTOBER 7, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class ScrollPanel extends JScrollPane implements MouseListener, MouseWheelListener
{
    public int WIDTH= 750;
    public int HEIGHT = 500;    
    
    private TrafficPanel TP;
    
    private int scale;
    
    private Tracker tracker;
    
    private Normalization normCalcX;
    private Normalization normCalcY;
    
    private double[] Bounds;
    
    
    private CurrentCarPanel CCP;
 
    /***************************************************************************
    ***METHOD NAME: ScrollPanel
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: TRAFFIC PANEL
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 7, 2018
    ***************************************************************************/     
    public ScrollPanel(TrafficPanel child)
    {
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        
        this.addMouseListener(this);
        this.addMouseWheelListener(this);
        
        
        
        
        TP = child;
        this.setViewportView(TP);
        
        mouseAdapter ml = new mouseAdapter();
        
        this.addMouseListener(ml);
        this.addMouseMotionListener(ml);
        
        this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);

        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
        
        this.tracker = new Tracker(TP.getVehicles(),TP.getBoundList(),WIDTH, HEIGHT);
        
        this.Bounds = TP.getBoundList();
        
    }

    
    public TrafficPanel getTP(){return TP;}
    
    
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
        return -y + TP.getHeight();
    }    
        
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) 
    {
        this.scale = TP.getScalar();
       int notches = e.getWheelRotation();

       if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) 
       {     
            if (notches < 0) 
            {
                TP.setPreferredSize(new Dimension(TP.getWidth() + 250,TP.getHeight() + 250));      
            }
           else 
           {
                TP.setPreferredSize(new Dimension(TP.getWidth() - 250,TP.getHeight() - 250));      
           }





//               message += "    Scroll type: WHEEL_UNIT_SCROLL ";
//               message += "    Scroll amount: " + e.getScrollAmount()
//                       + " unit increments per notch ";
//               message += "    Units to scroll: " + e.getUnitsToScroll()
//                       + " unit increments";
//               message += "    Vertical unit increment: "
//                   + this.getVerticalScrollBar().getUnitIncrement(1)
//                   + " pixels";
       } 
       else 
       {
//               //scroll type == MouseWheelEvent.WHEEL_BLOCK_SCROLL
//               message += "    Scroll type: WHEEL_BLOCK_SCROLL ";
//               message += "    Vertical block increment: "
//                   + this.getVerticalScrollBar().getBlockIncrement(1)
//                   + " pixels";
       }

       //System.out.println(message);
       TP.revalidate();
    }        



        
        
        
        
        
        
        
        
        
        
        
        
    
    /***************************************************************************
    ***METHOD NAME: MouseClicked
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: WHEN CLICK, ZOOM IN FEATURE OCCURS
    ***METHOD USED: REPAINT()
    ***METHOD PARAMETERS: MOUSEEVENT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 7, 2018
    ***************************************************************************/
    @Override
    public void mouseClicked(MouseEvent me) 
    { 
          //LEFT MOUSE CLICK WILL CAUSE THIS
          if(me.getButton() == MouseEvent.BUTTON1) 
          {
              tracker.setHeight(TP.getHeight());
              tracker.setWidth(TP.getWidth());
              normalizeZone(TP.getWidth(),TP.getHeight());
              
              
              
              Point p = SwingUtilities.convertPoint(this, me.getPoint(), TP);

              int carIndex = tracker.find(this.normCalcX.DeNormalize(p.x), this.normCalcY.DeNormalize(OperationY(p.y)));
              
              CCP.setCurrentIndex(carIndex);
              
              
              //System.out.println();
              
              
              
              
              
              
              
              
            //TP.setPreferredSize(new Dimension(TP.getWidth() + 1000,TP.getHeight() + 1000));
            
            //System.out.println("BUTTON 1: W:" + TP.getWidth() + "  H:" + TP.getHeight());   
          }
          //RIGHT MOUSE CLICK WLL CAUSE THIS
          if(me.getButton() == MouseEvent.BUTTON3) 
          {
            //TP.setPreferredSize(new Dimension(TP.getWidth() - 1000,TP.getHeight() - 1000));
            //System.out.println("BUTTON 2: W:" + TP.getWidth() + "  H:" + TP.getHeight());
          } 
          
          //CHECKS IF ANYTHING CHANGE ( IN THIS CASE, IT RESCALES THE TRAFFIC PANEL)
          //TP.revalidate();
    }
   
    
    /***************************************************************************
    ***METHOD NAME: mousePressed
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: NONE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 7, 2018
    ***************************************************************************/
    @Override
    public void mousePressed(MouseEvent me) {}
    
    
    /***************************************************************************
    ***METHOD NAME: mouseReleased()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: NONE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 7, 2018
    ***************************************************************************/
    @Override
    public void mouseReleased(MouseEvent me) {}
    
    
    /***************************************************************************
    ***METHOD NAME: mouseEntered
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: NONE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 7, 2018
    ***************************************************************************/
    @Override
    public void mouseEntered(MouseEvent me) {}
    
    
    /***************************************************************************
    ***METHOD NAME: MouseExited()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: NONE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 7, 2018
    ***************************************************************************/
    @Override
    public void mouseExited(MouseEvent me) {}
    
    
    private class mouseAdapter extends MouseAdapter
    {
         private Point origin;

        @Override
        public void mousePressed(MouseEvent e) 
        {
            origin = new Point(e.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) 
        {
            if (origin != null) 
            {
                JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, TP);
                if (viewPort != null) {
                    int deltaX = origin.x - e.getX();
                    int deltaY = origin.y - e.getY();

                    Rectangle view = viewPort.getViewRect();
                    view.x += deltaX*0.2;
                    view.y += deltaY*0.2;

                    TP.scrollRectToVisible(view);
                }
            }
        }       
        
        
        
        
    
    
    
    
    }
    
    
    
    
}
