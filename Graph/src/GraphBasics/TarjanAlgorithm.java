package GraphBasics;

import java.util.*;

/*
    Bridge In Graphs
    - Bridge in an edge whose detection increases the graph's number of connected components.
    - Only Work in undirected graph

    Tarjan's Algorithm:
        - Works in Depth First Search.
        - we will always make two array.
        - DiscoveryTime[] and LowestDiscoveryTime[]
    
    Algorithm:
    - We are going to track parent, DiscoveryTime, LowestDiscoveryTime
    - dt[curr]=low[curr]=++time;
    - for(int i=0 to graph[curr].size())
        Edge e
        1. Parent Do nothing
        2. !visited[e.dest]-> Apply DFS, low[curr]=min(low[curr],low[neigh])
        3. visited[e.dest] low[curr]=min(low[curr],dt[neigh])
*/

public class TarjanAlgorithm {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    static void DFS(ArrayList<Edge> graph[], boolean visited[], int curr, int dt[], int low[], int time, int parent) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == parent) {
                continue;
            } else if (!visited[e.dest]) {
                DFS(graph, visited, e.dest, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]) {
                    System.out.println("Bridge is: " + curr + " --- " + e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    static void Algo(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(graph, visited, i, dt, low, time, -1);
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
