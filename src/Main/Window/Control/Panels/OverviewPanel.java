/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Window.Control.Panels;

import Main.Database;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author fathe
 */
public class OverviewPanel extends JPanel
{
    
    public OverviewPanel()
    {
        
        init();
    
    }
    
    
    
    
    private void init()
    {       
        
        this.setSize(new Dimension(400,400));
        this.setBackground(Color.lightGray);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        
                
        this.lblTitle = new JLabel("Overview");
        this.lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
        this.lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        //this.lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c.gridx = 0;  
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 2;
        c.weighty = 0.20;
        c.ipady = 10;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.lblTitle,c);        
        
        
        
        
        
        
        this.lblNumVehicles = new JLabel("Number Of Vehicles: ");  
        this.lblNumVehicles.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;  
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.30; 
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblNumVehicles,c);  
        
        this.lblNumAccidents = new JLabel("Number of Accidents: ");  
        this.lblNumAccidents.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;  
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.30; 
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblNumAccidents,c);          
        
    
        
        
        this.lblShowNumVehicles = new JLabel();  
        this.lblShowNumVehicles.setText(String.valueOf(Database.getVehicleListSize()));
        
        this.lblShowNumVehicles.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblShowNumVehicles.setBorder(javax.swing.BorderFactory.createEtchedBorder(null,Color.GRAY));
        c.gridx = 2;  
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.30; 
        c.ipady = 0;
        c.ipadx = 30;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblShowNumVehicles,c);  
        
        this.lblShowNumAccidents = new JLabel(String.valueOf(Database.getNumAccident()));  
        this.lblShowNumAccidents.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblShowNumAccidents.setBorder(javax.swing.BorderFactory.createEtchedBorder(null,Color.GRAY));
        c.gridx = 2;  
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.30; 
        c.ipadx = 30;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblShowNumAccidents,c);      
    
    
    
    
            
        JLabel space = new JLabel(); 
        c.gridx = 2;  
        c.gridy = 10;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 5; 
        c.ipady = 0;
        this.add(space,c);  
    }
    
    public void update()
    {
        this.lblShowNumAccidents.setText(String.valueOf(Database.getNumAccident())); 
    }
    
    
    private JLabel lblTitle;
        
    private JLabel lblNumVehicles;
    private JLabel lblNumAccidents;
    
    private JLabel lblShowNumVehicles;
    private JLabel lblShowNumAccidents;
    
    
    
}
