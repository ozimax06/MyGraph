/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ozan
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//******FOR UNDIRECTED GRAPHS
package graphs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ozan
 */
public class graphTools2 extends JPanel
{

    public static JPanel mainPanel, cityPanel, edgePanel, distancePanel;
    
    
    //COMPONENTS OF distancePanel(to get the shortest distance)
    public static JTextField initialCity, terminalCity;
    public static JButton distanceButton, returnButton, editButton;
    public static JLabel distanceLabel1, distanceLabel2, distanceLabel3;
    
    

    
    public graphTools2()
    {
        
        
        mainPanel = new JPanel();
        mainPanel.setPreferredSize (new Dimension(420, 250));
        mainPanel.setBackground (Color.blue);
        
      
        
        distancePanel = new JPanel();
        distancePanel.setPreferredSize (new Dimension(600, 120));
        distancePanel.setBackground (Color.LIGHT_GRAY);
        
       

      

        
        distanceLabel2 = new JLabel("                    ");//SIZE 20
        
         

        distanceLabel1 = new JLabel(" To get the shortest distance from one to the other point, enter initial and terminal cities, respectively.");
        
        
        initialCity = new JTextField(10);
        initialCity.setForeground(Color.black);
        initialCity.setToolTipText("Enter the city you want to get direction FROM.");
        
        terminalCity = new JTextField(10);
        terminalCity.setForeground(Color.black);
        terminalCity.setToolTipText("Enter the final destination");
        
        distanceButton = new JButton("GET SHORTEST DISTANCE");
        distanceButton.setBackground(Color.white);
        distanceButton.setToolTipText("Make sure that you entered valid cities that are CONNECTED");
        
        editButton = new JButton("Edit Graph");
        editButton.setBackground(Color.white);
        editButton.setToolTipText(" Allows you to add new cities and new direction");
        
        returnButton = new JButton("Remove the distance path");
        returnButton.setBackground(Color.white);
        returnButton.setToolTipText(" Removes the path and returns to the original graph");
        
        
        distancePanel.add(distanceLabel1);
        distancePanel.add(initialCity);
        distancePanel.add(terminalCity);
        distancePanel.add(distanceButton);
        distancePanel.add(returnButton);
        distancePanel.add(editButton);
        distancePanel.add(distanceLabel2);
        
        mainPanel.add(distancePanel);
             
        
    }        
    
 
}//end of       
