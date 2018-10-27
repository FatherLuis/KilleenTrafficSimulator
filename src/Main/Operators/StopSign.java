/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Operators;

import Main.Init.Point;


public class StopSign extends Point
{
    public StopSign(Point p) 
    {
        super(p.getID()); 
        this.latitude = p.getLatitude();
        this.longitude = p.getLongitude();
        this.parentList = p.getParentList();
    }
    
}
