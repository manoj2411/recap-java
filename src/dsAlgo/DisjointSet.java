package dsAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSet {

    public static class Graph {
        int vertices;

//        List<List<Integer>> adjList = new ArrayList<>();

        int[][] edges;

        int[] parents;

        Graph(int vertices, int[][] edges) {
            this.edges = edges;
            this.vertices = vertices;

            parents = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                parents[i] = -1;
//                adjList.add(new ArrayList<Integer>());
            }

//            for (int[] edge: edges) {
//                int src = edge[0];
//                int dest = edge[1];
//                this.adjList.get(src).add(dest);
//                this.adjList.get(dest).add(src);
//            }
        }

        private int parent(int v) {
            return parents[v] == -1 ? v : parent(parents[v]);
        }

        private void union(int v1, int v2) {
            if (v1 < v2) {
                parents[v2] = v1;
            } else {
                parents[v1] = v2;
            }
        }

        boolean isCycle() {
            // process each edge
            // find parent of each node if same then return true
            // otherwise make union

            for (int[] edge: edges) {
                int parent1 = parent(edge[0]);
                int parent2 = parent(edge[1]);

                if (parent1 == parent2)  {
                    return true;
                }

                union(edge[0], edge[1]);
            }

            return false;
        }

    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}}; //, {0, 2}};
        Graph graph = new Graph(3, edges);

        System.out.println(graph.isCycle());
    }
}


