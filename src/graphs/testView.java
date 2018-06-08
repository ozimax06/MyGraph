/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author ozan
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.lang.*;

public class testView extends javax.swing.JPanel
{

    int begin;
    int end;
    
    
    public static java.util.List<City> vertices;
    public static java.util.List<String> vertices2;
    public static java.util.List<WeightedEdge> edges = new java.util.ArrayList<WeightedEdge>();
    
    java.util.List<String> path;
    City myCity;
    
    
    
    
    
    //The following lists are created to draw the new graph with the shortest path
    public static java.util.List<City> vertices3;
    public static java.util.List<WeightedEdge> newEdges;
    public static WeightedGraph<City> shortGraph;
    public static View shortMap;
    
    public static WeightedGraph<City> graph;
    public static WeightedGraph<String> graph2;
    
    WeightedGraph<String>.ShortestPathTree tree1;
    
    
    
    
    public testView()
    {    
	    try{
         setPreferredSize (new Dimension(820, 550));
         setBackground (Color.black); 
        
        
        vertices = new java.util.ArrayList<City>();
        vertices2 = new java.util.ArrayList<String>();
        edges = new java.util.ArrayList<WeightedEdge>();
        
        vertices.add(new City("ank", 12, 100));
	  vertices.add(new City("ist", 300, 150));
	 vertices.add(new City("bod", 120, 340));
        vertices.add(new City("izmir", 400, 75));
        vertices.add(new City("antalya", 350, 300));
        
           vertices2.add("ank");
           vertices2.add("ist");
           vertices2.add("bod");
           vertices2.add("izmir");
           vertices2.add("antalya");
           
           
        edges.add(new WeightedEdge(0,4,23));
        edges.add(new WeightedEdge(1,4,235));
        edges.add(new WeightedEdge(1,3,44));
        edges.add(new WeightedEdge(0,3, 889));
        edges.add(new WeightedEdge(4,0,3));
        edges.add(new WeightedEdge(2,4,100));
        edges.add(new WeightedEdge(1, 4,900));
        edges.add(new WeightedEdge(4,2,24));
       // edges.add(new WeightedEdge(4,1,23));
        
        
           
           graph = new WeightedGraph<City>(edges, vertices);
           graph2 = new WeightedGraph<String>(edges, vertices2);
	  
         
        
        
        vertices3 = new java.util.ArrayList<City>();
        newEdges = new java.util.ArrayList<WeightedEdge>(); 
		  
		  }
	 catch(ArrayIndexOutOfBoundsException e)
     {
	System.out.print("error");
     } 


        

        
      //if begin and end were exchanged, then it throws and exception
       try
       {
        begin= graph2.getIndex("ank");
        
        end = graph2.getIndex("ist");
            
         tree1 = graph2.getShortestPath(end);
        
        path = tree1.getPath(begin);
       
   
       
        
        
        
        for (String s: path)
        {  
            int cityIndex;
               cityIndex = vertices2.indexOf(s);
            
           
           myCity = vertices.get(cityIndex);
           String cityName = myCity.getName();
           int x = myCity.getX();
           int y = myCity.getY();
           vertices3.add(new City(cityName, x, y));
        }
        
        
      }//end of try   
        
    
     catch(ArrayIndexOutOfBoundsException e)
     {
	System.out.print("error");
     } 
        

   
        
        for(int i = 0; i < vertices3.size() - 1; i++)
        {
           
           int beginIndex = i;
           int endIndex = i + 1;
           int edgeWeight = graph.getWeight(beginIndex, endIndex);
           
           newEdges.add(new WeightedEdge(beginIndex,endIndex,edgeWeight));
        }  
        shortGraph = new WeightedGraph<City>(newEdges, vertices3);
        
		 
		  

        
        
        
        

    }  //end of the constructor
    
    

    
    
    public void paintComponent(java.awt.Graphics page)
    {
       
        
        
        super.paintComponent(page);
        shortMap = new View(shortGraph);
        //page.setColor(Color.white);
        shortMap.draw(page);
        
        


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
}//end of the class    