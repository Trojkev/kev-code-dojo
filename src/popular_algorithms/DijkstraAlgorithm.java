package popular_algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int[][][] graph = new int[][][] {
                {},
                {},
                {},
                {},
                {}
        };
        int start = 0;
        int[] minDistances = findShortestDistanceToVertices(start, graph);

        System.out.println("Shortest distance to vertices: " + Arrays.toString(minDistances));
    }

    private static int[] findShortestDistanceToVertices(int start, int[][][] edges) {
        int totalVertices = edges.length;
        int[] minDistances = new int[totalVertices];

        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[start] = 0;

        Set<Integer> visited = new HashSet<>();

        while (visited.size() != totalVertices) {
            int[] vertexData = getVertexWithMinDistance(minDistances, visited);
            int vertexIdx = vertexData[0];
            int currentMinDistance = vertexData[1];

            if (currentMinDistance == Integer.MAX_VALUE) break;

            visited.add(vertexIdx);

            for (int[] edge: edges[vertexIdx]) {
                int destination = edge[0];
                int distance = edge[1];

                if (visited.contains(destination))
                    continue;

                if (currentMinDistance + distance < minDistances[vertexIdx]){
                    minDistances[vertexIdx] = currentMinDistance + distance;
                }
            }

            for (int i = 0; i < minDistances.length; i++) {
                if (minDistances[i] == Integer.MAX_VALUE)
                    minDistances[i] = -1;
            }
        }

        return minDistances;
    }

    private static int[] getVertexWithMinDistance(int[] minDistances, Set<Integer> visited) {
        int currentMinDistance = Integer.MAX_VALUE;
        int vertexIdx = -1;

        for (int i = 0; i < minDistances.length; i++) {
            if (visited.contains(i))
                continue;

            if (minDistances[i] < currentMinDistance) {
                currentMinDistance = minDistances[i];
                vertexIdx = i;
            }
        }

        return new int[] {vertexIdx, currentMinDistance};
    }
}
