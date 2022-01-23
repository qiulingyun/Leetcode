package QLY.Leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-eventual-safe-states/
 * 802. 找到最终的安全状态
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 */
public class FindEventualSafeStates {

    int[] visited = null;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] > 0)
                continue;

            dfs(graph, i);
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 2)
                results.add(i);
        }
        return results;
    }

    private boolean dfs(int[][] graph, int curr){
        visited[curr] = 1;
        for (int i = 0; i < graph[curr].length; i++) {
            int adj = graph[curr][i];
            if (visited[adj] == 2)
                continue;
            else if (visited[adj] == 1)
                return false;

            if (!dfs(graph, adj))
                return false;
        }
        visited[curr] = 2;
        return true;
    }

    public static void main(String[] args) {
        FindEventualSafeStates findEventualSafeStates = new FindEventualSafeStates();
        System.out.println(findEventualSafeStates.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
        System.out.println(findEventualSafeStates.eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));
    }
}
