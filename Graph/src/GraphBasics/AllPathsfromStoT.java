package GraphBasics;

import java.util.*;

//Important Algo: All paths from Source to Target.

public class AllPathsfromStoT {
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
            Graph[i] = new ArrayList<>(); // To escape null pointer exception'
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

    static void allPathSourceToDest(ArrayList<Edge> Graph[], boolean visited[], int curr, String path, int tar) {
        if (curr == tar) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            if (visited[e.dest] == false) {
                visited[curr] = true;
                allPathSourceToDest(Graph, visited, e.dest, path + e.dest, tar);
                visited[curr] = false;
            }
        }
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        createGraph(Graph); // Graph got created by Adjacency List.
        // Source to Target initialized value
        int src = 0, tar = 5;
        // Depth First search algorithm must be used.
        allPathSourceToDest(Graph, new boolean[V], src, "0", tar);
    }
}

// Time Complexity: O(V^V) (Exponential Time Complexity)