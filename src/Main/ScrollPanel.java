package Main;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;

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
public class ScrollPanel extends JScrollPane implements MouseListener
{
    public int WIDTH= 750;
    public int HEIGHT = 500;    
    
    private TrafficPanel TP;
 
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
        
        TP = child;
        this.setViewportView(TP);
        
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
            TP.setPreferredSize(new Dimension(TP.getWidth() + 1000,TP.getHeight() + 1000));
            
            //System.out.println("BUTTON 1: W:" + TP.getWidth() + "  H:" + TP.getHeight());   
          }
          //RIGHT MOUSE CLICK WLL CAUSE THIS
          if(me.getButton() == MouseEvent.BUTTON3) 
          {
            TP.setPreferredSize(new Dimension(TP.getWidth() - 1000,TP.getHeight() - 1000));
            //System.out.println("BUTTON 2: W:" + TP.getWidth() + "  H:" + TP.getHeight());
          } 
          
          //CHECKS IF ANYTHING CHANGE ( IN THIS CASE, IT RESCALES THE TRAFFIC PANEL)
          TP.revalidate();
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
    
}
