package GraphBasics;

import java.util.*;

//Unweighted UnDirection Graph

public class GraphImplementation {
    // Template of Edge
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        // To remove null, created empty arraylist.
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String args[]) {
        int V = 4; // No. of Vertex present in graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // Print Neighbor's of 2 vertex
        for (int i = 0; i < graph[1].size(); i++) {
            System.out.println(graph[1].get(i).dest + " ");
        }
    }
}
