package mypackage;

import java.util.*;

public class GraphsE {

    // implementing Comparable interface to compare fields of PQ according to the
    // value of cost in it.
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    public static int ConnectingCities(int cities[][]) {
        int finalCost = 0;
        // creating a prioprity Queue
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // creating array to find if the dest is visited or not
        boolean visited[] = new boolean[cities.length];

        // first inserting first edge in the priority Queue with dest 0 and cost 0
        pq.add(new Edge(0, 0));

        // find the neighbours of the curr elem and add it in the pq

        while (!pq.isEmpty()) {
            // find curr
            Edge curr = pq.remove();
            if (!visited[curr.dest]) {
                // change the visited of the curr elem to true and find if the neighbours are
                // visited or not
                visited[curr.dest] = true;
                // and add its cost to the final cost
                finalCost += curr.cost;

                // now check for its neighbours

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        // add neighbours and its cost to the pq
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    // ****** IMP */ Disjoint Sets Implementation

    static int n = 7;
    // creating leader array to track leader for a given number in a set
    static int[] leader = new int[n];
    // creating rank for each number
    static int[] rank = new int[n];

    public static void init() {
        // insert initial data in the rank and leader array
        for (int i = 0; i < n; i++) {
            leader[i] = i;
        }
    }

    // creating function to find leader of a number
    public static int find(int x) {

        if (x == leader[x]) {
            return x;
        }
        return find(leader[x]);
    }

    // creating a function to join two numbers in two different sets
    public static void union(int a, int b) {
        // first find the parent or leader of the two given numbers
        int parA = leader[a];
        int parB = leader[b];

        // case 1 - if the both numbers parent have equal rank
        if (rank[parA] == rank[parB]) {
            // change the parent of B to parent of A
            leader[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            // case2 if the rank of leader of number a is greater then the rank of leader
            // number b -- > then change the leader of b to leader of a
            leader[parB] = parA;
        } else {
            // case2 if the rank of leader of number b is greater then the rank of leader
            // number a -- > then change the leader of a to leader of b
            leader[parA] = parB;
        }
    }

    public static void main(String args[]) {
        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 }, { 4, 7, 0, 0, 0 }
        };

        System.out.println(ConnectingCities(cities));

        // ** IMP */ Disjoint Sets Implementation
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}

// package mypackage;
// import java.util.ArrayList;
// import java.util.*;
// // implementation of kruskal's algorithm 

// // we are implementing it using disjoint set theory

// public class practice {
//   // edge

//   // implementing comparable interface
//   public static int n = 4;
//   public static int pare[] = new int[n];
//   public static int rank[] = new int[n];

//   public static class Edge implements Comparable<Edge> {
//     int st;
//     int dest;
//     int wt;

//     public Edge(int st, int dest, int wt) {
//       this.st = st;
//       this.dest = dest;
//       this.wt = wt;
//     }

//     @Override

//     public int compareTo(Edge e) {
//       return this.wt - e.wt;
//     }
//   }
//   static void CreateGraph(ArrayList<Edge> graph){
//     graph.add(new Edge(0,1,10));
//     graph.add(new Edge(0,2,15));
//     graph.add(new Edge(0,3,30));
//     graph.add(new Edge(1,3,40));
//     graph.add(new Edge(2,3,50));
//   }

//   public static void init() {
//     for (int i = 0; i < n; i++) {
//       pare[i] = i;
//     }
//   }

//   // implementing disjoint set functions , find and union
//   public static int find(int x) {
//     if (x == pare[x]) {
//       return x;
//     }
//     return find(pare[x]);
//   }

//   // implement union method

//   public static void union(int a, int b) {
//     int pareA = pare[a];
//     int pareB = pare[b];

//     if (rank[pareA] == rank[pareB]) {
//       pare[pareB] = pareA;
//       rank[pareA]++;
//     } else if (rank[pareA] > rank[pareB]) {
//       pare[pareB] = pareA;
//     } else {
//       pare[pareA] = pareB;
//     }
//   }

//   public static int kruskalsAlgo(ArrayList<Edge> edges , int V){
//     init();
//     int MinCost = 0;
//     int count  = 0;
    
//     // first sort the Arraylist of edges according to their weight of edges
//     Collections.sort(edges);

//     for(int i = 0 ; count<V-1; i++){
//       Edge e = edges.get(i);
//       int parA = find(e.st);
//       int parB = find(e.dest);

//       if(parA != parB){
//         MinCost += e.wt;
//         union(e.st, e.dest);
//         count++;
//       }
//     }
//     return MinCost;
//   }

//   public static void main(String[] args) {
//     // creating adjecency list
//     ArrayList<Edge> graph = new ArrayList<>();
//     CreateGraph(graph);
//     int V  = 4; // number of edges
//     System.out.println( kruskalsAlgo(graph,V));
//   }
// }
