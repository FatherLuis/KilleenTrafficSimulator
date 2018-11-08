package Main.Window;

import Main.Drawable;
import Main.Vehicles.Instructions.Tracker;
import Main.Vehicles.Vehicle;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
***SPECIAL NOTES: 
*** OCTOBER 7, 2018 :(LUIS) I MOVED THE MOUSE LISTENER TO SCROLLPANEL CLASS 
*** ALSO,I WILL BE GETTING RID OF VARIBALE SCALAR SOON, 
*** SINCE I HAVE NO USE FOR IT ANY MORE
*** 
*******************************************************************************/
public class TrafficPanel extends JPanel 
{    
    
    public static  int WIDTH= 1000;
    public static  int HEIGHT = 1000;
    
    private BufferedImage image;
    private Drawable Painter;  

    private int scalar = 1;
    
    private Tracker tracker;
    
    //private Thread ani;
    
    //private Thread animator;
     
    /***************************************************************************
    ***METHOD NAME: TrafficPanel()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCT0BER 5, 2018
    ***************************************************************************/ 
    public TrafficPanel(Drawable painter)
    {
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setFocusable(true);
        requestFocus();
        
        this.Painter = painter;
        Cursor hand = new Cursor(Cursor.HAND_CURSOR);
        this.setCursor(hand);
        
        //this.addMouseListener(this);
        
        this.tracker = new Tracker(this.getVehicles(),this.getBoundList(),WIDTH, HEIGHT);
       
        //this.addMouseListener(this);
        
        //this.parent = parent;
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
    ***DATE: OCT0BER 5, 2018
    ***************************************************************************/ 
    public void setPainter(Drawable p)
    {
        this.Painter = p;
    }
    
    
//        @Override
//    public void addNotify()
//    {
//        super.addNotify();
//               
//        ani = new Thread(this);
//        ani.start();
//    }
//    
//            @Override
//    public void run() 
//    {
//        long beforeTime, timeDiff, sleep;
//        
//        beforeTime = System.currentTimeMillis();
//        
//        while(true)
//        {
//            repaint();
//            
//            timeDiff = System.currentTimeMillis() - beforeTime;
//            sleep = 125 - timeDiff;
//            
//            if(sleep < 0)
//            {
//                sleep = 2;
//            }
//            
//            try{Thread.sleep(sleep);}catch(Exception ex){}
//            
//            beforeTime = System.currentTimeMillis();
//        
//        }
//    }
    
    
   
    
    public double[] getBoundList()
    {
        return this.Painter.getBounds();
    
    }
    
    public ArrayList<Vehicle> getVehicles()
    {
        return this.Painter.getVehicles();
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
    ***DATE: OCT0BER 5, 2018
    ***************************************************************************/
    @Override
    public void paintComponent(Graphics g)
    {
        Painter.setWidth(this.getWidth());
        Painter.setHeight(this.getHeight());
        Painter.setScalar(scalar);
        
        super.paintComponent(g);
        Painter.DrawRoad(g);
        Painter.DrawCar(g);
        Painter.DrawSchools(g);
        
        g.dispose();
    
    }
    
    
    public void update(int rate)
    {
        Painter.updateVehicles(rate);
    
    }
    
    public int getScalar(){return scalar;}
    public void setScalar(int s){this.scalar = s;}
    
    
    

    
    
    

}
