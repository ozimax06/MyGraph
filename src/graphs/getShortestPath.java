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


//This class gets intial and terminal vertex form the user and shows them the shortest path.
//It will throw and exception if the vertices are not connected. Since its a directed graph
//having a shosrtest path from vertex i to vertex j does not mean that it has the shortest path vice versa.
// This program gets the values of graph graph2 and vertices with static class City. So you can use this program
// Only with the MapPanel class. however, you can easily modify it for other projects.  Ozan Gazi Onder
public class getShortestPath 
{
   String initialVertex;
   String terminalVertex;
   
 
    java.util.List<String> path;
     
    //The following lists are created to draw the new graph with the shortest path
    //vertices3 and newEdges are the shortest path's edges and vertices
    public static java.util.List<MapPanel.City> vertices3;
    public static java.util.List<WeightedEdge> newEdges;
   // public static WeightedGraph<MapPanel.City> shortGraph;
    public static View shortMap;
    public static WeightedGraph<MapPanel.City> graph3;
    
    
    WeightedGraph<String>.ShortestPathTree tree1;


    //CONSTRUCTOR
    public getShortestPath ()
    {
        vertices3 = new java.util.ArrayList<MapPanel.City>();
        newEdges = new java.util.ArrayList<WeightedEdge>();

    }
    
    
    public void getDistance(String first, String last)
    {
        initialVertex = first;
        terminalVertex = last;
        
        //we use exception handler to make sure that the vertices are connected
        
        try
        {
            
             int begin = MapPanel.graph2.getIndex(initialVertex);
        
             int end = MapPanel.graph2.getIndex(terminalVertex);
            
             tree1 = MapPanel.graph2.getShortestPath(begin);
        
             path = tree1.getPath(end);
             
                     
             for (String s: path)
             {  
                int cityIndex = MapPanel.vertices2.indexOf(s);
            
                MapPanel.City myCity;
                myCity = MapPanel.vertices.get(cityIndex);
                String cityName = myCity.getName();
                int x = myCity.getX();
                int y = myCity.getY();
                vertices3.add(new MapPanel.City(cityName, x, y));
             }
            
        }//end of try
        
        //If there is an error such as vertices are not connectet, 
        //it will display a message
        catch(ArrayIndexOutOfBoundsException e)
        {
        	MapPanel.tools.distanceLabel2.setText("CITIES ARE NOT FULLY CONNECTED");
        } 
        
        //add edges
        for(int i = 0; i < vertices3.size()-1; i++)
        {
           int beginIndex = i;
           int endIndex = i + 1;
           int edgeWeight = MapPanel.graph.getWeight(beginIndex, endIndex);
           
           newEdges.add(new WeightedEdge(beginIndex,endIndex,edgeWeight));
        } 
        
        graph3 = new WeightedGraph<MapPanel.City>(newEdges, vertices3);
        
    }    
    
}//END OF THE CLASS


