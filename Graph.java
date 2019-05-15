import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
public class Graph
{
  //addVertex() -> create new graph addVertex
  //addEdge() -> create new edge between two nodes
  public int nodes;
  public int edges;
  public HashMap<Integer,ArrayList<Integer>> adjlist;
  public Graph()
  {
    //nodes=0,edges=0;
    adjlist = new HashMap<>();
  }
  public void addVertex(int val)
  {
    ArrayList<Integer> temp = new ArrayList<>();
    adjlist.put(val,temp);
    nodes++;

  }
  public ArrayList getList(int v)
  {
    return adjlist.get(v);
  }
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
  public void showConnections()
  {
    for(Integer key : adjlist.keySet())
    {
      System.out.println(key+"-->"+adjlist.get(key));
    }
  }
  
  

   boolean visited[] = new boolean[10];
   
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
      
    
    
  
  

	public void bfsTraversal()
	{

  }
  
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
