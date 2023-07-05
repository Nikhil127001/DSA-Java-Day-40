package mypackage;
import java.util.ArrayList;
import java.util.*;
// implementation of kruskal's algorithm 

// we are implementing it using disjoint set theory

public class practice {
  // edge

  // implementing comparable interface
  public static int n = 4;
  public static int pare[] = new int[n];
  public static int rank[] = new int[n];

  public static class Edge implements Comparable<Edge> {
    int st;
    int dest;
    int wt;

    public Edge(int st, int dest, int wt) {
      this.st = st;
      this.dest = dest;
      this.wt = wt;
    }

    @Override

    public int compareTo(Edge e) {
      return this.wt - e.wt;
    }
  }
  static void CreateGraph(ArrayList<Edge> graph){
    graph.add(new Edge(0,1,10));
    graph.add(new Edge(0,2,15));
    graph.add(new Edge(0,3,30));
    graph.add(new Edge(1,3,40));
    graph.add(new Edge(2,3,50));
  }

  public static void init() {
    for (int i = 0; i < n; i++) {
      pare[i] = i;
    }
  }

  // implementing disjoint set functions , find and union
  public static int find(int x) {
    if (x == pare[x]) {
      return x;
    }
    return find(pare[x]);
  }

  // implement union method

  public static void union(int a, int b) {
    int pareA = pare[a];
    int pareB = pare[b];

    if (rank[pareA] == rank[pareB]) {
      pare[pareB] = pareA;
      rank[pareA]++;
    } else if (rank[pareA] > rank[pareB]) {
      pare[pareB] = pareA;
    } else {
      pare[pareA] = pareB;
    }
  }

  public static int kruskalsAlgo(ArrayList<Edge> edges , int V){
    init();
    int MinCost = 0;
    int count  = 0;
    
    // first sort the Arraylist of edges according to their weight of edges
    Collections.sort(edges);

    for(int i = 0 ; count<V-1; i++){
      Edge e = edges.get(i);
      int parA = find(e.st);
      int parB = find(e.dest);

      if(parA != parB){
        MinCost += e.wt;
        union(e.st, e.dest);
        count++;
      }
    }
    return MinCost;
  }

  public static void main(String[] args) {
    // creating adjecency list
    ArrayList<Edge> graph = new ArrayList<>();
    CreateGraph(graph);
    int V  = 4; // number of edges
    System.out.println( kruskalsAlgo(graph,V));
  }
}