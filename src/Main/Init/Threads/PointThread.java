/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Init.Threads;

import Main.Init.Point;
import Main.Init.PointHashTable;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author fathe
 */
public class PointThread extends Thread
{
    private PointHashTable PHT;  
    private Node[] listOfNodes;
    public int ID;

    
    public PointThread(PointHashTable PHT, Node[] listOfNodes, int ID)
    {
        this.PHT = PHT;
        this.listOfNodes = listOfNodes;
        
        this.ID = ID;        

    }

    
    @Override
    public void run() 
    {
        //String pointID = " ";
        //double longitude = 0;
        //double latitude = 0;
        Point curPoint;
        
        //System.out.println("THREAD ID: " + ID +   "         Arr Size:  "  + listOfNodes.length);
        
        while(true)
        {
        
            try
            {
                //ITERATES BY THE SIZE OF THE NODELIST WITH TAG NAME 'NODE'
                //System.out.println("Number of Nodes  " + listOfNodes.getLength());

                for(int i=0; i < listOfNodes.length; i++ )
                {
                    //System.out.println(i);
                    
                    //USED AS A REFERENCE VARIBALE FOR A GIVEN NODE IN THE NODELIST
                    Node curNode = listOfNodes[i];

                    //GET THE NODE ID
                    //pointID = curNode.getAttributes().getNamedItem("id").getNodeValue();
                    //GET THE LATITUDE
                    //latitude = Double.parseDouble(curNode.getAttributes().getNamedItem("lat").getNodeValue());
                    //GET THE LONGITUDE
                    //longitude = Double.parseDouble(curNode.getAttributes().getNamedItem("lon").getNodeValue());

                    //INSTANTIATE NEW POINT OBJECT
                    curPoint = new Point(curNode.getAttributes().getNamedItem("id").getNodeValue());
                    //SET LATITUDE
                    curPoint.setLatitude(Double.parseDouble(curNode.getAttributes().getNamedItem("lat").getNodeValue()));
                    //SET LONGITITUDE
                    curPoint.setLongitude(Double.parseDouble(curNode.getAttributes().getNamedItem("lon").getNodeValue()));

                    //ADD POINT TO THE HASHTABLE
                    PHT.put(curPoint);
                }
                
                
                //System.out.println("Break  " + ID );
                break;
            }
            catch(Exception ex)
            {
                //System.out.println("SOMETHING WRONG:  " + ID);
            }        
   
        }
       
    }
    
    

    }
    
    
    
    

