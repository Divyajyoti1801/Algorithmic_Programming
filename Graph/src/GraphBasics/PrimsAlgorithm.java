package GraphBasics;

import java.util.*;
/*
    Prim's Algorithm
    
    - So, it works on concept of minimum spanning tree.
    - According to standard approach:
        - we created two conceptual set (MST and Non MST)
        - And found edges with minium weight and satisfying the MST primary condition
        - We are using priority queue as an auxiliary data structure to find minimum weighted edge same as Dijkstra Algo. 

    - Time Complexity: O(edge log(edge))
*/
/*
    Pseudo Code:
    MST Set: Visited <Boolean>      Non MST: Priority Queue
    
    Create Pair(node,cost) comparable interfaces
    pq.add(Pair(0,0)); //initialization of source in priority Queue

    while(!pq.isEmpty){
        Pair curr=pq.remove();
        if(!vis[curr.node]){
            vis[cur.node]=true;
            cost+=curr.cost;
            //ArrayList<Edge>ans to track edges in MST
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                if(!vis[e.dest]){
                    pq.add(e.dest,e.weight);
                }
            }
        }
    }
    
*/

public class PrimsAlgorithm {
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    static void Algo(ArrayList<Edge> graph[], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));

        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                mstCost += curr.cost;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println("Minimum Cost of Minimum Spanning Tree: " + mstCost);

    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        Algo(graph, V);
    }
}
