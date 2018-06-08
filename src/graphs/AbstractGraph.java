/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.*;

public abstract class AbstractGraph<V> implements Graph<V>
{
   protected List<V> vertices; //Store vertices
	protected List<List<Integer>> neighbors; // Adjacency lists
	
	//Construct a graph from edges and vertices stored in arrays
	protected AbstractGraph(int[][] edges, V[] vertices)
	{
	  this.vertices = new ArrayList<V>();
	  for(int i = 0; i < vertices.length; i++)
	    this.vertices.add(vertices[i]);
		 
	  createAdjacencyLists(edges, vertices.length);
	}
	
	//Construct a graph from edges for integer and vertices stored in List
	protected AbstractGraph(List<AbstractGraph.Edge> edges, List<V> vertices)
	{  	 
	   this.vertices =  vertices;
		createAdjacencyLists(edges, vertices.size());
	}
	
	//Construct a graph for integer vertices 0, 1, 2 and edge list
	protected AbstractGraph(List<AbstractGraph.Edge> edges, int numberOfVertices)
	{
	   vertices = new ArrayList<V>();
		for(int i = 0; i < numberOfVertices; i++)
		   vertices.add((V)(new Integer(i)));
			
		createAdjacencyLists(edges, numberOfVertices);
	}		
	
	//Construct graph from integer vertices 0, 1, 2 and edge array
	protected AbstractGraph(int[][] edges, int numberOfVertices)
	{
	  vertices = new ArrayList<V>();//create vertices
	  for(int i = 0; i < numberOfVertices; i++)
	  {
	     vertices.add((V)(new Integer(i)));//vertices is{0,1, 2 ...}
	  }
	  createAdjacencyLists(edges, numberOfVertices);
	}
	
	
	
	//Following Methods create ADJACENCY LISTS for each vertex
	private void createAdjacencyLists(int[][] edges, int numberOfVertices)
	{
	  //Create LinkedList
	  neighbors = new ArrayList<List<Integer>>();
	  for(int i = 0; i < numberOfVertices; i++)
	    neighbors.add(new ArrayList<Integer>());
		 
	  for(int i = 0; i < edges.length; i++)
	  {
	    int u = edges[i][0];
		 int v = edges[i][1];
		 neighbors.get(u).add(v);
	  }
	}
	
	private void createAdjacencyLists(List<AbstractGraph.Edge> edges, int numberOfVertices)
	{
	   //Creates a linked list
		neighbors = new ArrayList<List<Integer>>();
		for(int i = 0; i < numberOfVertices; i++)
		   neighbors.add(new ArrayList<Integer>());
		
		for(AbstractGraph.Edge edge: edges)
		   neighbors.get(edge.u).add(edge.v);
	}
	
	
	//return number of vertices in the graph
	public int getSize()
	{
	   return vertices.size();
	}
	
	
	
	public List<V> getVertices()
	{
	   return vertices;
	}			
	
	
	//return object for the specified vertex
	public V getVertex(int index)
	{
	  return vertices.get(index);
	}  	
	
	
	//return index for the specified vertex object
	public int getIndex(V v)
	{
	  return vertices.indexOf(v);
	}  	 	 	 
	
	
	//return neighbors of vertex with specified index
	public List<Integer> getNeighbors(int index)
	{
	  return neighbors.get(index);
	}
	  
	
	public int getDegree(int v)
	{
	  return neighbors.get(v).size();
	}
	
	
	//getAdjacencyMatrix()
	public int[][] getAdjacencyMatrix()
	{
	  int[][] adjacencyMatrix = new int[getSize()][getSize()];
	  
	  for(int i = 0; i < neighbors.size(); i++)
	  {
	    for(int j = 0; j < neighbors.get(i).size(); j++)
		 {
		   int v = neighbors.get(i).get(j);
			adjacencyMatrix[i][v] = 1;
		 }
		 
	  }
	  
	  return adjacencyMatrix;
	}
	
	
	
	//printAdjacencyMatrix()
	public void printAdjacencyMatrix()
	{
	  int[][] adjacencyMatrix = getAdjacencyMatrix();
	  for(int i = 0; i < adjacencyMatrix.length; i++)
	  {
	    for(int j = 0; j < adjacencyMatrix[0].length; j++)
		 {
		    System.out.print(adjacencyMatrix[i][j] + " ");
		 }
		 
		 System.out.println();
	  }
	}  
	
	
	
	
	//printEdges()
	public void printEdges()
	{
	  for(int u = 0; u < neighbors.size(); u++)
	  {
	    System.out.print("Vertex " + u + ": ");
		 for (int j = 0; j < neighbors.get(u).size(); j++)
		 {
		   System.out.print("(" + u + ", " + neighbors.get(u).get(j) + ") ");
		 }
		 System.out.println();
	  }
   }
	
	// Edge Inner Class**************
	public static class Edge
	{
	  public int u;//starting vertex of the edge
	  public int v; // ending vertex of the edge
	  
	  //Constructor
	  public Edge(int u, int v)
	  {
	    this.u = u;
		 this.v = v;
	  }
   }// end of inner class Edge
	
	
	
	
	//Obtain a DFS tree starting from vertex
	public AbstractGraph.Tree dfs(int v)
	{
	  List<Integer> searchOrders = new ArrayList<Integer>();
	  int[] parent = new int[vertices.size()];
	  for(int i = 0; i < parent.length; i++)
	    parent[i] = -1; //Initialize parent[i] to -1
		 
		 //Mark Visited Vertices
		 boolean[] isVisited = new boolean [vertices.size()];
		 
		 //Recursively search
		 dfs(v, parent, searchOrders, isVisited);
		 
		 //Return a serach tree
		 return new AbstractGraph.Tree(v, parent, searchOrders);
	}//end of dfs
	
	
	//**Recusrsive Method for DFS Search
	private void dfs(int v, int[] parent, List<Integer> searchOrders, boolean[] isVisited)
	{	 	  	 	  	 	 
	  //Store the visited vertex
	  searchOrders.add(v);
	  isVisited[v]= true; //vertex v is visited
     
	  for(int i : neighbors.get(v))
	  {
	    if(!isVisited[i])
		 {
		    parent[i] = v; // parent of vertex i is v
			 dfs(i, parent, searchOrders, isVisited);//recursive serach
		 }
	  }
	}//end of recursive method  
	
	
	
	
	//Starting bfs search from vertex v
	public AbstractGraph.Tree bfs(int v)
	{
	  List<Integer> searchOrders = new ArrayList<Integer>();
	  int[] parent = new int[vertices.size()];
	  for(int i = 0; i < parent.length; i++)
	    parent[i] = -1;//initialize parent[i] to -1
	  
	  //list used as a queue	 
	  java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();	
	  
	  boolean [] isVisited = new boolean[vertices.size()];
	  queue.offer(v); //Enqueue v
	  isVisited[v] = true; //Mark it as visited
	  
	  while(!queue.isEmpty())
	  {
	    int u = queue.poll();// Dequeue to u
		 searchOrders.add(u); // u searched
		 
		 for(int w : neighbors.get(u))
		 {
		   if(!isVisited[w])
			{
			  queue.offer(w); // Enqueue w
			  parent[w] = u;// the parent of w is u
			  isVisited[w] = true; // Mark it visited
			}
	    }
	  }//end of while
	  
	  return new AbstractGraph.Tree(v, parent, searchOrders);
	}//end of dfs
	
	
	
	
	
	
	//***************************
	//Tree inner class***********
	public class Tree
	{
	  private int root;//root of tree
	  private int[] parent;//Store the parent of each vertex
	  private List<Integer> searchOrders;// store the search order
	  
	  
	  //Construct a tree with root, parent, and searchOrder
	  public Tree(int root, int[] parent, List<Integer> searchOrders)
	  {
	    this.root = root;
		 this.parent = parent;
		 this.searchOrders = searchOrders;
	  }
	  
	  //Construct tree with root and parent without a particular order
	  public Tree(int root, int[] parent)
	  {
	    this.root = root;
		 this.parent = parent;
	  }	 	 
	  
	  
	  public int getRoot()
	  {
	    return root;
	  }
	  
	  
	  // return parent of vertex v
	  public int getParent(int v)
	  {
	    return parent[v];
	  }	 	 
	    
	  //return an array representing search order
	  public List<Integer> getSearchOrders()
	  {
	    return searchOrders;
	  }	 
	  
	  public int getNumberOfVerticesFound()
	  {
	    return searchOrders.size();
	  }
	  
	  
	  //Return path of vertices from a vertex index to the root
	  public List<V> getPath(int index)
	  {  
	    ArrayList<V> path = new ArrayList<V>();
		 
		 do{
		   path.add(vertices.get(index));
			index = parent[index];
		}while(index != -1);
		
		return path;
	  }// end of getPath			 
	  
	  
	  //printPath
	  public void printPath(int index)
	  {
	    List<V> path = getPath(index);
		 System.out.println(" A path from " + vertices.get(root) + " to " +
		   vertices.get(index) + ": ");
		 
		 for(int i = path.size() - 1; i >= 0; i--	)
		   System.out.print(path.get(i) + " ");
	  }	
	  
	  
	  //Print the whole tree
	  public void printTree()
	  {
	    System.out.println("Root is: " + vertices.get(root));
		 System.out.print("Edges: ");
		 
		 for(int i = 0; i < parent.length; i++)
		 {
		   if(parent[i] != -1)
			{
			 //display an edge
			 System.out.print("(" + vertices.get(parent[i]) + ", " + vertices.get(i) + ") ");
			}
		 }
		 System.out.println();
	  }
	}//END OF TREE
}//end  of the class	
