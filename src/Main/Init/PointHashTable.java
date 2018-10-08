package Main.Init;

/*******************************************************************************
***CLASS NAME: PointHashTable
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: STORE OBJECT POINTS IN A HASHTABLE
********************************************************************************
***DATE: SEPTEMBER 28,2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class PointHashTable 
{
    LinkList[] Table;
    
    
    /***************************************************************************
    ***METHOD NAME: PointHashTable() 
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 2018, 2018
    ***************************************************************************/ 
    public PointHashTable()
    {
        Table = new LinkList[10000];     
    }
    
    
    /***************************************************************************
    ***METHOD NAME: put()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: PLACE POINT IN THE HASHTABLE
    ***METHOD USED: HashFunctionKey()
    ***METHOD PARAMETERS: Point 
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/ 
    public void put(Point newPoint)
    { 
        try
        {
            //GETS A KEY FOR THE LOCATION OF THE OBJECT    
            int indexKey = Integer.parseInt(HashFunctionKey(newPoint.nodeID).toString());

            //IF THE LOCATION IN THE ARRAY IS EMPTY, THEN FILL IT
            if(Table[indexKey] == null)
            {
                //NEW LINKLIST OBJECT IS MADE
                LinkList newObj = new LinkList(); 
                //THE LINKLIST OBJECT STORES A OBJECT TYPE POINT
                newObj.setPoint(newPoint); 
                //THE LINKLIST REFERENCE VARIABLE IS SET TO NULL
                newObj.setLinkList(null); 
                //THE LINKLIST IS PLACE IN THE ARRAY
                Table[indexKey] = newObj;         
            }
            else
            {   //LINKLIST TEMP WILL REFERENCE THE FIRST LINKLIST IN THE ARRAY
                LinkList temp = Table[indexKey];

                do
                {
                    //IF THE NEXT LINKLIST DOES NOT EXIST, THEN WE'LL STORE THE 
                    //NEW LINKLIST AFTER THE LAST ONE
                    if(temp.getNextLink() == null)
                    {
                        //NEW LINKLIST OBJECT IS MADE
                        LinkList newObj = new LinkList();
                        //THE LINKLIST OBJECT STORES A OBJECT TYPE POINT
                        newObj.setPoint(newPoint); 
                        //THE LINKLIST REFERENCE VARIABLE IS SET TO THE NEW LINKLIST
                        temp.setLinkList(newObj);    
                        break;
                    } 
                    else
                    {
                        //GET THE NEXT LINKLIST IN THE CHAIN
                        temp = temp.getNextLink();
                    }   
                //CONTINUE LOOPING UNTIL TEMP IS NULL
                }while(temp != null);
            } 
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    /***************************************************************************
    ***METHOD NAME: getPoint()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN THE POINT OBJECT STORED IN THE HASHTABLE
    ***METHOD USED: HashFunctionKey()
    ***METHOD PARAMETERS: STRING (NUMERIC)
    ***RETURN VALUE: POINT
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/  
    public Point getPoint(String PointID)
    {
        Point point = null;
        
        try
        {
            //GETS A KEY FOR THE LOCATION OF THE OBJECT
            int indexKey = Integer.parseInt(HashFunctionKey(PointID).toString());
            
            //IF THE LOCATION IS NOT EMPTY, THEN CHECK AND SEE IF MY OBJECT IS THERE
            if(Table[indexKey] != null) // if the location is not empty, then
            {
                //LINKLIST TEMP WILL REFERENCE THE FIRST LINKLIST IN THE ARRAY
                LinkList temp = Table[indexKey]; 

                    do
                    {
                        //IF THE NODEID MATCHES WHAT I'M LOOKING FOR, THEN COLLECT MY OBJECT
                        if(temp.getPoint().nodeID.equals(PointID)) 
                        {
                            //GET MY OBJECT
                            point = temp.getPoint();
                            //END DO-WHILE LOOP
                            break;
                        } 
                        //IF THE NODEID OF THE NEXT LINKLIST POINT MATCHES WHAT I'M LOOKING FOR, THEN COLLECT MY OBJECT
                        else if(temp.getNextLink().getPoint().nodeID.equals(PointID))
                        {
                            //GET MY OBJECT
                            point = temp.getNextLink().getPoint();
                            //END DO-WHILE LOOP
                            break;
                        }   
                        else if(temp.getNextLink() != null)
                        {
                            //GO TO THE NEXT LINKLIST OF THE CHAIN
                            temp = temp.getNextLink();
                        }
                        else
                        {
                            break;
                        }
                    }while(!(temp.getPoint().nodeID.equals(PointID)));

        }
        }catch(Exception ex){}
        
        //RETURN THE OBJECT
        return point;
        

    }
  
    
    /***************************************************************************
    ***METHOD NAME: HashFunctionKey() 
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CREATE A HASHTABLE KEY FOR THE LOCATION OF AN ITEM
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING (NUMERIC)
    ***RETURN VALUE: LONG
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/ 
    private Long HashFunctionKey(String curPointID)
    {
        //NUMERIC STRING IS CAST TO LONG AND 
        //THEN A MODULAR OF 10000 IS CALCULATED
        return Long.parseLong(curPointID) % 10000;
    }
      
}
