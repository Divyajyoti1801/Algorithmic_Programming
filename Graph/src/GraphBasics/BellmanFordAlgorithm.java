package GraphBasics;

import java.util.*;

/*
Shortest Distance Form All The Sources To Vertices: (BELLMANFORD ALGORITHM):
    - Implemented on Dynamic Programming.
    - Time Complexity more than Dijkstra's Algorithm
    -  for all edges(u,v):
        if(dist[u]+wt(u,v)<dist[v])
            //Relaxation
            dist[v]=dist[u]+wt(u,v)
    - Bellman ford fails for negative weight cycle
        a + b + c < d => -ve weight cycle condition
*/

public class BellmanFordAlgorithm {
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }

    static void Algo(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];
        // Initialization of distance array
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < V - 1; k++) { // O(V)
            for (int i = 0; i < V; i++) { // O(E)
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                    }

                }
            }
        }
        // Detecting for negative weight cycle in graph
        for (int k = 0; k < V - 1; k++) { // O(V)
            for (int i = 0; i < V; i++) { // O(E)
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        System.out.println("Negative Weight Cycle exist, Bellman Ford's Algorithm Fails");
                    }

                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        Algo(graph, 0, V);
    }
}
