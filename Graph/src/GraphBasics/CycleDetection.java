package GraphBasics;

import java.util.*;

//Directed Graph for the problem because cycle detection is easy to find.

/*
    Approach For Directed Graph
    1. Modified DFS
        - visited[]
    2. Recursion stack contains that node and it already got visited. Then it is cyclic condition.
*/

/*
  Pseudo Code:
   DFS(graph[],visited[],curr,resStack[]){
    visited[curr]=true;
    recStack[curr]=true;
    for(int i=0 to graph[arr].size())
        Edge e=graph[curr].get(i);
        if(recStack[e.dest]==true){
            return true;
        }else if(!visited[e.dest]){
            DFS(graph,visited,e.dest,recStack);
        }
    rec[curr]=false;
   }
 */

public class CycleDetection {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createTree(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visited[], int curr, boolean rec[]) {
        visited[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest] == true) {
                return true;
            } else if (!visited[e.dest]) {
                if (isCycleDirected(graph, visited, e.dest, rec)) {
                    return true;
                }

            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String args[]) {
        int V = 4;
        boolean[] visited = new boolean[V];
        boolean[] rec = new boolean[V];
        ArrayList<Edge> graph[] = new ArrayList[V];
        createTree(graph);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                System.out.println(isCycleDirected(graph, visited, 0, rec));
            }
        }
    }
}
