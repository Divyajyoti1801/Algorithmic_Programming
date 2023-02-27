package GraphBasics;

import java.lang.Thread.State;
import java.lang.foreign.Addressable;
import java.util.*;

/*
    Topological Sorting

    -- Directed Acyclic Graph(DAG) is a directed graph with no cycles. Topological sorting is used only for DAGs (not for non DAGs). it is a linear order of vertices such that every directed edge u->v, the vertex u comes from v in the order.
    -- It basically tells us about the dependency of nodes.
    -- Use Depth First Search to perform topological sorting. 

*/

/*
    Pseudo Code
    DFS(graph,visited,curr,stack){
        visited[curr]=true;
        for(int i=0 to graph[curr].size()){
            Edge e=graph[curr].get(i);
            if(!visited(e.dest)){
                DFS(graph,visited,e.dest,stack);
            }
        }
        stack.push(curr);
    }
*/

public class TopologicalSorting {
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
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    static void topologicalSortingUtil(ArrayList<Edge> graph[], boolean visited[], int curr, Stack<Integer> stack) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSortingUtil(graph, visited, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    static void topologicalSort(ArrayList<Edge> graph[], int V) {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortingUtil(graph, visited, i, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph, V);

    }
}
