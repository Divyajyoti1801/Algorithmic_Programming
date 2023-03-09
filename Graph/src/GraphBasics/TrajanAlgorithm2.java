package GraphBasics;

import java.util.*;

/*
    ARTICULATION POINT
    - A vertex in an undirected connected graph is an articulation point (or cut vertex) if removing it (and edges through it) disconnects the graph.
    - Ancestor: a node A that was discovered before curr node in DFS, is the ancestor of curr.
    - Time Complexity: O(V+E)
    - Cases of Articulation Point 
        -- 1. Corner Node where parent = -1 && Disconnected-Children > 1
        -- 2. Must satisfy bridge condition.
*/

/*
    Pseudo Code
    DFS
     vis[curr]=true;
     dt[curr]=low[curr]=++time;
     children=0
     for(neigh)
        Edge e src-->dest
        neigh=par-->ignore
        if(vis[neigh])
            low[curr]=min(low[curr],dt[neigh])
        if(!vis[neigh])
            low[curr]=min(low[curr],low[neigh])
*/

public class TrajanAlgorithm2 {
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
        graph[4].add(new Edge(4, 3));
    }

    static void DFS(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean[] visited, int time,
            boolean ap[]) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (par == neigh) {
                continue;
            } else if (visited[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                DFS(graph, neigh, curr, dt, low, visited, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] <= low[neigh] && par != -1) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    static void articulationPoint(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean visited[] = new boolean[V];
        boolean ap[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(graph, i, -1, dt, low, visited, time, ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP: " + i);
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        articulationPoint(graph, V);
    }
}
