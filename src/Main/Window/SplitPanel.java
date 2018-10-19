package Main.Window;

import Main.Clock;
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
public class SplitPanel extends JSplitPane implements Runnable 
{
    
    
    private Thread animator;
    
    private ControlPanel CP;
    
    private Clock clock;
    
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
        
        this.CP = CP;
        clock = new Clock();
    }
    
            @Override
    public void addNotify()
    {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
        
    
    }
    
            @Override
    public void run() 
    {
        long beforeTime, timeDiff, sleep;
        
        beforeTime = System.currentTimeMillis();
        
        while(true)
        {
            if(CP.isOn())
            {
                repaint();
            
                CP.setClock(clock.tick());
            }
            
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 125 - timeDiff;
            
            if(sleep < 0)
            {
                sleep = 2;
            }
            
            try{Thread.sleep(sleep);}catch(Exception ex){}
            
            beforeTime = System.currentTimeMillis();
        
        }
    }
    
    
    
}
