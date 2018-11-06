package Main.Window;

import Main.Building.School;
import Main.Drawable;
import Main.Init.File_IO;
import Main.Window.SplitPanel;
import Main.Window.ControlPanel;
import Main.Init.PointHashTable;
import Main.Init.Road;
import Main.Vehicles.Bus;
import Main.z.DELETED.Instructions;
import Main.z.DELETED.Instructions2;
import Main.Vehicles.Instructions.Instructions3;
import Main.z.DELETED.ObstacleSeer;
import Main.Vehicles.PersonalCar;
import Main.Vehicles.Vehicle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
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
    private static ArrayList<School> schoolList;
    
    private static ArrayList<Vehicle> vehicleList;
   
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
    public static void main(String[] args) throws InterruptedException
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
    private static void init() throws InterruptedException
    {
        LoadingFrame lf = new LoadingFrame();
        lf.start();
        
        
        
        
        
       
        
        //CREATE THE WINDOW WITH NAME
        JFrame window = new JFrame("Traffic");
        //SET DEAULT CLOSURE OF FORM
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
 
        //GETS INFORMATION FROM XML FILE AND OTHER
        readFile();
        

        //GIVES INFORMATION TO THE PAINTERS
        Painter = new Drawable();
        Painter.setAllRoads(RoadList);
        Painter.setMaxMinBounds(bounds);
        Painter.setHashTable(PHT);
        Painter.setSchoolList(schoolList);
        
        CreateVehicles();
        
        
        

        
        
        //THE PAINTER IS SENT TO THE MAINPANEL
        //mainPanel.setPainter(Painter);
        
        //SETS THE PANEL WHERE THE MAP IS GOING TO BE DRAWN
        TrafficPanel mainPanel = new TrafficPanel(Painter);
        
        
        
        mainPanel.setBackground(Color.BLACK);
        
        //THIS IS THE PANEL THAT WILL CONTAIN THE TRAFFIC PANEL
        ScrollPanel SP = new ScrollPanel(mainPanel);    
        
        
        
        //THIS PANEL WILL BE USED FOR THE TRAFFIC CONTROLS
        ControlPanel CP = new ControlPanel();
     
        SplitPanel SplitP = new SplitPanel(SP,CP);
       
        //LAYOUT FOR THE FRAME 
        window.setLayout(new BorderLayout());
        window.add(SplitP, BorderLayout.CENTER);

        window.pack();
        
        
        while(lf.isActive()){}
        
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
    private static void readFile() throws InterruptedException
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
        
        schoolList = Doc.getSchoolList();
    
    
    }
    
    
    private static void CreateVehicles()
    {          
        //System.out.println("///////////////////////////////////////////// \n\n");
        
        Instructions3 ins ;
        Vehicle vehicle;
        
        vehicleList = new ArrayList();
        
        Random rand = new Random();
        
        int num = rand.nextInt(100);
        
        for(int i=0; i < 2500; i++)
        {
            ins = new Instructions3(RoadList, PHT);
            
            if(num > 20)
            {
                vehicle = new PersonalCar(ins);
            }
            else
            {
                vehicle = new Bus(ins);
            }
            
            
            vehicleList.add(vehicle);
            
            num = rand.nextInt(100);
        
        
        }
        
        
        
        Painter.setVehicleList(vehicleList);
    
    
    
    }
    
    
    
}
