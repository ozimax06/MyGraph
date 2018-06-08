/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author ozan
 */
public class View extends javax.swing.JPanel
{
   private WeightedGraph<? extends Displayable> graph;
	
	//Constructor
   public View (WeightedGraph<? extends Displayable> graph)
	{
	  this.graph = graph;
          setPreferredSize (new Dimension(800, 470));
          setBackground (Color.red); 
	}
	
	protected void draw(java.awt.Graphics g)
	{
	  super.paintComponent(g);
	  
	  //Draw Vertices
	  java.util.List<? extends Displayable> vertices = graph.getVertices();
	  
	  for (int i = 0; i < graph.getSize(); i++)
	  {
	    int x = vertices.get(i).getX();
		 int y = vertices.get(i).getY();
		 String name = vertices.get(i).getName();
                 
		 g.setColor(Color.blue);
		 g.fillOval(x - 8, y - 8, 16, 16); //Display a vertex
                 g.setColor(Color.white);
		 g.drawString(name, x - 12, y - 12); //display the name
	  }
	  
	  //Draw edges for pair of vertices
	  for(int i = 0; i < graph.getSize(); i++)
	  {
	    //for each vertex, the algorithm gets its neighbors
	    java.util.List<Integer> neighbors = graph.getNeighbors(i);
		 for(int j = 0; j < neighbors.size(); j++)
		 {
		   // for each neighbor, the vertex creates an adge from its
			//position to the neighbor's position with a line
                     //v represents each neighbor of the vertice v
		   int v = neighbors.get(j);
			int x1 = graph.getVertex(i).getX();
			int y1 = graph.getVertex(i).getY();
			int x2 = graph.getVertex(v).getX();
			int y2 = graph.getVertex(v).getY();
                        
                        int cost = graph.getWeight(i, v);
                        int centerX = (x1+x2)/2;
                        int centerY = (y1+y2)/2;
                        
                      
                        g.setColor(Color.blue);
			g.drawLine(x1, y1, x2, y2);//draw an edge for(i, y)
                        g.setColor(Color.white);
                        g.drawString(""+ cost, centerX, centerY);//draw the edge weight
                        
                       // g.drawRect(directX, directY, 7, 7);
                        
                        
		}
	 }
  }//end of paintComponent
}//end of the class