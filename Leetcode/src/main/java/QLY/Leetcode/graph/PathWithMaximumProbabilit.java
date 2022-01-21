package QLY.Leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/path-with-maximum-probability/
 * 1514. 概率最大的路径
 * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 */
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
