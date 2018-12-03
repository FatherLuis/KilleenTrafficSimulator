package Main.Window;

import Main.Window.Simulator.TrafficPanel;
import Main.Drawable;
import Main.Init.File_IO;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/*******************************************************************************
***CLASS NAME:MAINGUI 
***CLASS AUTHOR:LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: BE THE MAIN PAGE TO RUN THE PROGRAM
********************************************************************************
***DATE: SEPTEMBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: 
*** OCT 7 ,2018: ADDED A SCROLLPANEL AND A CONTROLPANEL TO THE WINDOW
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class MainGUI 
{
    private static Drawable Painter;
    
   
    /***************************************************************************
    ***METHOD NAME: main()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RUN PROGRAM
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public MainGUI()
    {
        init();
    }
    
    /***************************************************************************
    ***METHOD NAME:init()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: PREPARES THE FORM
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/ 
    private void init() 
    {
        //LoadingFrame lf = new LoadingFrame();
               
        //CREATE THE WINDOW WITH NAME
        JFrame window = new JFrame("Traffic");
        //SET DEAULT CLOSURE OF FORM
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
 
        //GETS INFORMATION FROM XML FILE AND OTHER
        readFile();
        
        //GIVES INFORMATION TO THE PAINTERS
        Painter = new Drawable();
        
        
        //SETS THE PANEL WHERE THE MAP IS GOING TO BE DRAWN
        TrafficPanel TP = new TrafficPanel(Painter);
        
        //THIS PANEL WILL BE USED FOR THE TRAFFIC CONTROLS
        ControlPanel CP = new ControlPanel();
     
        
        
        
        
        SplitPanel SplitP = new SplitPanel(TP,CP);
       
        
        
        
        
        
        //LAYOUT FOR THE FRAME 
        window.setLayout(new BorderLayout());
        window.add(SplitP, BorderLayout.CENTER);

        window.pack();
        
        
        //while(lf.isActive()){}
        
        
        
        //MAKE WINDOW VISIBLE
        window.setVisible(true);    
    }
    
    /***************************************************************************
    ***METHOD NAME: readFile()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: READ XML FILE AND GET INFORMATION
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    private void readFile() 
    {
        
        //BEGIN READING XML FILE
        File_IO Doc = new File_IO();
        //DOES NEEDED METHODS
        Doc.MainCalculation();
    }
    
    

    
    
    
}
