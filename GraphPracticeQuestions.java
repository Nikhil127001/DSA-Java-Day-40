import java.util.*;
import java.util.LinkedList;
import java.util.Arrays;

public class GraphPracticeQuestions {

    // ...........................................................................
    static void addEdge(ArrayList<Integer> graph[], int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    public static void createGraph(ArrayList<Integer> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public static void isCycleExists(ArrayList<Integer> graph[]) {
        if (CycleDetectionBFS(graph)) {
            System.out.print("Cycle exists");
        } else {
            System.out.print("Cycle not exists");
        }
    }

    public static boolean CycleDetectionBFS(ArrayList<Integer> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (CycleDetectionBFSUtils(graph, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean CycleDetectionBFSUtils(ArrayList<Integer> graph[], int start, boolean visited[]) {
        int flag[] = new int[graph.length];
        // first initialise all the element of the array as -1 (means unvisited)
        Arrays.fill(flag, -1);
        // then add element in the Queue and change flag to 0 (means added to Queue)
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        flag[start] = 0;

        while (!q.isEmpty()) {
            // then poll element from the Queue and change flag to -1 (means visited or
            // element removed from the Queue)
            int curr = q.poll();
            flag[curr] = -1;
            if (!visited[curr]) {
                // if element is not visited then change it to visited
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    int e = graph[curr].get(i);
                    // if the element is not visited and its flag is equal to 0 that means cycle
                    // exists
                    if (flag[e] == 0) {
                        return true;
                    }
                    // if the element is not visited and its neighbour flag is not equal to 0 than
                    // add the neighbour to the queue and change flag to 0;
                    q.add(e);
                    flag[e] = 0;
                }
            }
        }
        return false;
    }
    // ...........................................................................

    public static void main(String args[]) {
        //// Question 1 :
        // Detect cycle in an undirected graph using BFS
        // We have an an undirected graph, how to check if there is a cycle in the
        // graph? For example,
        // the following graph has a cycle 1-0-2-1..

        //// Cycle detection in undirected graphs using BFS
        int size = 4;
        ArrayList<Integer> Graph[] = new ArrayList[size];
        createGraph(Graph);
        addEdge(Graph, 0, 1);
        addEdge(Graph, 1, 2);
        addEdge(Graph, 2, 0);
        addEdge(Graph, 2, 3);
        isCycleExists(Graph);

        // Question 2 :
        // Find Minimum Depth of a Binary Tree
        // We have a binary tree, find its minimum depth. The minimum depth is the
        // number of nodes along
        // the shortest path from the root node down to the nearest leaf node. For
        // example, minimum
        // height of below Binary Tree is 2.

    }
}
