/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Building.School;
import Main.Init.Point;
import Main.Init.PointHashTable;
import Main.Init.Road;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author fathe
 */
public class Database 
{
    private static ArrayList<Vehicle> vehicleList;
    private static ArrayList<Road> roadList;
    private static double[] boundList;
    private static ArrayList<School> schoolList;   
    private static PointHashTable PHT;
    
    private static int numAccidents;
    
    
    public Database()
    {
        vehicleList = new ArrayList();
        roadList = new ArrayList();
        schoolList = new ArrayList();
        boundList = new double[4];
        PHT = new PointHashTable();
        numAccidents = 0; 
        
    }
     
    
    
    public void addAccident(){numAccidents++;}
    public void subAccident(){numAccidents--;}
    public int getNumAccident(){return numAccidents;}
    
    
    public ArrayList<Vehicle> getVehicleList(){ return vehicleList;} 
    public ArrayList<Road> getRoadList(){return roadList;}   
    public ArrayList<School> getSchoolList(){return schoolList;}
    public PointHashTable getPHT(){return PHT;}
    
    public int getVehicleListSize(){return vehicleList.size();}
    public int getRoadListSize(){return roadList.size();}
    public int getSchoolListSize(){return schoolList.size();}
    
    
    
    public void addVehicle(Vehicle vehicle){vehicleList.add(vehicle);}
    public void addRoad(Road road){roadList.add(road);}
    public void addPoint(Point point){ PHT.put(point);}
    public void addSchool(School school){ schoolList.add(school);}
    public void setBounds( int index, double bound ){ boundList[index] = bound;}
    
    
    public Road getRoad(int index){return roadList.get(index);}
    public Vehicle getVehicle(int index){return vehicleList.get(index);}
    public School getSchool(int index){return schoolList.get(index);}
    public double getBounds(int index){return boundList[index];}
    public Point getPoint(String pointID){ return PHT.getPoint(pointID);}
    
    
    
    
    
    
    
    
    
    
}
