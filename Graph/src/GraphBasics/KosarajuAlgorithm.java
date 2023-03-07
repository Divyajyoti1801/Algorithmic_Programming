package GraphBasics;

import java.util.*;

/*
    Kosaraju Algorithm
    - Depth first search algorithm will be used.
    - The purpose of this algorithm to print SCC (Strongly connected components)
    - Modified DFS: Reverse DFS

    -- Steps Of Algorithm:
        - Get Node in stack (topological sort) O(V+E)
        - Transpose the graph O(V+E)
        - Do DFS according to stack nodes on the transpose graph O(V+E)
*/

public class KosarajuAlgorithm {
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(3, 4));
    }

    static void topologicalSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSort(graph, e.dest, visited, s);
            }
        }

        s.push(curr);
    }

    static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        visited[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    static void Algo(ArrayList<Edge> graph[], int V) {
        // Step 1
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, visited, s);
            }
        }

        // Step 2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < transpose.length; i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                dfs(graph, curr, visited);
            }
        }

    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        Algo(graph, V);

    }
}
