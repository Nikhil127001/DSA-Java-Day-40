package mypackage;

import java.util.ArrayList;
import java.util.Stack;

public class Graphsupplimwnt {

    static class Edge {
        int st;
        int dest;

        public Edge(int st, int dest) {
            this.st = st;
            this.dest = dest;

        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void TopologicalSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                TopologicalSort(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }

    public static void createTransposeGraph(ArrayList<Edge> graph[],int curr, ArrayList<Edge> transposeGraph[]) {

        for(int i = 0 ; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            
                transposeGraph[e.dest].add(new Edge(e.dest, e.st));
            
        }
    }

    public static void DFS(ArrayList<Edge> transposeGraph[], int curr, boolean visited[]){
        visited[curr] = true;
        System.out.print(curr);

        for(int i = 0 ; i< transposeGraph[curr].size(); i++){
            Edge e = transposeGraph[curr].get(i);
            if(!visited[e.dest]){
                DFS(transposeGraph, e.dest, visited);
            }
        }
    }

    public static void KaserajuAlgorithm(ArrayList<Edge> graph[], int V) {
        // step 1 : first create a stack and perform Topological sort on it
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                TopologicalSort(graph, i, visited, s);
            }
        }

        // step 2 : make transpose graph of the current graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transposeGraph[] = new ArrayList[V];
        for(int k = 0 ; k<visited.length; k++){
            visited[k] = false;
        }
        for(int i = 0; i< transposeGraph.length; i++){
            transposeGraph[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                createTransposeGraph(graph,i, transposeGraph);
            }
        }

        // step 3 : perform dfs on the transpose graph according to nodes which were popped out from the stack
          for(int k = 0 ; k<visited.length; k++){
            visited[k] = false;
        }

        
        while(!s.isEmpty()){
          int curr = s.pop();
          if(!visited[curr]){
            DFS(transposeGraph, curr, visited);
            System.out.println();
          }
        }

       
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph, V);

        KaserajuAlgorithm(graph, V);
    }
}
