package QLY.Leetcode.graph;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-height-trees/
 * 310. 最小高度树
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, LinkedList<Integer>> neighbors = new HashMap<>();
        int[] degree = new int[n];
        boolean[] visited = new boolean[n];
        for (int[] edge: edges){
            LinkedList<Integer> list = neighbors.getOrDefault(edge[0], new LinkedList<>());
            list.add(edge[1]);
            neighbors.putIfAbsent(edge[0], list);

            list = neighbors.getOrDefault(edge[1], new LinkedList<>());
            list.add(edge[0]);
            neighbors.putIfAbsent(edge[1], list);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (degree[i] == 1 || degree[i] == 0){
                visited[i] = true;
                queue.add(i);
                results.add(i);
            }
        }


        //bfs from degree
        while (!queue.isEmpty()){
            int size = queue.size();
            results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int curr = queue.removeFirst();

                results.add(curr);
                for (int neighbor: neighbors.getOrDefault(curr, new LinkedList<>())){
                    if (visited[neighbor])
                        continue;


                    degree[neighbor]--;
                    if (degree[neighbor] == 1){
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }

                }
            }

        }

        return results;
    }

//    public List<Integer> findMinHeightTreesBFS(int n, int[][] edges) {
//        HashMap<Integer, LinkedList<Integer>> neighbors = new HashMap<>();
//        for (int[] edge: edges){
//            LinkedList<Integer> list = neighbors.getOrDefault(edge[0], new LinkedList<>());
//            list.add(edge[1]);
//            neighbors.putIfAbsent(edge[0], list);
//
//            list = neighbors.getOrDefault(edge[1], new LinkedList<>());
//            list.add(edge[0]);
//            neighbors.putIfAbsent(edge[1], list);
//        }
//
//        int[] height = new int[n];
//
//        for (int source = 0; source < n; source++){
//            boolean[] visited = new boolean[n];
//            visited[source] = true;
//            HashMap<Integer, Integer> distance = new HashMap<>();
//            distance.put(source, 0);
//            LinkedList<Integer> queue = new LinkedList<>();
//            queue.add(source);
//
//            //BFS
//            while (!queue.isEmpty()){
//                Integer curr = queue.removeFirst();
//                Integer currDist = distance.get(curr);
//                for (int neighbor : neighbors.getOrDefault(curr, new LinkedList<>())) {
//                    if (visited[neighbor])
//                        continue;
//
//                    visited[neighbor] = true;
//                    distance.put(neighbor, currDist + 1);
//
//                    queue.add(neighbor);
//                }
//            }
//
//            // after BFS, we get the shortest distance from source
//            // tree's height = the longest distance from source
//            Optional<Integer> max = distance.values().stream().max((o1, o2) -> o1 - o2);
//            height[source] = max.get();
//        }
//
//        int minHeight = Arrays.stream(height).min().getAsInt();
//        List<Integer> answer = new ArrayList<>();
//        for (int i = 0; i < height.length; i++){
//            if (height[i] == minHeight)
//                answer.add(i);
//        }
//
//        return answer;
//    }

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
//        System.out.println(minimumHeightTrees.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
//        System.out.println(minimumHeightTrees.findMinHeightTrees(1, new int[][]{}));
        System.out.println(minimumHeightTrees.findMinHeightTrees(7, new int[][]{{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}}));

    }
}
