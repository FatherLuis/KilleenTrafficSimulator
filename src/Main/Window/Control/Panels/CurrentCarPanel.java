/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Window.Control.Panels;

import Main.Vehicles.Vehicle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author fathe
 */
public class CurrentCarPanel extends JPanel
{
    private ArrayList<Vehicle> vehicleList;
    
    private int currentCar = -1;
    
    
    public CurrentCarPanel(ArrayList<Vehicle> vehicleList)
    {
        super();
        
        this.vehicleList = vehicleList;
        
        init();
    }
    
    
    private void init()
    {         
        RadioButtonListener RBL = new RadioButtonListener();
        
        
        this.setSize(new Dimension(400,400));
        this.setBackground(Color.lightGray);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        this.lblTitle = new JLabel("Current Car");
        this.lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
        this.lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        //this.lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c.gridx = 0;  
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 2;
        c.weighty = 0.10;
        c.ipady = 20;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.lblTitle,c);
        
        
        this.lblLongitude = new JLabel("Longitude: ");  
        this.lblLongitude.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;  
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10; 
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblLongitude,c);          
        
        this.lblLatitude = new JLabel("Latitude: ");  
        this.lblLatitude.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;  
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10; 
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblLatitude,c);          
        
       
        this.lblID = new JLabel("ID: ");  
        this.lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;  
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10; 
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblID,c);    
        
        this.lblSpeed = new JLabel("Speed: ");  
        this.lblSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;  
        c.gridy = 5;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblSpeed,c);         
 
        this.lblCurrentRoad = new JLabel("Current Road: ");  
        this.lblCurrentRoad.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0;  
        c.gridy = 6;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblCurrentRoad,c);   
        
        
        
        
        
        
        
        
        
        
        
        
         
        this.lblCarLongitude = new JLabel("0.000000000 ");  
        this.lblCarLongitude.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblCarLongitude.setBorder(javax.swing.BorderFactory.createEtchedBorder(null,Color.GRAY));
        c.gridx = 2;  
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10; 
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblCarLongitude,c);          
        
        this.lblCarLatitude = new JLabel("0.000000000");  
        this.lblCarLatitude.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblCarLatitude.setBorder(javax.swing.BorderFactory.createEtchedBorder(null,Color.GRAY));
        c.gridx = 2;  
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10; 
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblCarLatitude,c);         
        
        
        this.lblCarID = new JLabel("123456 ");  
        this.lblCarID.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblCarID.setBorder(javax.swing.BorderFactory.createEtchedBorder(null,Color.GRAY));
        c.gridx = 2;  
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipadx = 40;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblCarID,c);    

        this.lblCarSpeed = new JLabel("0 MPH ");  
        this.lblCarSpeed.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblCarSpeed.setBorder(javax.swing.BorderFactory.createEtchedBorder(null,Color.GRAY));
        c.gridx = 2;  
        c.gridy = 5;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipadx = 40;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblCarSpeed,c);         
 
        this.lblCarCurrentRoad = new JLabel("Trimmer");  
        this.lblCarCurrentRoad.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblCarCurrentRoad.setBorder(javax.swing.BorderFactory.createEtchedBorder(null,Color.GRAY));
        c.gridx = 2;  
        c.gridy = 6;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipadx = 20;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblCarCurrentRoad,c);    
        
        this.lblAccident = new JLabel("Is in Accident: ");  
        this.lblAccident.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 1;  
        c.gridy = 7;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipadx = 20;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.lblAccident,c);         
        
        
        this.rbYes = new JRadioButton("Yes");
        this.rbYes.setBackground(Color.GRAY);
        this.rbYes.addActionListener(RBL);
        
        this.rbNo = new JRadioButton("No");
        this.rbNo.setBackground(Color.GRAY);
        this.rbNo.addActionListener(RBL);
        
        this.bgRadioBtn = new ButtonGroup();
        bgRadioBtn.setSelected(rbYes.getModel(), false);
        
        
        
        this.bgRadioBtn.add(rbYes);    
        c.gridx = 0;  
        c.gridy = 8;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipadx = 40;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.rbYes,c); 
        
        
        this.bgRadioBtn.add(rbNo);   
        c.gridx = 2;  
        c.gridy = 8;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.10;
        c.ipadx = 40;
        c.ipady = 0;
        //c.fill = GridBagConstraints.EAST;
        this.add(this.rbNo,c); 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        JLabel space = new JLabel(); 
        c.gridx = 2;  
        c.gridy = 10;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 5; 
        c.ipady = 0;
        this.add(space,c);  

    }
    
    public void setCarID(String ID){this.lblCarID.setText(ID);}
    public void setCarLon(String lon){this.lblCarLongitude.setText(lon);}
    public void setCarLat(String lat){this.lblCarLatitude.setText(lat);}
    public void setCarSpeed(String speed){this.lblCarSpeed.setText(speed);}
    public void setCarCurrentRoad(String CCR){this.lblCarCurrentRoad.setText(CCR);}
    
    public void setInAccident(Boolean isAccident)
    {
        if(isAccident == true)
        {
            bgRadioBtn.setSelected(rbYes.getModel(), true);
            rbYes.setFocusable(false);
        
        }
        else
        {
            bgRadioBtn.setSelected(rbNo.getModel(), true);
            rbNo.setFocusable(false);
        }
    
    
    }
    
    
    public void setCurrentvehicle(int vehicle)
    {
        this.currentCar = vehicle;
    }
    
    public void setCurrentIndex(int index)
    {
        this.currentCar = index;
    }
    
    
    public void update()
    {
        if(currentCar >=0)
        {
          this.setCarID(String.valueOf(vehicleList.get(this.currentCar).getID()));
          this.setCarLon(String.valueOf(vehicleList.get(this.currentCar).getCorX()));
          this.setCarLat(String.valueOf(vehicleList.get(this.currentCar).getCorY()));
          this.setCarSpeed(String.valueOf(vehicleList.get(this.currentCar).getSpeed()));
          this.setCarCurrentRoad(vehicleList.get(this.currentCar).getRoad().getName());
          this.setInAccident(vehicleList.get(this.currentCar).getInAccident());
          
          
        }
    }
    
    
    
    private JLabel lblTitle;
    
    private JLabel lblLongitude;
    private JLabel lblLatitude;
    private JLabel lblID;
    private JLabel lblSpeed;
    private JLabel lblCurrentRoad;
    private JLabel lblAccident;
    
    private JLabel lblCarLongitude;
    private JLabel lblCarLatitude;    
    private JLabel lblCarID;
    private JLabel lblCarSpeed;
    private JLabel lblCarCurrentRoad;
    
    private ButtonGroup bgRadioBtn;
    private JRadioButton rbYes;
    private JRadioButton rbNo;
    
    
    
    private class RadioButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(currentCar >= 0)
            {
                if(e.getSource()==rbYes)
                {
                    vehicleList.get(currentCar).setInAccident(true);
                }
                if(e.getSource()==rbNo )
                {
                    vehicleList.get(currentCar).setInAccident(false);
                }
            }
        }
        
    }    
    
    
}
