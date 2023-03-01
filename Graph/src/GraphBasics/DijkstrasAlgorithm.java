package GraphBasics;

import java.util.*;

/*
    Shortest Distance Algorithm: Dijkstra's Algorithm
    - Used data structure weighted directed graph
    - Relaxation: let's say that we have calculated the distance of some point dist[V] but then we found out 
                    dist[u]+wt<dist[V], So we will update the calculated value of dist[V].
    
    - Dijkstra's Algo is based of breadth first search. And also it is a Greedy Algorithm
    - We are going to use Priority Queue as auxiliary data structure
    - Priority Queue is basically same as queue just the element with highest priority comes first. It also sort the element based on priority. And make access time complexity good.
*/

/*
    Pseudo Code
    while(!pq.isEmpty()){
        Pair curr=pq.remove();
        if(!visited[curr.])
        visited[curr]=true
        for(int i=0 to .....)
            Edge e= graph[curr.node].get(i);
            //Relaxation 
            u->e.src
            v->d.dest
        
        if(dist[u]+e.wt<dist[v])
            dist[v]=dist[u]+e.wt
    }

*/

public class DijkstrasAlgorithm {
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
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }

    }

    static void Algo(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    // Relaxation Step
                    if (dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[7];
        createGraph(graph);
        Algo(graph, 0, V);
    }
}
