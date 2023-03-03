package GraphBasics;

import java.util.*;

/*
    Kosaraju Algorithm
    - Depth first search algorithm will be used.
    - The purpose of this algorithm to print SCC (Strongly connected components)
    - Modified DFS: Reverse DFS

    -- Steps Of Algorithm:
        - Get Node in stack (topological sort)
        - Transpose the graph
        - Do DFS according to stack nodes on the transpose graph
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

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
    }
}
