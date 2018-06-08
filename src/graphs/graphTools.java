/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ozan
 */
public class graphTools extends JPanel
{
 
   
    //user enter city name,and its coordinates
    public static JTextField cityToEnter, xToEnter, yToEnter;
    //user enters initial, terminal vertices and edge weight
    public static JTextField firstEnter, lastEnter, costEnter;
    
    public static JButton addCityButton, addEdgeButton, drawGraphButton;
    
    public static JLabel label1, label2, label3, empty1, empty2, empty3;
    
    //we ll add new cities to CityPanel and new edges to edgePanel
    //the we ll add all of them to mainPanel.
    public static JPanel mainPanel, cityPanel, edgePanel, distancePanel, IntroPanel;
    
    
    //COMPONENTS OF distancePanel(to get the shortest distance)
    public static JTextField initialCity, terminalCity;
    public static JButton distanceButton, returnButton, editButton, saveButton;
    public static JLabel distanceLabel1, distanceLabel2, distanceLabel3;
    
    //fONT FOR EMPTY 1. when a problem arises in adding a city or edge
    //a warnin message will be displayed in empty1 label
    Font a;

    //COMPONENETS OF INTROPANEL
    //THE PANEL THAT WILL START IN THE BEGINNING OF THE PROGRAM
    //load button gets the data from a saved binary file
    //newbutton opens an empty graph screen without vertices and edges
    public static JButton loadButton, newButton;
    public static JLabel nameLabel, developerLabel, authorLabel, warningLabel;
    public static JLabel emptyIntro1, emptyIntro2;
    
    
    public graphTools()
    {
        a = new Font("Algerian",Font.BOLD,40);
        
     //COMPONENETS OF INTROPANEL
        IntroPanel = new JPanel();
        IntroPanel.setPreferredSize (new Dimension(820, 560));
        IntroPanel.setBackground (Color.black);
        
        loadButton = new JButton("LOAD YOUR EXISTING GRAPH");
        loadButton.setBackground(Color.blue);
        loadButton.setForeground(Color.white);
        
        newButton = new JButton("START WITH A NEW GRAPH SCREEN");
        newButton.setBackground(Color.blue);
        newButton.setForeground(Color.white);
        
        emptyIntro1 = new JLabel("                                                        ");
        
        nameLabel = new JLabel("DISTANCE COMPUTER");
        nameLabel.setForeground(Color.green);
        nameLabel.setFont(a);
        
        
        a = new Font("Times",Font.BOLD,20);
        developerLabel = new JLabel("OZ TECHNOLOGIES");
        developerLabel.setFont(a);
        developerLabel.setForeground(Color.white);
        authorLabel = new JLabel("Developed by Ozan Gazi Onder");
        
        //set to 20 characters
        warningLabel = new JLabel("                    ");
        
        IntroPanel.add(nameLabel);
        IntroPanel.add(emptyIntro1);
        IntroPanel.add(newButton);
        IntroPanel.add(loadButton);
        IntroPanel.add(warningLabel);
        IntroPanel.add(developerLabel);
        IntroPanel.add(authorLabel);
        
        
        
        
     //END OF COMPONENETS FOR THE INTROPANEL   
        
        
    //FIRST PART
        a=new Font("Times",Font.BOLD,15);
        
        mainPanel = new JPanel();
        mainPanel.setPreferredSize (new Dimension(420, 300));
        mainPanel.setBackground (Color.LIGHT_GRAY);
        
       
        
        cityPanel = new JPanel();
        cityPanel.setPreferredSize (new Dimension(300, 100));
        cityPanel.setBackground (Color.LIGHT_GRAY);
        
        edgePanel = new JPanel();
        edgePanel.setPreferredSize (new Dimension(400, 100));
        edgePanel.setBackground (Color.LIGHT_GRAY);
        
        distancePanel = new JPanel();
        distancePanel.setPreferredSize (new Dimension(10,400 ));
        distancePanel.setBackground (Color.LIGHT_GRAY);
        
       

      
        cityToEnter = new JTextField(10);
        cityToEnter.setForeground(Color.black);
        cityToEnter.setToolTipText("Enter a new city name.");
        

        
        xToEnter = new JTextField(5);
        xToEnter.setToolTipText("city's X coordinate in numbers(0-420)");
        xToEnter.setForeground(Color.black);
        //xToEnter.
        
        yToEnter = new JTextField(5);
        yToEnter.setToolTipText("city's Y coordinate in numbers");
        yToEnter.setForeground(Color.black);
        
        
        firstEnter = new JTextField(10);
        firstEnter.setForeground(Color.black);
        firstEnter.setToolTipText("Enter the initial city.(Must be valid)");
        
        lastEnter = new JTextField(10);
        lastEnter.setForeground(Color.black);
        lastEnter.setToolTipText("Enter the terminal city.(Must be valid)");
        
        costEnter = new JTextField(10);
        costEnter.setForeground(Color.black);
        costEnter.setToolTipText("Enter the distance in numbers");
        
        
        addCityButton = new JButton("ADD CITY");
        addCityButton.setBackground(Color.white);
        
        
        
        addEdgeButton = new JButton("ADD EDGE");
        addEdgeButton.setBackground(Color.white);
        addEdgeButton.setToolTipText("creates a direction-free road from the between two cities with a specified distance");
        
        drawGraphButton = new JButton("  DONE  ");
        drawGraphButton.setBackground(Color.red);
        drawGraphButton.setForeground(Color.black);
        
        saveButton = new JButton("SAVE GRAPH");
        saveButton.setBackground(Color.red);
        saveButton.setForeground(Color.black);
        
        label1 = new JLabel(" Enter a city and it's x, y coordinates.");
        label2 = new JLabel("Screen clicking provides coordinates");
        label2.setForeground(Color.red);
        label3 = new JLabel("Enter two valid cities and their edge weight(in numbers)");
        label3.setToolTipText("Connecting an edge from initial city to the terminal one does not connect the terminal city to the initial one");
        
        //This will warn the users in if they enter an invalid data
        
        empty1 = new JLabel("               ");//MUST HAVE 15 CHARACTERS
       
        empty2 = new JLabel("               ");//MUST HAVE 15 CHARACTERS
        
        distanceLabel2 = new JLabel("                              ");//SIZE 30
        
         
        
        
        
        //Adding all the components to the mapPanel
        cityPanel.add(label1);
        cityPanel.add(cityToEnter);
        cityPanel.add(xToEnter);
        cityPanel.add(yToEnter);
        cityPanel.add(addCityButton);
        cityPanel.add(label2);
        

        edgePanel.add(label3);
        edgePanel.add(firstEnter);
        edgePanel.add(lastEnter);
        edgePanel.add(costEnter);
        edgePanel.add(empty1);
        edgePanel.add(addEdgeButton);
        edgePanel.add(drawGraphButton);
        edgePanel.add(saveButton);
        
     
        
        mainPanel.add(distancePanel);
        mainPanel.add(cityPanel);
        mainPanel.add(edgePanel);
        
        
        distanceLabel1 = new JLabel(" To get the shortest distance from one to the other point, enter two valid cities.");
        
        
        initialCity = new JTextField(10);
        initialCity.setForeground(Color.black);
        initialCity.setToolTipText("Enter the city you want to get direction from");
        
        terminalCity = new JTextField(10);
        terminalCity.setForeground(Color.black);
        terminalCity.setToolTipText("Enter the final destination");
        
        distanceButton = new JButton("GET SHORTEST DISTANCE");
        distanceButton.setBackground(Color.white);
        distanceButton.setToolTipText("Make sure that all the cities in the map are CONNECTED");
        
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
        
     
        
        drawGraphButton.addActionListener (new graphListener());
        editButton.addActionListener (new editListener());
        distancePanel.setVisible(false);    
        
    }        
    
           public  class graphListener implements ActionListener
          {

              public void actionPerformed (ActionEvent event)
              {
                         
                         distancePanel.setVisible(true); 
                         cityPanel.setVisible(false); 
                         edgePanel.setVisible(false); 

                }
           }
           
           
          public  class editListener implements ActionListener
          {

              public void actionPerformed (ActionEvent event)
              {
                         
                         distancePanel.setVisible(false); 
                         cityPanel.setVisible(true); 
                         edgePanel.setVisible(true); 

                }
           }
}//end of       
