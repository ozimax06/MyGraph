/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author ozan
 */
import java.util.*;

//by using super, this class imports the implementations of the
//constructors of the class abstractGraph with appropritae parameters

public class UnweightedGraph<V> extends AbstractGraph<V>
{
  //Construct a graph from edges and vertices stored in arrays
  public UnweightedGraph(int[][] edges, V[] vertices)
  {
    super(edges, vertices);
  }
  
  //Construct graph from edges and vertices stored on List
  public UnweightedGraph(List<Edge> edges, List<V> vertices)
  {
     super(edges, vertices);
  }
  
  //Construct a graph for integer vertices 0, 1, 2 and edge list
  public UnweightedGraph(List<Edge> edges, int numberOfVertices)
  {
     super(edges, numberOfVertices);
  }
  
  //Construct a graph from integer vertices 0, 1, and edge array
  public UnweightedGraph(int[][] edges, int numberOfVertices)
  {
     super(edges, numberOfVertices);
  }
}  	