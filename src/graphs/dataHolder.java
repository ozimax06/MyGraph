
package graphs;

/**
 *
 * @author ozan
 */

import java.io.*;

//This program adds graphNames and their coordinates as string and int values to a binary
//file called graphCities.(Because the static class has a string value and two int values.
//Also it saves the edges (as 3 integers for each edge) to a binray file called graphEdges.
//If the file does not exist, then it creates one.

//Also it opens those two files and load the graph's cities and edges to the mapPanel

//in clear method, it removes everything from the binary file
public class dataHolder 
{
    DataOutputStream output;//for saving cities
    
    DataOutputStream output2;//for saving edges
    
    DataInputStream input;//for loading cities
    DataInputStream input2;//for loading edges
    
    //saving/loading cities
    String city;
    int x;
    int y;
    
    //saving/loading edges
    int cityA, cityB;
    int cost;
    
   //Constructor 
   public dataHolder()
   {
   }
   
  public void saveFile()
   {
        //SAVE CITIES FIRST to graphCities file
        try
       {
           output =new DataOutputStream(new FileOutputStream("graphCities.dat"));
           for(int i = 0; i < MapPanel.vertices.size() ;i++ )
           {
               MapPanel.City myCity = MapPanel.vertices.get(i);
               city = myCity.getName();
               x = myCity.getX();
               y = myCity.getY();
               
               //now write the data to the outer file
              output.writeUTF(city);
              output.writeInt(x);
              output.writeInt(y);
           }  
           output.close();
       }
       catch(IOException e)
       {
           graphTools.label2.setText("                     FAIL1                 ");
       }  
        
        
       //SAVE EDGES to graphEdges file
       try
       {
           output2 =new DataOutputStream(new FileOutputStream("graphEdges.dat"));
           for(int i = 0; i < MapPanel.edges.size()  ;i++ )
           {
               cityA = MapPanel.edges.get(i).u;
               cityB = MapPanel.edges.get(i).v;
               cost = MapPanel.edges.get(i).weight;
               
                
               
               output2.writeInt(cityA);
               output2.writeInt(cityB);
               output2.writeInt(cost);
           }  
           output2.close();
       }
       catch(IOException e)
       {
           graphTools.label2.setText("                     FAIL2                 ");
       }  
        
       
   }//end of saveFile()
  
  
  //the following method loads the cities and vertices to mapPanel
  public void loadFile()
  {
      //load the vertices first
       try
       {
          input = new DataInputStream(new FileInputStream("graphCities.dat"));
          while (true)
          {
                  city = input.readUTF();
		  x = input.readInt();
                  y = input.readInt();
		  MapPanel.vertices.add(new MapPanel.City(city, x, y));
                  MapPanel.vertices2.add(city);
          }
       } 
       
       catch(IOException e)
       {	     
          graphTools.emptyIntro1.setText("                FAIL1                                        ");
       }
       
       
       //LOAD the edges
        try
       {
          input2 = new DataInputStream(new FileInputStream("graphEdges.dat"));
          while (true)
          {
                  cityA = input2.readInt();
		  cityB = input2.readInt();
                  cost = input2.readInt();
		  MapPanel.edges.add(new WeightedEdge(cityA, cityB, cost));
                  MapPanel.edges.add(new WeightedEdge(cityB, cityA, cost));
          }
       } 
       
       catch(IOException e)
       {	     
          graphTools.emptyIntro1.setText("                FAIL2                                        ");
       }
       
      
      
      
      
  }//end of loadFile        
  
   
    
    
}
