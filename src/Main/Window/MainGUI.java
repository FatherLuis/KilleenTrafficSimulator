package Main.Window;

import Main.Drawable;
import Main.Init.File_IO;
import Main.Window.SplitPanel;
import Main.Window.ControlPanel;
import Main.Init.PointHashTable;
import Main.Init.Road;
import Main.Vehicles.Vehicle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private static ArrayList<Road> RoadList;
    private static double[] bounds;
    private static PointHashTable PHT;
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
    public static void main(String[] args)
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
    private static void init()
    {
        //CREATE THE WINDOW WITH NAME
        JFrame window = new JFrame("Traffic");
        //SET DEAULT CLOSURE OF FORM
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //GETS INFORMATION FROM XML FILE AND OTHER
        readFile();
        
        //SETS THE PANEL WHERE THE MAP IS GOING TO BE DRAWN
        TrafficPanel mainPanel = new TrafficPanel();
        
        //GIVES INFORMATION TO THE PAINTERS
        Painter = new Drawable(mainPanel);
        Painter.setAllRoads(RoadList);
        Painter.setMaxMinBounds(bounds);
        Painter.setHashTable(PHT);
        
        CreateVehicles();
        

        
        
        //THE PAINTER IS SENT TO THE MAINPANEL
        mainPanel.setPainter(Painter);
        
        //THIS IS THE PANEL THAT WILL CONTAIN THE TRAFFIC PANEL
        ScrollPanel SP = new ScrollPanel(mainPanel);        
        
        //THIS PANEL WILL BE USED FOR THE TRAFFIC CONTROLS
        ControlPanel CP = new ControlPanel();
     
        SplitPanel SplitP = new SplitPanel(SP,CP);
       
        //LAYOUT FOR THE FRAME 
        window.setLayout(new BorderLayout());
        window.add(SplitP, BorderLayout.CENTER);

        window.pack();
        
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
    private static void readFile()
    {
        
        //BEGIN READING XML FILE
        File_IO Doc = new File_IO();
        //DOES NEEDED METHODS
        Doc.MainCalculation();
        //GET ROADLIST ARRAY
        RoadList = Doc.getRoads(); 
        //GET BOUNDARY ARRAY
        bounds = Doc.getBounds();
        //GET HASHTABLE
        PHT = Doc.gethashTable();
    
    
    }
    
    
    private static void CreateVehicles()
    {          
        Vehicle vehicle = new Vehicle(RoadList, PHT);
        ArrayList<Vehicle> vehicleList = new ArrayList();
        
        for(int i=0; i < 1000; i++)
        {
            vehicle = new Vehicle(RoadList, PHT);
            
            vehicleList.add(vehicle);
        
        
        }
        
        Painter.setVehicleList(vehicleList);
    
    
    
    }
    
    
    
}
