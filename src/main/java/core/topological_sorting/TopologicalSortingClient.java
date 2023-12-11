package core.topological_sorting;

import java.util.List;
public class TopologicalSortingClient {
    private static final TopologicalSorting TOPO_INSTANCE = TopologicalSorting.go();
    private static final TopologicalSortingClient client = new TopologicalSortingClient();
    private TopologicalSortingClient(){}
    public static TopologicalSortingClient begin() {
        return client;
    }
    public List<Integer> execute(int V, int E, int [][] egdes) {
        return TOPO_INSTANCE.autoRunWith(V, E, egdes, false).getResult();
    }
}
