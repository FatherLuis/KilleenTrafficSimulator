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
***CLASS NAME: TrafficPanel
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: PANEL SIMULATE TRAFFIC
********************************************************************************
***DATE: OCTOBER 5, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class TrafficPanel extends JPanel implements  MouseListener
{    
    
    public static  int WIDTH=500;
    public static  int HEIGHT = 500;
    
    private BufferedImage image;
    private Drawable Painter;  
    private int scalar = 1;
    
    /***************************************************************************
    ***METHOD NAME: TrafficPanel()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5, 2018
    ***************************************************************************/ 
    public TrafficPanel()
    {
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setFocusable(true);
        requestFocus();
        this.addMouseListener(this);
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
    ***DATE: OCTUBER 5, 2018
    ***************************************************************************/ 
    public void setPainter(Drawable p)
    {
        this.Painter = p;
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
    ***DATE: OCTUBER 5, 2018
    ***************************************************************************/
    public void paintComponent(Graphics g)
    {
        Painter.setWidth(this.getWidth());
        Painter.setHeight(this.getHeight());
        Painter.setScalar(scalar);
        
        super.paintComponent(g);
        Painter.draw(g);
    
    }
 
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    

    
    /***************************************************************************
    ***METHOD NAME: MouseClicked
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: WHEN CLICK, ZOOM IN FEATURE OCCURS
    ***METHOD USED: REPAINT()
    ***METHOD PARAMETERS: MOUSEEVENT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5, 2018
    ***************************************************************************/
    @Override
    public void mouseClicked(MouseEvent me) { 
    
          if(me.getButton() == MouseEvent.BUTTON1) 
          {
            this.scalar+= 1;
          }
          if(me.getButton() == MouseEvent.BUTTON3 && this.scalar > 1) 
          {
            this.scalar -= 1;
          } 
          
          repaint();
    }
   
    
    /***************************************************************************
    ***METHOD NAME: mousePressed
    ***METHOD AUTHOR:
    ****************************************************************************
    ***PURPOSE OF THE METHOD:
    ***METHOD USED:
    ***METHOD PARAMETERS:
    ***RETURN VALUE:
    ****************************************************************************
    ***DATE:
    ***************************************************************************/
    @Override
    public void mousePressed(MouseEvent me) {}
    /***************************************************************************
    ***METHOD NAME: 
    ***METHOD AUTHOR:
    ****************************************************************************
    ***PURPOSE OF THE METHOD:
    ***METHOD USED:
    ***METHOD PARAMETERS:
    ***RETURN VALUE:
    ****************************************************************************
    ***DATE:
    ***************************************************************************/
    @Override
    public void mouseReleased(MouseEvent me) {}
    /***************************************************************************
    ***METHOD NAME: 
    ***METHOD AUTHOR:
    ****************************************************************************
    ***PURPOSE OF THE METHOD:
    ***METHOD USED:
    ***METHOD PARAMETERS:
    ***RETURN VALUE:
    ****************************************************************************
    ***DATE:
    ***************************************************************************/
    @Override
    public void mouseEntered(MouseEvent me) {}
    /***************************************************************************
    ***METHOD NAME: 
    ***METHOD AUTHOR:
    ****************************************************************************
    ***PURPOSE OF THE METHOD:
    ***METHOD USED:
    ***METHOD PARAMETERS:
    ***RETURN VALUE:
    ****************************************************************************
    ***DATE:
    ***************************************************************************/
    @Override
    public void mouseExited(MouseEvent me) {}


    
    
}
