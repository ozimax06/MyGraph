/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author ozan
 */
import java.awt.Color;
import java.awt.Dimension;
//draws the graph of the shortest path
public class ShortestView extends javax.swing.JPanel
{
    String initial;
    String terminal;
    int begin;
    int end;
    java.util.List<String> path;
    
    //The following lists are created to draw the new graph with the shortest path
    public static java.util.List<MapPanel.City> vertices3;
    public static java.util.List<WeightedEdge> newEdges;
    public static WeightedGraph<MapPanel.City> shortGraph;
    public static View shortMap;
    
    
    
    public ShortestView()
    {
        
        vertices3 = new java.util.ArrayList<MapPanel.City>();
        newEdges = new java.util.ArrayList<WeightedEdge>();
        
    }        
    
    
    
    public void findPath(String first, String last)
    {
        initial = first;
        terminal = last;
        begin = MapPanel.vertices2.indexOf(first);
        end = MapPanel.vertices2.indexOf(last);
        WeightedGraph<String>.ShortestPathTree tree1 = MapPanel.graph2.getShortestPath(end);
        path = tree1.getPath(begin);
        
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
        
        
        //create the edge
        for(int i = 0; i < vertices3.size(); i++)
        {
           int beginIndex = i;
           int endIndex = i + 1;
           int edgeWeight = MapPanel.graph.getWeight(beginIndex, endIndex);
           
           newEdges.add(new WeightedEdge(beginIndex,endIndex,edgeWeight));
        }  
        shortGraph = new WeightedGraph<MapPanel.City>(newEdges, vertices3);
        
        
        
    }  
    
    /*public void draw(java.awt.Graphics page)
    {
        super.paintComponent(page);
        shortMap = new View(shortGraph);
        page.setColor(Color.red);
        shortMap.draw(page);
        

    }  */  
    
}
