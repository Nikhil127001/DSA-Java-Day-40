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

    public static void BFSN(ArrayList<Edge> Graph[], int start) {// level order traversing
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

    public static void DFS(ArrayList<Edge> graph[], int start, boolean[] visited) {
        // base print the curr element
        int curr = start;
        System.out.print(curr);
        visited[curr] = true;
        // find the neighbours of the curr and recursively check for them also
        for (int i = 0; i < graph[curr].size(); i++) {
            // check if not visited
            if (!visited[graph[curr].get(i).dest]) {
                // recursively check for other nodes
                DFS(graph, graph[curr].get(i).dest, visited);
            }
        }
    }

    public static boolean IspathExists(ArrayList<Edge>[] graph, int start, int dest, boolean[] visited) {
        // base case
        if (start == dest) {
            return true;
        }
        visited[start] = true;
        int curr = start;
        // check if the if the current element is visited(false) and recursively check
        // for its neighbour
        for (int i = 0; i < graph[curr].size(); i++) {
            // find neighbour
            Edge e = graph[curr].get(i);
            if (!visited[e.dest] && IspathExists(graph, e.dest, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    // ..................................................................................
    // BfS traversal on connected graphs
    public static void BFSX(ArrayList<Edge> graph[]) {
        // initializing the visited array
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                BFSUtils(graph, visited, i);
            }
        }

    }

    public static void BFSUtils(ArrayList<Edge> graph[], boolean visited[], int k) {
        // creating queue
        Queue<Integer> q = new LinkedList<>();
        // add the start to the Queue
        q.add(k);
        while (!q.isEmpty()) {
            // remove the first element from the Queue
            int curr = q.remove();
            // check if the curr element is not visited
            if (!visited[curr]) {
                // print the element curr
                System.out.print(curr);
                // change the visited of current to true
                visited[curr] = true;
                // then traverse through its neighbours
                for (int i = 0; i < graph[curr].size(); i++) {
                    // insert neighbours of curr in the queue
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    // DFS traversal on connected graphs

    public static void DFSX(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFSUtils(graph, i, visited);
            }
        }
    }

    public static void DFSUtils(ArrayList<Edge> graph[], int start, boolean visited[]) {
        // assign the value of start to curr variable
        int curr = start;
        System.out.print(curr);
        // change the visited of current to true
        visited[curr] = true;
        // then start traversing to the depth of the graph arr edges or nodes
        for (int i = 0; i < graph[curr].size(); i++) {
            // find the edge
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                DFSUtils(graph, e.dest, visited);
            }
        }

    }

    // ..................................................................................

    // finding cycle in the graph using BFS
    public static boolean CycleExists(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (CycleExistsUtil(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean CycleExistsUtil(ArrayList<Edge> graph[], int start, boolean visited[], int parent) {

        int curr = start;

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1:
            if (!visited[e.dest]) {
                if (CycleExistsUtil(graph, e.dest, visited, curr)) {
                    return true;
                }
            }
            // case 2:
            else if (e.dest != parent && visited[e.dest]) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckBipartite(ArrayList<Edge> graph[]) {
        int visited[] = new int[graph.length];
        for (int j = 0; j < visited.length; j++) {
            visited[j] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) {
                if (CheckBipartite(graph, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean CheckBipartite(ArrayList<Edge> graph[], int start, int color[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (color[e.dest] == -1) {
                    color[e.dest] = color[curr] == 0 ? 1 : 0;
                    q.add(e.dest);
                } else if (color[e.dest] == color[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        // creating graph structur using Adjencency list
        int size = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] Graph = new ArrayList[size];

        // creating arraylist at each index of the array
        for (int i = 0; i < size; i++) {
            Graph[i] = new ArrayList<>();
        }

        // inserting edges at each array list at different vertex of Graph Array
        // component 1
        // Graph[0].add(new Edge(0, 1, 1));
        // Graph[0].add(new Edge(0, 2, 1));
        // Graph[1].add(new Edge(1, 3, 1));
        // Graph[2].add(new Edge(2, 4, 1));
        // Graph[3].add(new Edge(3, 1, 1));
        // Graph[3].add(new Edge(3, 4, 1));
        // Graph[3].add(new Edge(3, 5, 1));
        // Graph[4].add(new Edge(4, 3, 1));
        // Graph[4].add(new Edge(4, 2, 1));
        // Graph[4].add(new Edge(4, 5, 1));
        // Graph[5].add(new Edge(5, 3, 1));
        // Graph[5].add(new Edge(5, 4, 1));
        // Graph[5].add(new Edge(5, 6, 1));
        // Graph[6].add(new Edge(6, 5, 1));
        // // component 2
        // Graph[7].add(new Edge(7, 8, 1));
        // Graph[8].add(new Edge(8, 7, 1));
        // Graph[8].add(new Edge(8, 9, 1));
        // Graph[9].add(new Edge(9, 8, 1));

        // //** IMP to find neighbours of 4
        // for(int i = 0; i< Graph[4].size();i++){
        // // extract edge from the Graphs
        // Edge e = Graph[4].get(i);
        // // printing the values of the destination
        // System.out.print(e.dest);
        // }

        // //** IMP */ traversing the graph using breadth first search(BFS)
        // BFSN(Graph, 0);
        // // traversing the graph using depth first search(DFS)
        // DFS(Graph, 0, new boolean[size]);
        // System.out.print(IspathExists(Graph, 0, 5, new boolean[size]));

        //// ** IMP BFS traversal in connected graphs
        // BFSX(Graph);
        // System.out.println();
        // DFSX(Graph);
        // System.out.println();
        //// ** find cycle in a graph
        // System.out.print(CycleExists(Graph));

        // ** IMP */ check if bipartite or not
        Graph[0].add(new Edge(0, 1, 1));
        Graph[0].add(new Edge(0, 2, 1));
        Graph[1].add(new Edge(1, 0, 1));
        Graph[1].add(new Edge(1, 3, 1));
        Graph[2].add(new Edge(2, 0, 1));
        Graph[2].add(new Edge(2, 4, 1));
        Graph[3].add(new Edge(3, 1, 1));
        // Graph[3].add(new Edge(3, 4, 1));
        Graph[4].add(new Edge(4, 2, 1));
        // Graph[4].add(new Edge(4, 3, 1));
        System.out.print(CheckBipartite(Graph));

    }
}
