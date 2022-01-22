package QLY.Leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class CountComponents {
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            count++;
            visited[i] = true;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()){
                int curr = queue.poll();
                for (int adj : adjs[curr]) {
                    if (visited[adj])
                        continue;

                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }

        return count;
    }

}
