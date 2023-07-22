import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphsD {
    static class Edge {

        int start;
        int Dest;
        int Wt;

        public Edge(int start, int Dest, int Weight) {
            this.start = start;
            this.Dest = Dest;
            this.Wt = Weight;
        }
    }

    public static void BellmanFordshortestPath(ArrayList<Edge> graph[], int start, int size) {

        int sd[] = new int[size];

        // initialising all shortest distances with infinity
        Arrays.fill(sd, Integer.MAX_VALUE);
        sd[0] = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < graph.length; j++) {             
                    for(int k = 0 ; k<graph[j].size(); k++){
                        // finding edge
                        Edge e = graph[j].get(k);
                        int u = e.start;
                        int v = e.Dest;
                        int weight = e.Wt;
                        if(sd[u]+ weight < sd[v]){
                            sd[v] = sd[u]+ weight; 
                        }
                    }
                   }
                }
                for(int i = 0 ; i<sd.length; i++){
                    System.out.print(sd[i]);
                }
            }
            

        static class Pair implements Comparable<Pair>{
            int data;
            int weight;
            public Pair(int data, int weight){
                this.data = data;
                this.weight = weight;
            }
            public int compareTo(Pair p2){
                return this.weight - p2.weight;
            }
        }
        public static void PrimsAlgorithm(ArrayList<Edge> graph[], int start){
            boolean vis[] = new boolean[graph.length];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int finalCost = 0;
            // insert pair of start in the pq
            pq.add(new Pair(start,0));

            while(!pq.isEmpty()){
                Pair curr = pq.remove();
               if(!vis[curr.data]){
                vis[curr.data] = true;
                finalCost += curr.weight;
                for(int i = 0; i<graph[curr.data].size(); i++ ){
                    Edge e = graph[curr.data].get(i);
                    pq.add(new Pair(e.Dest,e.Wt));
                }
               }
            }
            System.out.print(finalCost);
        }
    

    public static void main(String args[]) {
        int size = 5;
        ArrayList<Edge> Graph[] = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            Graph[i] = new ArrayList<>();
        }

        //// Bellman ford algorithm to calculate shortest path when the graph contains negitive edges


        // Graph[0].add(new Edge(0, 1, 2));
        // Graph[1].add(new Edge(1, 2, -4));
        // Graph[0].add(new Edge(0, 2, 4));
        // Graph[2].add(new Edge(2, 3, 2));
        // Graph[3].add(new Edge(3, 4, 4));
        // Graph[4].add(new Edge(4, 1, -1));
        // BellmanFordshortestPath(Graph, 0, size);


        //// prims algorithm

        Graph[0].add(new Edge(0, 1, 10));
        Graph[0].add(new Edge(0, 2, 15));
        Graph[0].add(new Edge(0, 3, 30));
        Graph[1].add(new Edge(1, 3, 40));
        Graph[1].add(new Edge(1, 0, 10));
        Graph[2].add(new Edge(2, 0, 15));
        Graph[2].add(new Edge(2, 3, 50));
        Graph[3].add(new Edge(3, 0, 30));
        Graph[3].add(new Edge(3, 1, 40));
        Graph[3].add(new Edge(3, 2, 50));
        PrimsAlgorithm(Graph,0);

    }

}
