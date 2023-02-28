package GraphBasics;

import java.security.GeneralSecurityException;
import java.util.*;

/*
    Depth First Search Graph:
    1.Crux: So you want to go to that point but you see you already visited that point. This type of condition is known as back edge.
    2.There are three types of neighbors:
        - visited: true, parent: no :: Cycle: true
        - visited: true, parent: yes :: Cycle: Do Nothing 
        - visited: false, parent: no :: visited: true/False
    Always three types of neighbor exists for a particular vertex in graph
*/

/*
    Pseudo Code:
        dfs(graph, visited, curr,parent)
            visited[curr]=true;
            for(int i=0 to graph[curr].size())
                Edge e=graph[curr].get(i);
                if(visited[e.dest] && parent!=e.dest)
                    return;
                if(!visited[e.dest]){
                    if(dfs(graph,visited,e.dest,curr)){
                        return true;
                    }
                }
*/

public class UndirectedCycleGraph {
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
        graph[0].add(new Edge(0, 4));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

    }

    static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.dest] && parent != e.dest) {
                return true;
            } else if (!visited[e.dest]) {
                if (isCycleUndirected(graph, visited, e.dest, curr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Is Graph has cycle: " + isCycleUndirected(graph, new boolean[V], 0, -1));

    }
}
