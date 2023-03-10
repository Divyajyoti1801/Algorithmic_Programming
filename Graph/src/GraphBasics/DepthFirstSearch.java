package GraphBasics;

import java.util.*;

public class DepthFirstSearch {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> Graph[]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }
        Graph[0].add(new Edge(0, 1));
        Graph[0].add(new Edge(0, 2));
        Graph[1].add(new Edge(1, 0));
        Graph[1].add(new Edge(1, 3));
        Graph[2].add(new Edge(2, 0));
        Graph[2].add(new Edge(2, 4));
        Graph[3].add(new Edge(3, 1));
        Graph[3].add(new Edge(3, 4));
        Graph[3].add(new Edge(3, 5));
        Graph[4].add(new Edge(4, 2));
        Graph[4].add(new Edge(4, 3));
        Graph[4].add(new Edge(4, 5));
        Graph[5].add(new Edge(5, 3));
        Graph[5].add(new Edge(5, 4));
        Graph[5].add(new Edge(5, 6));
        Graph[6].add(new Edge(6, 5));

    }

    static void DFS(ArrayList<Edge> Graph[], int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            if (visited[e.dest] == false) {
                DFS(Graph, e.dest, visited);
            }

        }

    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        createGraph(Graph);
        boolean visited[] = new boolean[V];
        // Depth First Search is a recursive function
        // Case of disconnected graph
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFS(Graph, 0, visited);
            }
        }

        System.out.println();
    }
}
