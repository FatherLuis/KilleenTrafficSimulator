package Main.Window;

import Main.Clock;
import Main.Database;
import Main.Window.Control.Panels.CurrentCarPanel;
import Main.Window.Control.Panels.OverviewPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    
    private TimerPanel Timer;
    private CurrentCarPanel CCP;
    private OverviewPanel OP;
    
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
        //init();
        //setUpPanels();
        
        
    }    
    
    public void setCCP(CurrentCarPanel CCP){this.CCP = CCP;}
    public void setOP(OverviewPanel OP){this.OP = OP;}
    
    public void init()
    {  
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);  
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(1,1,1,1);
        
        ListenForItemStateChange StateChange = new ListenForItemStateChange();
        
        
        
        this.Timer = new TimerPanel();  
        c.gridx = 0;  
        c.gridy = 0;
        c.weighty = 0.05;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.Timer,c);


        this.cmbPanelChoice = new JComboBox();
        this.cmbPanelChoice.addItemListener(StateChange);
        cmbPanelChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Overview", "Current Car", "What-If Scenerios"}));   
        c.gridx = 0;  
        c.gridy = 1;
        c.weighty = 0.05;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.cmbPanelChoice,c);
        
        this.panel = new JPanel(new CardLayout());
        OP.setBackground(Color.LIGHT_GRAY);
        
        this.panel.add(OP,"Overview");
        this.panel.add(CCP,"Current Car");
        c.gridx = 0;  
        c.gridy = 2;
        c.weighty = 0.60;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.panel,c);
        
        
        
        

        
        
    }
    
    
    public void setClock(String time)
    {
        this.Timer.setClock(time);
        //this.lblClock.setText(time);
    }
    
    public boolean isOn()
    {
        return this.Timer.isOn();
        //return this.isOn;
        //return true;
    }
    
    public int getIntFastForward()
    {
        return this.Timer.getIntFastForward();
        //return this.intFastForward;
        //return 1;
    }
    
    private JPanel panel;
    private JComboBox cmbPanelChoice;
    
   

    private class ListenForItemStateChange implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent ie) 
        {
            CardLayout cl = (CardLayout)(panel.getLayout());
            //System.out.println(ie.getItem());
            cl.show(panel, (String)ie.getItem());
        }
    }    
    
    
    
}
