import java.util.*;
import java.util.LinkedList;

public class Graphs {
    // creating structure of edge
    static class Edge {
        int start;
        int dest;
        int weight;

        public Edge(int start, int dest, int weight) {
            this.start = start;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void BFS(ArrayList<Edge> Graph[], int start) {// level order traversing
        // we need a Queue and an array (to check if already visited)
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[Graph.length];
        // first add starting or source element to the Queue
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            // check if the curr index is not true then add curr's neighbours to the queue
            // and change its visited to true
            if (!visited[curr]) {
                // add neighbours
                for (int i = 0; i < Graph[curr].size(); i++) {
                    // extract edge from the Graphs
                    Edge e = Graph[curr].get(i);
                    // add the values to the queue
                    q.add(e.dest);
                }
                System.out.print(curr);
                // change its visited to true
                visited[curr] = true;

            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[], int start, boolean[] visited ){
        // base print the curr element
        int curr = start;
        System.out.print(curr);
        visited[curr] = true;
        // find the neighbours of the curr and recursively check for them also
        for(int i =0; i< graph[curr].size();i++){
            // check if not visited 
            if(!visited[graph[curr].get(i).dest] ){
                // recursively check for other nodes
                DFS(graph,graph[curr].get(i).dest,visited);
            }
        }
    }

    public static boolean IspathExists(ArrayList<Edge>[] graph, int start,int dest, boolean[] visited){
        // base case
        if(start == dest){
            return true;
        }
        visited[start] = true;
        int curr = start;
        // check if the if the current element is visited(false) and recursively check for its neighbour
        for(int i =0; i< graph[curr].size();i++){
            // find neighbour
            Edge e = graph[curr].get(i);
            if(!visited[e.dest] && IspathExists(graph,e.dest,dest, visited)){
                return true;
            }
        } 

        return false;
    }

    public static void main(String args[]) {
        // creating graph structur using Adjencency list
        int size = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] Graph = new ArrayList[size];

        // creating arraylist at each index of the array
        for (int i = 0; i < size; i++) {
            Graph[i] = new ArrayList<>();
        }

        // inserting edges at each array list at different vertex of Graph Array
        Graph[0].add(new Edge(0, 1, 1));
        Graph[0].add(new Edge(0, 2, 1));
        Graph[1].add(new Edge(1, 3, 1));
        Graph[2].add(new Edge(2, 4, 1));
        Graph[3].add(new Edge(3, 1, 1));
        Graph[3].add(new Edge(3, 4, 1));
        Graph[3].add(new Edge(3, 5, 1));
        Graph[4].add(new Edge(4, 3, 1));
        Graph[4].add(new Edge(4, 2, 1));
        Graph[4].add(new Edge(4, 5, 1));
        Graph[5].add(new Edge(5, 3, 1));
        Graph[5].add(new Edge(5, 4, 1));
        Graph[5].add(new Edge(5, 6, 1));
        Graph[6].add(new Edge(6, 5, 1));

        // // to find neighbours of 4
        // for(int i = 0; i< Graph[4].size();i++){
        // // extract edge from the Graphs
        // Edge e = Graph[4].get(i);
        // // printing the values of the destination
        // System.out.print(e.dest);
        // }

        // traversing the graph using breadth first search(BFS)
        BFS(Graph, 0);
        // traversing the graph using depth first search(DFS)
        DFS(Graph,0,new boolean[size]);
            System.out.print(IspathExists(Graph,0,5,new boolean[size])
            );
    }
}
