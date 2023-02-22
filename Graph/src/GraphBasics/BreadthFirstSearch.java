package GraphBasics;

import java.util.*;

public class BreadthFirstSearch {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> Graph[]) {
        // To avoid null
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

    static void BFS(ArrayList<Edge> Graph[], int V, boolean visited[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < Graph[curr].size(); i++) {
                    Edge e = Graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        createGraph(Graph);
        boolean visited[] = new boolean[V];
        // Creation of graph Completed
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                BFS(Graph, V, visited, i);
            }
        }
        System.out.println();

        // Breadth First Search implemented

    }
}
