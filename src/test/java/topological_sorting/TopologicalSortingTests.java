package topological_sorting;

import core.topological_sorting.TopologicalSortingClient;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TopologicalSortingTests {
    private static final TopologicalSortingClient client = TopologicalSortingClient.begin();
    @Test
    public void shouldHandleNormalCase() {
        final int V = 6;
        final int E = 6;
        final int[][] edges = {
                {5, 0},
                {5, 2},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };
        final List<Integer> EXPECTED = Arrays.asList(5, 4, 2, 3, 1, 0);
        final List<Integer> ACTUAL = client.execute(V, E, edges);
        System.out.println("ACTUAL " + ACTUAL);
        System.out.println("EXPECTED " + ACTUAL);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}
