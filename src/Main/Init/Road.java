package Main.Init;

import java.util.ArrayList;

/*******************************************************************************
***CLASS NAME: Road
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
***CO-AUTHORS: NONE
********************************************************************************
***PURPOSE OF CLASS: GIVE EACH ROAD AN IDENTITY SO VEHICLES CAN MOVE AROUND
********************************************************************************
***DATE: SEPTEMBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class Road 
{
    private String roadID;
    private String name;
    private ArrayList ref;
    
    private ArrayList detailedRef;
    
    private int lane;
    private boolean oneway;
    private int speed;
    private String type;
    
    /***************************************************************************
    ***METHOD NAME: Road()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD:CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS:
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public Road()
    {
        //HOLDS COLLECT OF POINT ID
        this.ref = new ArrayList();
        
        //THESE WILL BE OUR DEFAULTS FOR THE MOMENT
        this.speed = 30;
        this.lane = 2;
        this.oneway = false;
    }
   
  
    /***************************************************************************
    ***METHOD NAME: setName()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE NAME OF THE ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public void setName(String name){this.name = name;}
  
    
    /***************************************************************************
    ***METHOD NAME: getName()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE NAME OF ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: STRING
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/ 
    public String getName(){return this.name;}
  
    
    /***************************************************************************
    ***METHOD NAME: setRef()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE REFLIST OF THE ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: ARRAYLIST (LONG)
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/    
    public void setRef(ArrayList ref){this.ref = ref;}
   
    
    /***************************************************************************
    ***METHOD NAME: getRef()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE ARRAYLIST
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: ARRAYLIST
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/ 
    public ArrayList getRef(){return this.ref;}
  

    public void setDetailedRef(ArrayList ref){this.detailedRef = ref;}

    public ArrayList getDetailedRef(){return this.detailedRef;}


    
    /***************************************************************************
    ***METHOD NAME: setID()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE ID OF THE ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING (LONG)
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public void setID(String ID){this.roadID = ID;}
    
    
   
    
    /***************************************************************************
    ***METHOD NAME: getID()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN ROAD ID
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: STRING
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/  
    public String getID(){return this.roadID;}
  
    
    /***************************************************************************
    ***METHOD NAME: setSpeed()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE SPEED OF THE ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/   
    public void setSpeed(int speed){this.speed = speed;}
   
    
    /***************************************************************************
    ***METHOD NAME: getSpeed()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE SPEED OF THE ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: INT
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/  
    public int getSpeed(){return this.speed;}
 
    
    /***************************************************************************
    ***METHOD NAME: setType()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE TYPE OF ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/      
    public void setType(String type){this.type = type;}
 
    
    /***************************************************************************
    ***METHOD NAME: getType()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE TYPE OF ROAD 
    ***METHOD USED: NONE
    ***METHOD PARAMETERS:NONE
    ***RETURN VALUE: STRING
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/   
    public String getType(){return this.type;}
 
    
    /***************************************************************************
    ***METHOD NAME: setLane()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SET THE NUMBER OF LANES ON THE ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: INT
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/    
    public void setLane(int lane){this.lane = lane;}
 
    
    /***************************************************************************
    ***METHOD NAME: getLane()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE NUMBER OF LANES OF THE ROAD
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: INT
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public int getLane(){return this.lane;}
  
    
    /***************************************************************************
    ***METHOD NAME: setOneway
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: STATE WHEITHER THIS ROAD IS A ONEWAY OR NOT
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: BOOLEAN
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/      
    public void setOneway(Boolean oneway){this.oneway = oneway;}

    
    /***************************************************************************
    ***METHOD NAME: isOneWay()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN BOOLEAN STATING IS ROAD IS ONEWAY OR NOT
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: BOOLEAN
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/ 
    public boolean isOneWay(){return this.oneway;}
    
    
}
