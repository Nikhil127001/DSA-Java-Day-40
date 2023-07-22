import java.util.*;
public class GraphsB{

    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int node,int path){
            this.node = node;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }


    public static void findShortestpath(ArrayList<Edge> graph[],int src){
        // first create an array to store distance of the node from the source
        int distance[] = new int[graph.length];
        // creating visited array to track visited nodes
        boolean visited[] = new boolean[graph.length];

        //initialise all the distances with infinite initially
        for(int i = 0 ; i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        } 

        PriorityQueue <Pair> pq  = new PriorityQueue<>();
        // add source pair to the pq and update its visited
        pq.add(new Pair(src,0));
        // initialise the distance of src 
        distance[0] = 0;
        while(!pq.isEmpty()){
            Pair x = pq.remove();
            if(!visited[x.node]){
                // change visited to true
                visited[x.node] = true;

                // go to its neighbours and update the values
                for(int i = 0 ;i<graph[x.node].size(); i++){
                    Edge e = graph[x.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(distance[u] + wt < distance[v]){
                        distance[v] = distance[u] + wt;
                        // update the pq
                        pq.add(new Pair(v,distance[v]));
                    }
                }
            }
        }
        for(int i = 0; i<distance.length;i++){
            System.out.println("Shortest path from src to "+i+" is : "+ distance[i]);
        }
    }

    public static void main(String args[]){
        // creating sraph
        int size = 6;
        ArrayList<Edge> Graph[] = new ArrayList[size];
        // inserting arraylists in the Graph array
        for(int i = 0; i<Graph.length; i++){
            Graph[i] = new ArrayList<>();
        } 
        // adding elements in the arrayList
        Graph[0].add(new Edge(0,1,2));
        Graph[0].add(new Edge(0,2,4));
        Graph[1].add(new Edge(1,2,1));
        Graph[1].add(new Edge(1,3,7));
        Graph[2].add(new Edge(2,4,3));
        Graph[3].add(new Edge(3,5,1));
        Graph[4].add(new Edge(4,5,5));
        Graph[4].add(new Edge(4,3,2));

        //** IMP Dijkstra's Algorithm -> find shortest path from src to other nodes 

        findShortestpath(Graph,0);
    }
}
