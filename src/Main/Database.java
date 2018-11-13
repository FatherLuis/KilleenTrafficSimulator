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
    
    
    static
    {
        vehicleList = new ArrayList();
        roadList = new ArrayList();
        schoolList = new ArrayList();
        boundList = new double[4];
        PHT = new PointHashTable();
        numAccidents = 0; 
        
    }
     
    
    
    public static void addAccident(){numAccidents++;}
    public static void subAccident(){numAccidents--;}
    public static int getNumAccident(){return numAccidents;}
    
    
    public static ArrayList<Vehicle> getVehicleList(){ return vehicleList;} 
    public static ArrayList<Road> getRoadList(){return roadList;}   
    public static ArrayList<School> getSchoolList(){return schoolList;}
    public static PointHashTable getPHT(){return PHT;}
    
    public static int getVehicleListSize(){return vehicleList.size();}
    public static int getRoadListSize(){return roadList.size();}
    public static int getSchoolListSize(){return schoolList.size();}
    
    
    
    public static void addVehicle(Vehicle vehicle){vehicleList.add(vehicle);}
    public static void addRoad(Road road){roadList.add(road);}
    public static void addPoint(Point point){ PHT.put(point);}
    public static void addSchool(School school){ schoolList.add(school);}
    public static void setBounds( int index, double bound ){ boundList[index] = bound;}
    
    
    public static Road getRoad(int index){return roadList.get(index);}
    public static Vehicle getVehicle(int index){return vehicleList.get(index);}
    public static School getSchool(int index){return schoolList.get(index);}
    public static double getBounds(int index){return boundList[index];}
    public static Point getPoint(String pointID){ return PHT.getPoint(pointID);}
    
    
    
    
    
    
    
    
    
    
}
