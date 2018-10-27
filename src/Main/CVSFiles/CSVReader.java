/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.CVSFiles;

import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Operators.StopSign;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class CSVReader 
{
    private PointHashTable PHT;
    
    public CSVReader(PointHashTable PHT)
    {
        this.PHT = PHT;
    }
    
    
    public void ReadFile()
    {
        String csvFile = "src\\Main\\other\\ssTEST3.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {

            while ((line = br.readLine()) != null) 
            {

                // use comma as separator
                String[] arr = line.split(cvsSplitBy);
                
                setUp(arr[0], arr[1]);

            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private void setUp(String ID, String type)
    {
        StopSign ss = null;

        Point p = PHT.getPoint(ID);
        
        if(type.equals("ss"))
        {
            ss = new StopSign(p);
            
            PHT.put(ss);
        }
        
        //System.out.println(ss.getID());
    
        
    
    }
    
}
