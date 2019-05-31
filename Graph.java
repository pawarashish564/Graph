import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Graph Data structure in Java 
 * 
 * @version 1.0
 * @since 2019
 */
public class Graph
{
  /**
   * nodes stores total numbers of nodes in graph
   */
  
  public static int nodes;
    /**
     * edges are total number of edges in graph
     */
  public static int edges;

  public HashMap<Integer,ArrayList<Integer>> adjlist;
  /**
   * Initialization of Graph
   * @param n no of nodes in graph
   */
  public Graph(int n)
  {
    adjlist = new HashMap<>();
    for(int i=0;i<n;i++)
    {
      ArrayList<Integer> temp = new ArrayList<>();
      adjlist.put(i,temp);
      nodes++;
    }
  }
  
  /**
   * Get list of all connected nodes of current node v
   * @param v as input node
   * @return list which has all connected node
   */
  public ArrayList<Integer> getList(int v)
  {
    return adjlist.get(v);
  }
  /**
   * set edge bitween node s(Source) and d(Destination)
   * for undirected graph
   * @param s source node
   * @param d destination node
   */

  public  void addEdge(int s,int d)
  {
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
   * return true if there exits an edge between node s(Source) and d(Destination)
   * @param s source node
   * @param d destination node
   * @return return boolean value if there exist an edge between s and d
   */
  public boolean checkEdge(int s,int d)
  {
    return adjlist.get(s).contains(d);
  }

  /**
   * Check node x is in graph or not 
   * @param x node in graph 
   * @return returns true if there exist node x in Graph
   *  
   * */  
  public boolean checkVertex(int x)
  {
    return adjlist.containsKey(x);
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
   if(!checkVertex(v)) return;

   visited[v] = true;
   System.out.print(v+" ");

   ArrayList<Integer> temp = getList(v);
    for (int var : temp) 
    {
      if(!visited[var])
      {
        traverseDFS(var);
      }  
    }  
  
  
  }
      
    
    
  
  /**
   * Traverse Entire graph in BFS 
   * @param v as source vertex
   */
	public void traverseBFS(int v)
	{
    System.out.print("\nBFS >> \n");
    boolean visited[] = new boolean[nodes];
    LinkedList<Integer> q = new LinkedList<>();
    q.add(v);
    visited[v]= true;

    while(!q.isEmpty())
    {
      int s = q.poll();
      System.out.print(s+" ");
    
      ArrayList<Integer> temp = getList(s);
      for (int var : temp)
      {
        if(!visited[var]) 
          {
            visited[var]=true;
            q.add(var);

          }  
      }
    }

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
    Graph g = new Graph(5);
    
    g.addEdge( 0, 1); 
    g.addEdge( 0, 4); 
    g.addEdge( 1, 2); 
    g.addEdge( 1, 3); 
    g.addEdge( 1, 4); 
    g.addEdge( 2, 3); 
    g.addEdge( 3, 4); 
   
    System.out.println(g.adjlist);
    System.out.println("No of Nodes "+ nodes);
    System.out.println("No of Edges "+ edges);
    System.out.println("Edge(2,3) "+g.checkEdge(2, 3));
  
    System.out.println("DFS >>");
    g.traverseDFS(0);
    g.traverseBFS(0);

  }

}
