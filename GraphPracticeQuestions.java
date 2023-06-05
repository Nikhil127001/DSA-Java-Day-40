import java.util.*;
import java.util.LinkedList;
public class GraphPracticeQuestions {
    static class Edge{
        int str;
        int dest;
        int wt;
        public Edge(int start, int destination, int weight){
            this.str = start;
            this.dest = destination;
            this.wt = weight;
        }
    }

    public static boolean CycleExists(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i<graph.length; i++){
            if(!visited[i]){
                if(CycleExistsUtils(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean CycleExistsUtils(ArrayList<Edge> graph[] , boolean visited[] , int start,int parent){

        int curr = start;
        visited[curr] = true;
     
                for(int j = 0 ; j<graph[curr].size();j++){
                 Edge e = graph[curr].get(j);
                 if(!visited[e.dest]){
                    if(CycleExistsUtils(graph,visited,e.dest,curr)){
                    return true;
                 }
                }
                 else if(e.dest != parent && visited[e.dest]){
                    return true;
                 }
           
    }
    return false;
}
    public static void main(String args[]){
        // creating graph
        // @SuppressWarnings("unchecked");
        int size = 5;
        ArrayList<Edge> Graph[] = new ArrayList[size];

        for(int i = 0; i<size;i++){
            Graph[i] = new ArrayList<>();
        }

        Graph[0].add(new Edge(0,1,1));
        Graph[0].add(new Edge(0,2,1));
        Graph[1].add(new Edge(1,0,1));
        Graph[1].add(new Edge(1,2,1));
        // Graph[2].add(new Edge(2,0,1));
        // Graph[2].add(new Edge(2,1,1));
        

        System.out.print(CycleExists(Graph));
        

    }
}
