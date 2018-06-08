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
public class WeightedGraph<V> extends AbstractGraph<V> 
{
    //Priority adjacency lists
    private List<PriorityQueue<WeightedEdge>> queues;
    
    //construct a WeightedGraph from edges and vertices in arrays
    public WeightedGraph(int[][] edges, V[] vertices)
    {
        super(edges, vertices);
        createQueues(edges, vertices.length);
            
    }
    
    //Construct a WeightedGraph from edges and vertices in List
    public WeightedGraph(int[][] edges, int numberOfVertices)
    {
        super(edges, numberOfVertices);
        createQueues(edges, numberOfVertices);
        
    }
    
    // Construct a WeightedGraph from vertices 0, 1, 2 and edge list
    public WeightedGraph (List<WeightedEdge> edges, List<V> vertices)
    {
        super((List)edges, vertices);
        createQueues(edges, vertices.size());
        
    }
    
    //Construct a WeightedGraph from vertices 0, 1, and edge array
    public WeightedGraph(List<WeightedEdge> edges, int numberOfVertices)
    {
        super((List)edges, numberOfVertices);
        createQueues(edges, numberOfVertices);
        
    }
    
    
    //Create priority adjacency lists from edge arrays
    private void createQueues(int[][] edges, int numberOfVertices)
    {
        queues = new ArrayList<PriorityQueue<WeightedEdge>>();
        for(int i = 0; i < numberOfVertices ; i++)
        {
            queues.add(new PriorityQueue<WeightedEdge>()); //create a queue    
        }
        
        for (int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            //insert an edge into the queue
            queues.get(u).offer(new WeightedEdge(u, v, weight));
        }
        
    }//end of createQueues
    
    
    
    //Create priority adjacency lists from edge lists
    private void createQueues(List<WeightedEdge> edges, int numberOfVertices)
    {
        queues = new ArrayList<PriorityQueue<WeightedEdge>>();
        for(int i = 0; i < numberOfVertices; i++)
        {
            queues.add(new PriorityQueue<WeightedEdge>()); //create a queue
        }
        
        for(WeightedEdge edge: edges)
        {
            queues.get(edge.u).offer(edge); //insert an edge into queue
        }
    }//end of createQueues
    
    
    
    
    //Display edges with weights
    public void printWeightedEdges()
    {
        for(int i = 0; i < queues.size(); i++)
        {
            System.out.print("Vertex " + i + ": ");
            for(WeightedEdge edge : queues.get(i))
            {
                System.out.print("(" + edge.u + "," + edge.v+ ", "+ edge.weight
                        + ") ");
            }
            System.out.println();
        }
    }//end of printWeightedEdges
    
   
    
    
    //METHOD getWeight
    //returns the weight of and edge between two vertices
    public int getWeight(int i, int m)
    {
        int result = -1;
        for(int j = 0; j < queues.size(); j++)
        {
            for(WeightedEdge edge : queues.get(j))
            {
               //if there is edge between vertices i and m
               if ((i == edge.u) && (m == edge.v))
                   result = edge.weight;
            }
        }
        return result;
       
    }
    
    
    
    
    //get a minimum spanning tree rooted at vertex 0
    public MST getMinimumSpanningTree()
    {
        return getMinimumSpanningTree(0);
    }   
    
    
    
    //Get a minimum spanning tree rooted at specified vertex
    public MST getMinimumSpanningTree(int startingIndex)
    {
        List<Integer> T = new ArrayList<Integer>();
        //T initially contains the startingVertex;
        T.add(startingIndex);
        
        int numberOfVertices = vertices.size(); //number of vertices
        int[] parent = new int[numberOfVertices];//parent of a vertex
        
        //initially set the parent of all vertices to -1
        for(int i = 0; i < parent.length; i++)
           parent[i] = -1;
        int totalWeight = 0; //total weight of the tree thus far
        
        //Clone the queue, so as to keep the original queue intact
        List<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);
        
        //All vertices are found?
        while(T.size() < numberOfVertices)
        {
            //Search for the vertex with the smalles edge adjacent to
            //a vertex in T
            int v = -1;
            double smallestWeight = Double.MAX_VALUE;
            for(int u : T)
            {
                while(!queues.get(u).isEmpty() && 
                        T.contains(queues.get(u).peek().v))
                {
                    //Remove the edge from queues.get(u) if the adjacent
                    //vertex of u is already in T
                    queues.get(u).remove();
                }
                
                if(queues.get(u).isEmpty())
                {
                    continue; // Consider the next vertex in T
                }
                
                //Current smallest weight on an edge adjacent to u
                WeightedEdge edge = queues.get(u).peek();
                if(edge.weight < smallestWeight)
                {
                    v = edge.v;
                    smallestWeight = edge.weight;
                    //if v is added to tree, u will be its parent
                    parent[v] = u;
                }    
                
            }//end of for
            
            T.add(v); // add a new vertex to the tree
            totalWeight += smallestWeight;
            
        }// End of while
        
        return new MST(startingIndex, parent, T, totalWeight);
    }  //end of getMinimumSpanningTree
    
    
    
    
    
    //Clone an array of queues
    private List<PriorityQueue<WeightedEdge>> deepClone(
            List<PriorityQueue<WeightedEdge>> queues)
    {
        List<PriorityQueue<WeightedEdge>> copiedQueues = 
                new ArrayList<PriorityQueue<WeightedEdge>>();
        
        for(int i = 0; i < queues.size(); i++)
        {
            copiedQueues.add(new PriorityQueue<WeightedEdge>());
            for(WeightedEdge e : queues.get(i))
            {
                  copiedQueues.get(i).add(e);
            }
        }
        return copiedQueues;
    }//end of deepClone    
 
    
    
    
    //MST is an inner class in WeightedGraph
    public class MST extends Tree
    {
        private int totalWeight; // Total weight of all edges in the tree
        
        public MST(int root, int[] parent, List<Integer> searchOrder,
                int totalWeight)
        {
            super(root, parent, searchOrder);
            this.totalWeight = totalWeight;
        }
        
        public int getTotalWeight()
        {
            return totalWeight;
        }
    }// end of MST
    
    
    
    
    //Find single-source shortest paths
    public ShortestPathTree getShortestPath(int sourceIndex)
    {
        //T stores vertices whose path found so far
        List<Integer> T = new ArrayList<Integer>();
        // T initially contains the sourceVertex;
        T.add(sourceIndex);
        
        //vertices defined in AbstractGraph
        int numberOfVertices = vertices.size();
        
        //parent[v] stores the previous vertex of v in the path
        int[] parent = new int[numberOfVertices];
        parent[sourceIndex] = -1;  //parent of source is set to -1
        
        //cots[v] stores the cost of the path from v to source
        int[] costs = new int[numberOfVertices];
        for(int i = 0; i < costs.length; i++)
        {
            costs[i] = Integer.MAX_VALUE; // Initial cost set to infinity
        }
        costs[sourceIndex] = 0;
        
        //Get a copy of queues
        List<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);
        
        //Expand verticesFound
        while(T.size() < numberOfVertices)
        {
            int v = -1;//Vertex to be determined
            int smallestCost = Integer.MAX_VALUE;//set to infinity
            for(int u : T)
            {
                while(!queues.get(u).isEmpty() && 
                        T.contains(queues.get(u).peek().v))
                {
                    queues.get(u).remove(); // remove the vertex in verticesFound
                }
                
                if(queues.get(u).isEmpty())
                {
                    //All vertices adjacent to u are in verticesFound
                    continue;
                }    
                
                WeightedEdge e = queues.get(u).peek();
                if(costs[u] + e.weight < smallestCost)
                {
                    v = e.v;
                    smallestCost = costs[u] + e.weight;
                    // If v is added to tree, u will be its parent
                    parent[v] = u;
                }
            }//end of for
            
            T.add(v); // Add a new vertex to T
            costs[v] = smallestCost;
        }//end of while
        
        //create a ShortestPathTree
        return new ShortestPathTree(sourceIndex, parent, T, costs);
    } //end of getShortestPath
    
    
    
    
    //ShortestPathTree is an inner class in WeightedGraph
    public class ShortestPathTree extends Tree
    {
        private int[] costs; //costs[v] is the cost from v to source
        
        //Construct a path
        public ShortestPathTree(int source, int[] parent, 
                List<Integer> searchOrder, int[] costs)
        {
            super(source, parent, searchOrder);
            this.costs = costs;
        }   
        
        //Return cost for a path from root to vertex v
        public int getCost(int v)
        {
            return costs[v];
        }
        
        //print paths from all vertices to the source
        public void printAllPaths()
        {
            System.out.println("All shortest paths from " + 
                    vertices.get(getRoot()) + " are:");
            for(int i = 0; i < costs.length; i++) 
            {
                printPath(i);//print a path from i to the source
                System.out.println("(cost:" + costs[i] + ")");//Path cost
            }
        }
        
    }// end of ShortestPathTree
    
    public List<PriorityQueue<WeightedEdge>> getWeightedEdges()
    {
       return queues;
    }  
    
         
}// end of the WeightedGraph Class
