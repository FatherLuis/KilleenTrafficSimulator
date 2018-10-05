package Main;

/*******************************************************************************
***CLASS NAME: Normalization
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: NORMALIZE INFORMATION
********************************************************************************
***DATE: SEPTEMBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: THIS CLASS WAS MADE POSSIBLE BY THE PSEUDO CODE FOUND
*** ON ARTIFICIAL INTELLIGENCE FOR HUMAN VOL 1:FUNDAMENTAL ALGORITHMS
*** BY JEFF HEATON
*** 
*******************************************************************************/
public class Normalization 
{
    
    private double dataHigh;
    private double dataLow;
    private double nmHigh;
    private double nmLow;
    private double dataRange;
    private double nmRange;
  
    
    /***************************************************************************
    ***METHOD NAME: NORMALIZATION
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: DOUBLE, DOUBLE, DOUBLE, DOUBLE
    ***RETURN VALUE:
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public Normalization(double dtHigh, double dtLow, double nmHigh,double nmLow)
    {
        this.dataHigh = dtHigh;
        this.dataLow = dtLow;
        this.nmHigh = nmHigh;
        this.nmLow = nmLow;
        this.dataRange = this.dataHigh - this.dataLow;
        this.nmRange = this.nmHigh - this.nmLow;  
    }
 
    
    /***************************************************************************
    ***METHOD NAME: NORMALIZE()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: NORMALIZE GIVEN NUMERIC NUMBER
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: DOUBLE
    ***RETURN VALUE: DOUBLE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public double Normalize(double num)
    {
        double number =  num - this.dataLow;
        double dcNum = number / this.dataRange;
        double dNormNum = this.nmRange * dcNum;
        double finalNormNum = this.nmLow + dNormNum;
        
        return finalNormNum;
    }
    
    
    /***************************************************************************
    ***METHOD NAME: DENORMALIZE()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: DENORMALIZE GIVEN NUMERIC NUMBER
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public double DeNormalize(double num)
    {
        double dNormNum = num - this.nmLow;
        double dcNum = dNormNum / this.nmRange ;
        double number =dcNum * this.dataRange;
        double orinNum = number + this.dataLow;
        
        return orinNum;
    
    
    }
    
    
    
    
    
    
}
