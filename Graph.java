import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Graph Data structure in Java 
 * @version 1.0
 * @since 2019
 */



public class Graph
{
  //addVertex() -> create new graph addVertex
  //addEdge() -> create new edge between two nodes
  /**
   * nodes stores total numbers of nodes in graph
   */
  
  public int nodes;
    /**
     * edges are total number of edges in graph
     */
  public int edges;

  public HashMap<Integer,ArrayList<Integer>> adjlist;
  /**
   * Initialization of Graph
   */
  
  public Graph()
  {
    //nodes=0,edges=0;
    adjlist = new HashMap<>();
  }
  /**
   *adding vertex to graph
   * @param val value for node 
   */
  
  public void addVertex(int val)
  {
    ArrayList<Integer> temp = new ArrayList<>();
    adjlist.put(val,temp);
    nodes++;

  }

  /**
   * Get list of all connected nodes of current node v
   * @param v as input node
   * @return list which has all connected node
   */
  public ArrayList getList(int v)
  {
    return adjlist.get(v);
  }
  /**
   * set edge bitween node s(Source) and d(Destination)
   * @param s source node
   * @param d destination node
   */

  public void addEdge(int s,int d)
  {
    //undirected graph
    //getting the arraylist
    ArrayList<Integer> temp = adjlist.get(s);
    temp.add(d); //add the dest node
    adjlist.put(s,temp); //put updated arraylist inside HashMap

    //same for the destination node
    temp =adjlist.get(d);
    temp.add(s);
    adjlist.put(d,temp);
    edges++;
  }
  /**
   * returns entire adjecency list of graph
   * 
   */


  public void showConnections()
  {
    for(Integer key : adjlist.keySet())
    {
      System.out.println(key+"-->"+adjlist.get(key));
    }
  }
  
  

  boolean visited[] = new boolean[10];
  /**
   * Traverse graph in DFS in recursive fashion
   * @param v as source vertex
   */ 
  public void traverseDFS(int v)
  { 
   // Stack<Integer> st = new Stack<>();
    ArrayList<Integer> temp = getList(v);
    System.out.print(v+" ");
    visited[v] = true;
    for (int var : temp) 
    {
      if(visited[var] != true )
      {
        traverseDFS(var);
      }  
    }  
  
  
  }
      
    
    
  
  /**
   * Traverse Entire graph in BFS 
   * @param v as source vertex
   */
	public void bfsTraversal(int v)
	{

  }
  /**
   * Return shortest path between node1 and node2
   * using Dijktra algorithm with complexity O(n^2)
   * @param node1 starting node
   * @param node2 ending node
   */
	public void shortedPath(int node1,int node2)
	{

	}

  public static void main(String[] args) {
    Graph g = new Graph();
    //g.addVertex(0);
    g.addVertex(1);
    g.addVertex(2);
    g.addVertex(3);
    g.addVertex(4);
    g.addVertex(5);
    g.addVertex(6);

    //System.out.println(g.adjlist);

   // /g.addEdge(3,1);
   // g.addEdge(3,4);
   // g.addEdge(4,2);
    //g.addEdge(4,5);
    g.addEdge(1,2);
    g.addEdge(1, 3);
    g.addEdge(2,4);
    g.addEdge(2,5);
    g.addEdge(3,5);
    g.addEdge(4,5);
    g.addEdge(4,6);
    g.addEdge(5,6);

    // g.addEdge(1,0);
   // g.addEdge(0,2);
   
    System.out.println(g.adjlist);
   // System.out.println();
  //  g.showConnections();
    System.out.println();
    g.traverseDFS(1);
    
  }

}
