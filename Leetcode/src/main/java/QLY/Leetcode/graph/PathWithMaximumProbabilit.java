package QLY.Leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PathWithMaximumProbabilit {
    private static final class Node{
        public int id;
        public double prob;

        public Node(int id, double prob) {
            this.id = id;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] neighbours = new double[n][n];
        for (int i = 0; i < edges.length; i++) {
            neighbours[edges[i][0]][edges[i][1]] = succProb[i];
            neighbours[edges[i][1]][edges[i][0]] = succProb[i];
        }
        boolean[] visited = new boolean[n];
        visited[start] = true;
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b)-> {
            return Double.compare(b.prob, a.prob);
        });
        queue.add(new Node(start, 1));
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(start, 1d);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            visited[curr.id] = true;
            for (int i = 0; i < neighbours[curr.id].length; i++) {
                if (i == curr.id || visited[i] || neighbours[curr.id][i] == 0d)
                    continue;
                Double neighbourProb = map.get(i);
                double currProb = curr.prob * neighbours[curr.id][i];
                if (neighbourProb == null || currProb > neighbourProb)
                    map.put(i, currProb);
                queue.add(new Node(i, currProb));
            }
        }
        if (map.containsKey(end))
            return map.get(end);

        return 0d;
    }

}
