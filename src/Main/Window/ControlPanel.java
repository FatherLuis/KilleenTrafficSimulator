package Main.Window;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/*******************************************************************************
***CLASS NAME: ControlPanel()
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: PANEL WILL CONTAIN CONTROLS THAT WILL AFFECT TRAFFIC PANEL
********************************************************************************
***DATE: OCTOBER 7, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class ControlPanel extends JPanel
{
    public int WIDTH= 400;
    public int HEIGHT = 500; 
    
    /***************************************************************************
    ***METHOD NAME: ControlPanel()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 7, 2018
    ***************************************************************************/     
    public ControlPanel()
    {
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.GRAY);  
    }    
    
    
    
}
