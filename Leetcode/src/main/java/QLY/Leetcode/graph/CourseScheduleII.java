package QLY.Leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> results = new LinkedList<>();

        HashMap<Integer, LinkedList<Integer>> neighbors = new HashMap<>();
        int[] visited = new int[numCourses];
        int[] indegrees = new int[numCourses];
        for (int[] pre: prerequisites){
            //pre[1] -> pre[0]
            LinkedList<Integer> list = neighbors.getOrDefault(pre[1], new LinkedList<>());
            list.add(pre[0]);
            neighbors.putIfAbsent(pre[1], list);

            indegrees[pre[0]]++;
        }

        for (int i = 0; i < numCourses; i++){
            if (indegrees[i] != 0)
                continue;

            if (!dfs(i, neighbors, visited, results))
                return new int[]{};
        }

        int[] ret = results.stream().mapToInt(o -> o).toArray();

        return ret.length == numCourses? ret: new int[]{};
    }

    private boolean dfs(int curr, HashMap<Integer, LinkedList<Integer>> neighbors, int[] visited, LinkedList<Integer> results){
        visited[curr] = 1;

        for (int neighbor: neighbors.getOrDefault(curr, new LinkedList<>())){
            if (visited[neighbor] == 1)
                return false;
            else if (visited[neighbor] == 2)
                continue;

            if (!dfs(neighbor, neighbors, visited, results)) {
                return false;
            }
        }

        results.addFirst(curr);
        visited[curr] = 2;
        return true;
    }


    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();
        System.out.println(Arrays.toString(obj.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
