/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author ozan
 */
public class WeightedEdge extends AbstractGraph.Edge
               implements Comparable<WeightedEdge>
{
    public int weight; //The weight on edge(u, v)
    
    //create a weighted edge on (u, v)
    public WeightedEdge(int u, int v, int weight)
    {
        super(u, v);
        this.weight = weight;
    }
    
    //Compare two edges on weights
    public int compareTo(WeightedEdge edge)
    {
        if(weight > edge.weight)
            return 1;
        else if (weight == edge.weight)
            return 0;
        else
            return -1;
    }
}// end of the class
