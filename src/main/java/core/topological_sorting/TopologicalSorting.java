package core.topological_sorting;

import java.util.*;

public class TopologicalSorting {
    private static final TopologicalSorting INSTANCE = new TopologicalSorting();
    private  int V;
    private  int E;
    private List<Integer>[] graph;
    private List<Integer> result;
    private TopologicalSorting() {
        this.result = new ArrayList<>();
    }
    public static TopologicalSorting go() {
        return INSTANCE;
    }
    public TopologicalSorting withvertexs(int V) {
        this.V = V;
        return this;
    }
    public TopologicalSorting withEdges(int E) {
        this.E = E;
        return this;
    }
    public TopologicalSorting initGraph() {
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        return this;
    }
    public TopologicalSorting toGraphFrom(int [][] edges) {
        for (int i = 0, n = edges.length; i < n; i++) {
            final int _u_vertex = edges[i][0];
            final int _v_vertex = edges[i][1];
            graph[_u_vertex].add(_v_vertex);
        }
        return this;
    }
    public TopologicalSorting topologicalSort() {
        boolean[] visited = new boolean[V];
        for (int vertex = 0; vertex < V; vertex++) {
            if (visited[vertex]) {
                continue;
            }
            dfs(graph, visited, vertex);
        }
        Collections.reverse(result);
        return this;
    }
    public TopologicalSorting printResult() {
        for (Integer each : result) {
            System.out.println(each);
        }
        return this;
    }
    private TopologicalSorting dfs(List<Integer>[] graph, boolean[] visited, int _u_vertex) {
        visited[_u_vertex] = true;
        for (int i = 0, n = graph[_u_vertex].size(); i < n; i++) {
            int _v_vertex = graph[_u_vertex].get(i);
            if (visited[_v_vertex]) {
                continue;
            }
            dfs(graph, visited, _v_vertex);
        }
        result.add(_u_vertex);
        return this;
    }
    public TopologicalSorting autoRunWith(int vertexs, int edges, int [][] adj, Boolean isPrintResult) {
        TopologicalSorting toReturn = INSTANCE
                .withEdges(edges)
                .withvertexs(vertexs)
                .initGraph()
                .toGraphFrom(adj)
                .topologicalSort();

        if (isPrintResult) {
            toReturn.printResult();
        }
        return toReturn;
    }
    public List<Integer> getResult() {
        return this.result;
    }
}
