package Main.Init;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.*;


/*******************************************************************************
***CLASS NAME: File_IO
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: COLLECT INFORMATION FROM AN XML FILE
********************************************************************************
***DATE: SEPTEMBER 28, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class File_IO 
{
    private Document xmlDoc;
    private ArrayList<Road> AllRoads; 
    private double[] bounds;
    private PointHashTable PHT;

    
    /***************************************************************************
    ***METHOD NAME: File_IO 
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public File_IO()
    {
        //YOU CAN CHANGE THE FILE PATH TO A DIFFERENT XML FILE
        this.xmlDoc = getDocument("src\\Maps\\TEST5.xml");
        AllRoads = new ArrayList();
        PHT = new PointHashTable();       
    }
  
    
    /***************************************************************************
    ***METHOD NAME: getDocument() 
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CREATE A DOCUMENT OBJECT FROM THE XML FILE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING (FILE LOCATION)
    ***RETURN VALUE: DOCUMENT OBJECT
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ****************************************************************************
    ***SPECIAL NOTE: I GOT THE CODE FROM DEREK BANAS YOUTUBE VIDEO IN CONVERTING
    *** XML FILE TO DOCUMENT; LINK BELOW
    *** https://www.youtube.com/watch?v=q-oQ5D91TAk&t=169s
    ***************************************************************************/     
    private  Document getDocument(String docString)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(false);

            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(new InputSource(docString));          
        }
        catch(Exception ex){}
        
        return null;
    }
 
    
    /***************************************************************************
    ***METHOD NAME: GetBounds()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: COLLECT THE BOUNDARY OF THE MAP
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/  
    private void GetBounds()
    {
        //GET A NODELIST OF ONLY TAGS WITH THE WORD 'BOUNDS'
        NodeList listOfBounds = xmlDoc.getElementsByTagName("bounds");
        //LET THE FIRST NODE BE STORED
        Node bound =  listOfBounds.item(0);
        
        //INITIALIZE ARRAY WITH FOUR SLOTS
        bounds = new double[4];
        
        //STORE THE MINLAT 
        bounds[0] = Double.parseDouble(bound.getAttributes().getNamedItem("minlat").getNodeValue());
        //STORE THE MINLON
        bounds[1] = Double.parseDouble(bound.getAttributes().getNamedItem("minlon").getNodeValue());
        //STORE THE MAXLAT
        bounds[2] = Double.parseDouble(bound.getAttributes().getNamedItem("maxlat").getNodeValue());
        //STORE THE MAXLON 
        bounds[3] = Double.parseDouble(bound.getAttributes().getNamedItem("maxlon").getNodeValue()); 
        
    }
  
    
    /***************************************************************************
    ***METHOD NAME: GetRoads()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: COLLECT ROAD INFORMATION FROM XML FILE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    private  void GetRoads()
    {
        boolean Accept;
        
        Road Calle;
        String roadName ="";
        String roadID = " ";
        String refID = " ";
        ArrayList<String> ref = null;
        
        String attrK = "";
        String attrV = "";
        
        //GET A NODELIST OF ONLY TAGS WITH THE WORD 'WAY'
        NodeList listOfWays = xmlDoc.getElementsByTagName("way");
        
        try
        {
            //ITERATE BY THE LENGTH OF THE NODELIST WITH TAG 'WAY'
            for(int i=0; i < listOfWays.getLength(); i++)
            {
                Accept = false;
                
                
                //USED AS A REFERENCE VARIBALE FOR A GIVEN NODE IN THE NODELIST
                Node laNode = listOfWays.item(i);
                //STORES THE WAY ID FROM THE CURRENT NODE
                String NodeID = laNode.getAttributes().getNamedItem("id").getNodeValue();                
                //CAST NODE AS A ELEMENT OBJECT
                Element curElement = (Element) laNode;
                //GETS NODELIST OF ONLY TAGS WITH THE WORD 'TAG'
                NodeList refList2 = curElement.getElementsByTagName("tag");
                
                //ITERATES BY THE SIZE OF THE NODELIST WITH TAG NAME 'TAG'
                for(int j = 0; j < refList2.getLength(); j++)
                {
                    //ARRAY IS INITIALIZED; ARRAY HOLDS INT VALUES THAT REFER TO THE POINT ID'S
                    ref = new ArrayList();
                    
                    //USED AS A REFERENCE VARIABLE FOR A GIVEN NODE IN THE NODELIST
                    Node refList2Element = refList2.item(j);
                    
                    //IF THE ATTRIBUTE IS NOT 'ADMIN' , THE CONTINUE ON WITH CODE
                    if(!refList2Element.getAttributes().getNamedItem("k").getNodeValue().equals("admin_level"))
                    {
                        //STORE ITERATING ATTRIBUTE
                        attrK = refList2Element.getAttributes().getNamedItem("k").getNodeValue();
                        attrV = refList2Element.getAttributes().getNamedItem("v").getNodeValue();
                        
                        
                        //SWITCH WILL ACT AS A FILERING MECHANISM TO GET ONLY SELECTED WAYS
                        switch(attrK)
                        {
                            case("name"):                                
                                roadID = NodeID;
                                roadName = attrV;
                                break;
                                
                            case("highway"):
                                
                                if(!(attrV.equals("service") || attrV.equals("footway") || attrV.equals("track") || attrV.equals("pedestrian")  ))
                                {
                                    roadID = NodeID;
                                    roadName = "NO NAME";
                                    Accept = true;  
                                }                              
                                break;
                               
                            default:
                                break;
                        }
                        
                        
                    }
                    else
                    {
                        break;
                    }
                }

                //GET A NODELIST OF ONLY TAGS WITH THE WORD 'NG'
                NodeList refList = curElement.getElementsByTagName("nd");
                
                //IF CURRENT WAY IS ACCEPTED, THEN CONTINUE WITH CODE
                if(Accept)
                {
                    //ITERATE BY THE SIZE OF THE REFERENCE ARRAYLIST
                    for(int j = 0; j < refList.getLength(); j++)
                    {
                        //GET THE GIVEN NODE FROM THE NODELIST
                        Node refListElement = refList.item(j);
                        //GET THE NUMERIC STRING AND STORE
                        refID = refListElement.getAttributes().getNamedItem("ref").getNodeValue();
                        //ADD THE REFERENCE ID TO THE ARRAYLIST
                        ref.add(refID);
                        
                    }
                    
                    //INSTANTIATE NEW ROAD
                    Calle = new Road();
                    //SET ROAD ID
                    Calle.setID(roadID);
                    //SET ROAD NAME
                    Calle.setName(roadName);
                    //SET REF ARRAY
                    Calle.setRef(ref);   
                    //ADD ROAD TO THE ALLROADS
                    this.AllRoads.add(Calle);  
                }  
                
            }
  
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());    
        }
    }
  
    
    /***************************************************************************
    ***METHOD NAME: GetPoints
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: COLLECT XY POINTS FROM THE XML FILE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    private void GetPoints()
    {        
        String pointID = " ";
        double longitude = 0;
        double latitude = 0;
        Point curPoint;
        
        //GET A NODELIST OF ONLY TAGS WITH THE WORD 'NODE'
        NodeList listOfNodes = xmlDoc.getElementsByTagName("node");
        
        try{
            //ITERATES BY THE SIZE OF THE NODELIST WITH TAG NAME 'NODE'
            for(int i=0; i < listOfNodes.getLength();i++ )
            {
                //USED AS A REFERENCE VARIBALE FOR A GIVEN NODE IN THE NODELIST
                Node curNode = listOfNodes.item(i);
                
                //GET THE NODE ID
                pointID = curNode.getAttributes().getNamedItem("id").getNodeValue();
                //GET THE LATITUDE
                latitude = Double.parseDouble(curNode.getAttributes().getNamedItem("lat").getNodeValue());
                //GET THE LONGITUDE
                longitude = Double.parseDouble(curNode.getAttributes().getNamedItem("lon").getNodeValue());
                
                //INSTANTIATE NEW POINT OBJECT
                curPoint = new Point(pointID);
                //SET LATITUDE
                curPoint.setLatitude(latitude);
                //SET LONGITITUDE
                curPoint.setLongitude(longitude);
                
                //ADD POINT TO THE HASHTABLE
                PHT.put(curPoint);
            }
        }
        catch(Exception ex)
        {}

    }
 
    
    /***************************************************************************
    ***METHOD NAME: AssignParents()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: LETS EACH NODE KNOW IN WHICH COLLECTION THEY'RE IN
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTUBER 5 , 2018
    ***************************************************************************/   
    private void AssignParents()
    {
        ArrayList<String> refID;
        Point p;
        
        //ITERATE BY THE NUMBER OF ROADS
        for(int i = 0; i < this.AllRoads.size(); i++)
        {
            //USED AS A REFERENCE
            refID = this.AllRoads.get(i).getRef();
            
            //ITERATE BY THE SIZE OF THE REFARR
            for(int j = 0 ; j < refID.size(); j++)
            {
                //GET POINT FROM HASHTABLE
                p = this.PHT.getPoint(refID.get(j));
                //LET POINT KNOW WHO IT'S PARENT IS
                p.addParent(this.AllRoads.get(i));            
            }
        }
    }
    
    
    /***************************************************************************
    ***METHOD NAME: MainCalculation()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: DO ALL OPERATIONS TO XML FILE
    ***METHOD USED: GetBounds(), GetRoads(), GetPoints(), AssignParents()
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/         
    public void MainCalculation()
    {
            Long start;
            Long end;
    
        
        GetBounds();
            //start = System.currentTimeMillis();
        GetRoads();
            //end = System.currentTimeMillis();
            //System.out.println("GetRoad Time: "+(double)(end - start)/1000+ " Seconds");
            //start = System.currentTimeMillis();
        GetPoints();
            //end = System.currentTimeMillis();
            //System.out.println("GetPoints Time: "+(double)(end - start)/1000+ " Seconds");
            //start = System.currentTimeMillis();
        AssignParents();
            //end = System.currentTimeMillis();
            //System.out.println("AssignParents Time: "+(double)(end - start)/1000+ " Seconds");
            //start = System.currentTimeMillis();
    }
    

    /***************************************************************************
    ***METHOD NAME: getRoads()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN ROAD ARRAYLIST
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28 2018
    ***************************************************************************/  
    public ArrayList getRoads()
    {
        return this.AllRoads;
    }
  
    /***************************************************************************
    ***METHOD NAME: getBounds()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN BOUND ARRAYLIST
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28 2018
    ***************************************************************************/     
    public double[] getBounds() 
    {
        return this.bounds;
    }
  
    /***************************************************************************
    ***METHOD NAME: gethashTable()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN HASHTABLE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: SEPTEMBER 28, 2018
    ***************************************************************************/     
    public PointHashTable gethashTable()
    {
        return this.PHT;
    }
    
  
    
}
