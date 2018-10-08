package Main.Window;

import Main.Window.ControlPanel;
import javax.swing.JSplitPane;

/*******************************************************************************
***CLASS NAME: SplitPanel
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: SEPERATE TWO PANELS 
********************************************************************************
***DATE: OCTOBER 7, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES:  NONE
*** 
*******************************************************************************/
public class SplitPanel extends JSplitPane 
{
    /***************************************************************************
    ***METHOD NAME:  SplitPanel()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: SCROLLPANEL, CONTROLPANEL
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 7, 2018
    ***************************************************************************/     
    public SplitPanel(ScrollPanel SP, ControlPanel CP)
    {
        super(JSplitPane.HORIZONTAL_SPLIT);
        this.setLeftComponent(SP);
        this.setRightComponent(CP);
        this.setResizeWeight(1.0);
        this.setDividerLocation(0.9);
        
  
    }
    
    
    
}
