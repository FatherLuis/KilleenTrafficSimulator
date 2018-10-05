package Main;

import java.util.ArrayList;
import javax.swing.JFrame;
/*******************************************************************************
***CLASS NAME:MAINGUI 
***CLASS AUTHOR:LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: BE THE MAIN PAGE TO RUN THE PROGRAM
********************************************************************************
***DATE: SEPTEMBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
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
        
        mainPanel.setPainter(Painter);
        
        //LAYOUT AT THE MOMENT; PACK THINGS IN THE WINDOW
        window.setContentPane(mainPanel);
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
    
    
    
}
