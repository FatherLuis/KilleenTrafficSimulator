//package Main;
/*******************************************************************************
***CLASS NAME: Clock
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: CREATE A CLOCK
********************************************************************************
***DATE: 18 OCTOBER, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: (10/18,2018) AT THE MOMENT, IT ONLY WORKS WITH MILITARY TIME
*** 
*******************************************************************************/
public class Clock 
{
    private int day;
    private int seconds;
    private int minutes;
    private int hours;
    
    
    
    
    /***************************************************************************
    ***METHOD NAME: Clock()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 18 OCTOBER, 2018
    ***************************************************************************/    
    public Clock()
    {
        day = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
    }
    
    /***************************************************************************
    ***METHOD NAME: tick()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: ADDS A SECOND TO THE TIME
    ***METHOD USED: changeMinute(), getDate()
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: RETURN DAY AND TIME
    ****************************************************************************
    ***DATE: 18 OCTOBER, 2018
    ***************************************************************************/      
    public String tick()
    {
        this.seconds++;
        
        if(this.seconds >= 60)
        {
            changeMinutes();
        }
        
        return this.getDate();  
    }
    
    /***************************************************************************
    ***METHOD NAME: changeMinutes()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHANGE SECONDS TO MINUTES
    ***METHOD USED: changeHours()
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 18 OCTOBER, 2018
    ***************************************************************************/      
    private void changeMinutes()
    {  
        this.minutes ++;
        this.seconds -= 60;
        
        if(this.minutes >= 60)
        {
            changeHours();
        }
        
    }
   
    /***************************************************************************
    ***METHOD NAME: changeHours()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHANGE MINUTES TO HOURS
    ***METHOD USED: changeDay()
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 18 OCTOBER, 2018
    ***************************************************************************/  
    private void changeHours()
    {
        this.hours++;
        this.minutes -= 60;
        
        if(this.hours >= 24)
        {
            changeDay();
        }
    }
       
    /***************************************************************************
    ***METHOD NAME: changeDay()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHANGE HOURS TO DAYS
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 18 OCTOBER, 2018
    ***************************************************************************/  
    private void changeDay()
    {
        this.day ++;
        this.hours-= 24;
        
        if(this.day >= 6)
        {
            this.day =0 ;
        }
    }
      
    /***************************************************************************
    ***METHOD NAME: getDay()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: GET THE DAY OF THE WEEK
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 18 OCTOBER, 2018
    ***************************************************************************/  
    private String getDay()
    {
        String day = "";
    
        switch(this.day)
        {
            case(0):
                day = "Monday";
                break;
            case(1):
                day = "Tuesday";
                break;        
            case(2):
                day = "Wednesday";
                break;            
            case(3):
                day = "Thursday";
                break;
            case(4):
                day = "Friday";
                break;
            case(5):
                day = "Saturday";
                break;        
            case(6):
                day = "Sunday";
                break;         
        }
        return day;
    
    }
       
    /***************************************************************************
    ***METHOD NAME: getDate()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: GET THE STRING REPRESENTATION OF DAY AND TIME
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 18 OCTOBER, 2018
    ***************************************************************************/  
    private String getDate()
    {
        return " " + getDay() + 
                ": " + String.format( " %02d ",this.hours) + 
                ": " + String.format( " %02d ",this.minutes) + 
                ": " + String.format( " %02d ",this.seconds) + " ";
    };
    
    
    
    
    
    
    
    
    
}
