import java.util.*;
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
  public void dfsRecursive(int s)
  { //dfs recursive method
    // not fixed
    boolean visited[]=new boolean[nodes];
    visited[s]=true;
    System.out.print(s+" ");
    for(int a:adjlist.get(s))
      {
        if(!visited[a]) dfs_recursive(a);
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
    g.addVertex(0);
    g.addVertex(1);
    g.addVertex(2);
    g.addVertex(3);
    g.addVertex(4);
    g.addVertex(5);
    g.addVertex(6);

    System.out.println(g.adjlist);

    g.addEdge(3,1);
    g.addEdge(3,4);
    g.addEdge(4,2);
    g.addEdge(4,5);
    g.addEdge(1,2);
    g.addEdge(1,0);
    g.addEdge(0,2);
    g.addEdge(6,5);

    System.out.println(g.adjlist);
    System.out.println();
    g.showConnections();
    System.out.println();
//    g.dfs_recursive(0);
  }

}
