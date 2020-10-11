package dsAlgo;

import java.util.ArrayList;

public class DetectCycle {
    static boolean isCycle(ArrayList<ArrayList<Integer>> g, boolean[] visited, int v, int[] parent) {
        visited[v] = true;

        for (int v2 : g.get(v)) {

            if (parent[v2] >= 0 && parent[v2] != v) {
                return true;
            }
            parent[v2] = v;
            if (!visited[v2] && isCycle(g, visited, v2, parent)) {
                return true;
            }


        }

        return false;
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        // add your code here
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            parent[i] = -1;
        }


        for (int i = 0; i < V; i++) {
            if (visited[i] == false && isCycle(g, visited, i, parent)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0);

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        g.add(l1);
        g.add(l2);

        System.out.println(isCyclic(g, 2));
    }

}