/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.awt.Color;

/**
 *
 * @author ozan
 */
public class GraphView extends javax.swing.JPanel
{
   private Graph<? extends Displayable> graph;
	
	//Constructor
   public GraphView (Graph<? extends Displayable> graph)
	{
	  this.graph = graph;
	}
	
	public void paintComponent(java.awt.Graphics g)
	{
	  super.paintComponent(g);
	  
	  //Draw Vertices
	  java.util.List<? extends Displayable> vertices = graph.getVertices();
	  
	  for (int i = 0; i < graph.getSize(); i++)
	  {
	    int x = vertices.get(i).getX();
		 int y = vertices.get(i).getY();
		 String name = vertices.get(i).getName();
		 g.fillOval(x - 8, y - 8, 16, 16); //Display a vertex
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
			g.drawLine(x1, y1, x2, y2);//draw an edge for(i, y)
		}
	 }
  }//end of paintComponent
}//end of the class