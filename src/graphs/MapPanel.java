/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//FOR UNDIRECTED GRAPHS
package graphs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author ozan
 */
public class MapPanel extends JPanel
{
    public static java.util.List<City> vertices = new java.util.ArrayList<City>();
    public static java.util.List<String> vertices2 = new java.util.ArrayList<String>();
    public static java.util.List<WeightedEdge> edges = new java.util.ArrayList<WeightedEdge>();
    public static WeightedGraph<City> graph;
    public static WeightedGraph<String> graph2;
   
    
    public ShortView myView;
    public getShortestPath myPath;
    public static View map;
    public static graphTools tools;
    public static graphTools2 tools2;
    mapBackgorund background;
    
    int condition;
    
    private Point point, point2 = null;
    
    String verticeString;
    
    boolean intro;
    
    dataHolder graphData;
    
    


        
      
    
    public MapPanel()
    {    
           intro = true;
           graphData = new dataHolder();
           
           
           setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
           add (Box.createRigidArea (new Dimension (0,450 )));
           tools = new graphTools();
           
           //add(tools.Panel);
           
           tools.addCityButton.addActionListener (new cityListener());
           tools.addEdgeButton.addActionListener (new edgeListener());
           tools.distanceButton.addActionListener (new distanceListener());
           tools.returnButton.addActionListener (new returnListener());
           tools.newButton.addActionListener (new newListener());
           tools.loadButton.addActionListener (new loadListener());
           tools.saveButton.addActionListener (new saveListener());
           
           condition = 0;

           
      //LISTENER FOR THE MOUSE EVENTS     
      PointListener listener = new PointListener();
		
      addMouseListener (listener);
      addMouseMotionListener (listener);
           



	add(tools.distancePanel);
        add(tools.mainPanel); 
        add(tools.IntroPanel);
        tools.mainPanel.setVisible(false);

        


    
      
    setPreferredSize (new Dimension(820, 550));
    setBackground (Color.black); 
    }
    
    
    
    //*********************
    //GRAPHICS PAGE
    public void paintComponent (Graphics page)
    {   
        super.paintComponent(page);
        
     if(!intro)
     {    
         
        if (point != null && point.x < 820 && point.y < 450)
        {    
                    page.setColor(Color.blue);
	            page.drawOval(point.x, point.y, 15, 15);
                    
        } 
		  
	if (point2 != null && point2.x < 820 && point2.y < 450)
        {
        page.setColor(Color.green);    
        page.drawString("X: " + point2.x + "     Y: " + point2.y, point2.x + 20, point2.y + 10);
        }
        
        if (condition == 2)
        {
           
           page.setColor(Color.blue);
           
           map.draw(page);
          
        } 
        
        if (condition == 1)
        {
           page.setColor(Color.blue);
           
           map.draw(page); 
           myView.draw(page);
            
            
            //tools.distancePanel.
            //page.setColor(Color.blue);
           //remove(graphTools.cityPanel);
           //add(graphTools.distancePanel);
           
           //myView.draw(page);
            
        } 
     }//end of if !intro
      
    }
    
    static class City implements Displayable
    {
          private int x, y;
	  private String name;
			
		City(String name, int x, int y)
		{
			  this.name = name;
			  this.x = x;
			  this.y = y;
		}
			
		public int getX()
		{ 
			   return x;
		}
			
		public int getY()	  
	        {
			   return y;
		}
			
		public String getName()
		{
		   return name;
	        }
	 }// end of City
    
    
    //LISTENERS
    //This listen's the citys name and its coordinates
    //after a validation process
    private class cityListener implements ActionListener
    {
             int x;
             int y;
          public void actionPerformed (ActionEvent event)
          {
             String city = tools.cityToEnter.getText();

             
             //use exception handler to make sure that user enters integer
             //to the textboxes
          try
          {
               int xPosition = Integer.parseInt(tools.xToEnter.getText());
               int yPosition = Integer.parseInt(tools.yToEnter.getText());
               x = xPosition;
               y = yPosition;
          

             
             
             
             //IF The city contains the name already it wont except the data
             if(vertices2.contains(city))
             {
                 tools.label2.setText("                 This city is already exist        ");
             }
             else
             {
               vertices.add(new City(city,x,y ));
               vertices2.add(city);
                graph = new WeightedGraph<City>(edges, vertices);
                graph2 = new WeightedGraph<String>(edges, vertices2);
                map = new View(graph);
                condition = 2;
                
                //The following program makes the empty blue circle disappear after
                //user adds a new city.
                point = null;
                tools.label2.setText("Screen clicking provides coordinates");
                repaint();
             }//end of else  
         }//end of try 
             
         catch(Exception e)
         {
                 tools.label2.setText("                     Enter a number!!                 ");
         } 
               
               
      }   

     }//end of city listener
    
    
          private class edgeListener implements ActionListener
          {
              String vertexA;
              String vertexB;
              int cost;
              public void actionPerformed (ActionEvent event)
              {
                  
                 try
                 {
                    vertexA = tools.firstEnter.getText();
                    vertexB = tools.lastEnter.getText();
                    cost = Integer.parseInt(tools.costEnter.getText());
                    
                 }
                 
                 catch(Exception e)
                 {
                    tools.empty3.setText("                             Invalid data types!!!!!");
                 }  
                 
                 if(!vertices2.contains(vertexA) || !vertices2.contains(vertexB))
                 {
                     tools.empty3.setText("                             Enter valid cities!!");
                 }  
                 else
                 {
                     int initial = vertices2.indexOf(vertexA);
                     int terminal = vertices2.indexOf(vertexB);
                     
                     edges.add(new WeightedEdge(initial,terminal,cost));
                     //WE CREATE THE SAME EDGE FROM TERMINAL TO INITIAL
                     //POINT BECAUSE THIS IS AN UNDIRECTED GRAPH
                     edges.add(new WeightedEdge(terminal,initial,cost));
                     
                     graph = new WeightedGraph<City>(edges, vertices);
                     graph2 = new WeightedGraph<String>(edges, vertices2);
                     map = new View(graph);
                     condition = 2;
                     //remove(tools.mainPanel);
                     repaint();
                     
                     
                     
                 }    
                  
              }
          }//end of edgeListener
          
          
          private class distanceListener implements ActionListener
          {

              public void actionPerformed (ActionEvent event)
              {
                  String first = tools.initialCity.getText();
                  String last = tools.terminalCity.getText();
                  if(first.isEmpty() || last.isEmpty())
                      tools.distanceLabel2.setText("      ENTER VALID CITIES      ");
                  
                  
                  myPath = new getShortestPath();
                  myPath.getDistance(first, last);
                  map = new View(graph);
                  myView = new ShortView(getShortestPath.graph3);
                  condition = 1;
                  repaint();
                  
                  
                
  
                  
              }
          }
          
          
          
          //happens when the user clicks the remove the distance path button
          //it draws the original version of the graph
          private class returnListener implements ActionListener
          {

              public void actionPerformed (ActionEvent event)
              {
                  condition = 2;
                  repaint();
    
              }
          }
          
          
          
          private class newListener implements ActionListener
          {

              public void actionPerformed (ActionEvent event)
              {
                  intro = false;
                  tools.mainPanel.setVisible(true);
                  tools.IntroPanel.setVisible(false);
                  repaint();
    
              }
          }
          
          
          private class loadListener implements ActionListener
          {

              public void actionPerformed (ActionEvent event)
              {
                  intro = false;
                  tools.mainPanel.setVisible(true);
                  tools.IntroPanel.setVisible(false);
                  graphData.loadFile();
                  graph = new WeightedGraph<City>(edges, vertices);
                  graph2 = new WeightedGraph<String>(edges, vertices2);
                  map = new View(graph);
                  condition = 2;
                  repaint();
    
              }
          }
          
          
         private class saveListener implements ActionListener
          {

              public void actionPerformed (ActionEvent event)
              {
                  
                  graphData.saveFile();
    
              }
          }
          
          
          
          
          
          
 private class PointListener implements MouseListener, MouseMotionListener
 {
          //--------------------------------------------------------------
          //  Captures the initial position at which the mouse button is
          //  pressed.
          //--------------------------------------------------------------

                 
      public void mousePressed (MouseEvent event)
      {
         point = event.getPoint();
         tools.xToEnter.setText(""+point.x);
         tools.yToEnter.setText(""+point.y);
	 repaint();
	 	
      }
		
     public void mouseReleased (MouseEvent event)
      {
          point2 = null;
      }	 
      
      public void mouseMoved (MouseEvent event)
      {  
          //tools.cityToEnter.setVisible(true);
          point2 = event.getPoint();
          //xLocation = point2.x;
          //yLocation = point2.y;
          
          
          
          
          repaint(); 
          
      }

      
      //--------------------------------------------------------------
      //  Provide empty definitions for unused event methods.
      //--------------------------------------------------------------
      public void mouseClicked (MouseEvent event) {}
      public void mouseEntered (MouseEvent event) {}
      public void mouseExited (MouseEvent event) {}
      public void mouseDragged (MouseEvent event) {}
                 
 }//end of PointListener
 
          
    }//end of class