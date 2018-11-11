package Main.Window;

import Main.Clock;
import Main.Database;
import Main.Window.Control.Panels.CurrentCarPanel;
import Main.Window.Control.Panels.OverviewPanel;
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
    private TrafficPanel TP;
    
    private Clock clock;
    
    
    private CurrentCarPanel CCP;
    private OverviewPanel OP;
    
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
    public SplitPanel(TrafficPanel TP, ControlPanel CP, Database database) 
    {
        super(JSplitPane.HORIZONTAL_SPLIT);
        this.setLeftComponent(TP);
        this.setRightComponent(CP);
        this.setResizeWeight(0.95);
        this.setDividerLocation(0.9);
        this.setDividerSize(0);
        
        this.CCP = new CurrentCarPanel(database.getVehicleList());
        this.OP = new OverviewPanel(database);
        
        
        TP.setCCP(this.CCP);
        TP.setOP(this.OP);
        CP.setCCP(this.CCP);
        CP.setOP(this.OP);
        
        CP.init();
        
        this.CP = CP;
        this.TP = TP;
        
        clock = new Clock();
    }
    
    @Override
    public void addNotify()
    {
        super.addNotify();
        animator = new Thread(this);
        animator.setName("ANIMATION THREAD");
        animator.start();
        
    
    }
    
    @Override
    public void run() 
    {
        long beforeTime, timeDiff, sleep;
        
        beforeTime = System.currentTimeMillis();
        
        while(true)
        {
            TP.repaint();
            
            if(CP.isOn())
            {
                CCP.update();
                TP.update(CP.getIntFastForward());

                CP.setClock(clock.tick(CP.getIntFastForward()));
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
