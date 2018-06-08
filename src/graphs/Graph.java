/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author ozan
 */
public interface Graph<V>
{
   public int getSize();
	
	public java.util.List<V> getVertices();
	//return the vertices in the graph
	
	public V getVertex(int index);
	//returns the object for the specified vertex index
	
	public int getIndex(V v);
	//return index for the specified vertex object
	
	public java.util.List<Integer> getNeighbors(int index);
	//returns the neighbors of vertex with the specified index
	
	public int getDegree(int v);
	
	public int[][] getAdjacencyMatrix();
	
	public void printAdjacencyMatrix();
	
	public void printEdges();
	
	public AbstractGraph<V>.Tree dfs(int v);
	//Obtain a depth first search tree
	
	public AbstractGraph<V>.Tree bfs(int v);
	//Obtain a brea
}        