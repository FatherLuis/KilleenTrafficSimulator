/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Window;

import Main.Clock;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author fathe
 */
public class TimerPanel extends JPanel
{   
    
    private int intFastForward;
    private boolean isOn;
    
    
    public TimerPanel()
    {
        super();
        
        this.intFastForward = 1;
        this.isOn = true;
        init();

    }
    
    private void init()
    {
        this.setPreferredSize(new Dimension(400,200));
        this.setBackground(Color.GRAY); 
        //this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setLayout(new GridBagLayout());
    
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,20,0);
        
        ListenForButton ActionForButton = new ListenForButton();

       
        this.lblClock = new JLabel(" 00 : 00 : 00 ");  
        this.lblClock.setFont(new Font("SansSerif", Font.PLAIN, 18));
        this.lblClock.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblClock.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        c.gridx = 0;  
        c.gridy = 0;
        c.gridwidth = 6;
        c.gridheight = 2;
        c.weightx = 0.60;
        c.ipadx = 40;
        c.ipady = 40;
        c.fill = GridBagConstraints.EAST;
        this.add(this.lblClock,c);
        
        this.btnChangeTime = new JButton("Change Time ...");
        this.btnChangeTime.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 6;  
        c.gridy = 0;  
        c.gridwidth = 3;
        c.gridheight = 2;
        //c.weighty = .05;
        c.ipadx = 10;
        c.ipady = 10;
        c.fill = GridBagConstraints.WEST;
        this.add(this.btnChangeTime,c);
        
        
        this.btnPause = new JButton("||");
        this.btnPause.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 0;  
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        //c.weighty = .05;
        c.ipadx = 10;
        c.ipady = 10;
        c.fill = GridBagConstraints.NONE;
        this.btnPause.addActionListener(ActionForButton);
        this.add(this.btnPause,c);
        
        this.btnNormalForward = new JButton(">");
        this.btnNormalForward.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 2;  
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        //c.weighty = .05;
        c.ipadx = 10;
        c.ipady = 10;
        c.fill = GridBagConstraints.NONE;
        this.btnNormalForward.addActionListener(ActionForButton);
        this.add(this.btnNormalForward,c);
        
        
        this.btnFastForward = new JButton(">>");
        this.btnFastForward.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 4;  
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        //c.weighty = .05;
        c.ipadx = 10;
        c.ipady = 10;
        c.fill = GridBagConstraints.NONE;
        this.btnFastForward.addActionListener(ActionForButton);
        this.add(this.btnFastForward,c);    
    
    
    
    
    
    
    }
    
    public void setClock(String time)
    {
        this.lblClock.setText(time);
    }
    
    public boolean isOn()
    {
        return this.isOn;
    }
    
    public int getIntFastForward()
    {
        return this.intFastForward;
    }
    
    
    
    
    
    private JButton btnPause;
    private JButton btnFastForward; 
    private JButton btnNormalForward;
    
    private JLabel lblClock;
    private JButton btnChangeTime;    
    
    private class ListenForButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            
            if(evt.getSource() == btnPause)
            {
                isOn = false;
                intFastForward = 1;
            }
            else if(evt.getSource() ==btnFastForward)
            {
                intFastForward += 1;
                
            }
            else if(evt.getSource() == btnNormalForward || evt.getSource() ==btnFastForward)
            {
                isOn = true;
            }
            
        
        }
    }
    
    
    
}
