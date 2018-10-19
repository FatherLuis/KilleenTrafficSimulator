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
import javax.swing.JTextField;

/*******************************************************************************
***CLASS NAME: ControlPanel()
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: PANEL WILL CONTAIN CONTROLS THAT WILL AFFECT TRAFFIC PANEL
********************************************************************************
***DATE: OCTOBER 7, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class ControlPanel extends JPanel
{
    public int WIDTH= 400;
    public int HEIGHT = 500; 
    
    private Clock clock;
    
    private boolean isOn;
    
    /***************************************************************************
    ***METHOD NAME: ControlPanel()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: OCTOBER 7, 2018
    ***************************************************************************/     
    public ControlPanel()
    {
        
        
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.GRAY);  
        
        this.setLayout(new GridBagLayout());
        
        clock = new Clock();
        isOn = true;
        init();
    }    
    
    
    private void init()
    {
        
        ListenForButton ActionForButton = new ListenForButton();

        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,20,10,10);

       
        this.lblClock = new JLabel(" 00 : 00 : 00 ");  
        this.lblClock.setFont(new Font("SansSerif", Font.PLAIN, 20));
        this.lblClock.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        c.gridx = 0;  
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.weighty = 0.10;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.lblClock,c);
        
        this.btnChangeTime = new JButton("Change Time...");
        c.gridx = 3;  
        c.gridy = 0;  
        c.gridwidth = 2;
        c.gridheight = 2;
        c.weighty = .10;
        c.fill = GridBagConstraints.WEST;
        this.add(this.btnChangeTime,c);
        
        
        this.btnPause = new JButton("||");
        c.gridx = 0;  
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = .10;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.btnPause.addActionListener(ActionForButton);
        this.add(this.btnPause,c);
        
        this.btnNormalForward = new JButton(">");
        c.gridx = 2;  
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = .10;
        c.fill = GridBagConstraints.HORIZONTAL;    
        this.btnNormalForward.addActionListener(ActionForButton);
        this.add(this.btnNormalForward,c);
        
        
        this.btnFastForward = new JButton(">>");
        c.gridx = 4;  
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = .10;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.btnFastForward.addActionListener(ActionForButton);
        this.add(this.btnFastForward,c);
        
        
        this.lblNumCars = new JLabel("# of vehicles: ");  
        this.lblNumCars.setFont(new Font("SansSerif", Font.PLAIN, 14));       
        c.gridx = 0;  
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 5; 
        c.fill = GridBagConstraints.EAST;
        this.add(this.lblNumCars,c);    
        
        
        this.txtNumCars = new JTextField("200");
        this.txtNumCars.setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        c.gridx = 2;  
        c.gridy = 4;
        c.gridwidth = 5;
        c.gridheight = 1;
        c.weighty = .10;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.txtNumCars,c);  
        
        
        
        
        
    }
    
    
    
    public void setClock(String time){this.lblClock.setText(time);}
    
    public boolean isOn(){return this.isOn;}
    
    private JButton btnPause;
    private JButton btnFastForward; 
    private JButton btnNormalForward;
    
    private JLabel lblClock;
    private JButton btnChangeTime;
    
    private JLabel lblNumCars;
    private JTextField txtNumCars;
 
    
    
   
    private class ListenForButton implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            
            if(evt.getSource() == btnPause)
            {
                isOn = false;
            }
            else if(evt.getSource() == btnNormalForward || evt.getSource() ==btnFastForward)
            {
                isOn = true;
            }
            
        
        }
    }
    
    
    
    
    
}
