package QLY.Leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/parallel-courses/
 * 1136. 平行课程
 * 已知有 N 门课程，它们以 1 到 N 进行编号。
 * 给你一份课程关系表 relations[i] = [X, Y]，用以表示课程 X 和课程 Y 之间的先修关系：课程 X 必须在课程 Y 之前修完。
 * 假设在一个学期里，你可以学习任何数量的课程，但前提是你已经学习了将要学习的这些课程的所有先修课程。
 * 请你返回学完全部课程所需的最少学期数。
 * 如果没有办法做到学完全部这些课程的话，就返回 -1。
 */
public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<Integer>[] adjs = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjs[i] = new ArrayList<>();
        }
        int[] degree = new int[n + 1];
        for (int[] relation :relations) {
            adjs[relation[0]].add(relation[1]);
            degree[relation[1]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0){
                queue.add(i);
                visited[i] = true;
            }
        }

        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                ArrayList<Integer> adjList = adjs[curr];
                for (int adj : adjList) {
                    if (visited[adj])
                        continue;
                    degree[adj]--;
                    if (degree[adj] == 0){
                        visited[adj] = true;
                        queue.add(adj);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] != 0)
                return -1;
        }

        return step;
    }

    public static void main(String[] args) {
        ParallelCourses parallelCourses = new ParallelCourses();
        System.out.println(parallelCourses.minimumSemesters(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }
}
