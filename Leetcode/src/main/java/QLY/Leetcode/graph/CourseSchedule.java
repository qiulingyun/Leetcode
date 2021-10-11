package QLY.Leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
//        boolean[][] neighbors = new boolean[numCourses][numCourses];
        HashMap<Integer, LinkedList<Integer>> neighbors = new HashMap<>();
        for (int[] pair: prerequisites){
//            neighbors[pair[0]][pair[1]] = true;

            if (neighbors.containsKey(pair[0])){
                neighbors.get(pair[0]).add(pair[1]);
            }else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(pair[1]);
                neighbors.put(pair[0], list);
            }
        }

        for (int i = 0; i < numCourses; i++){
            if (visited[i] != 0)
                continue;
            if (!dfs(i, neighbors, visited))
                return false;
        }
        return true;
    }

    private boolean dfs(int curr,HashMap<Integer, LinkedList<Integer>> neighbors,  int[] visited){
        visited[curr] = 1;
        for (int i : neighbors.getOrDefault(curr, new LinkedList<>())){
//            if (!neighbors[curr][i])
//                continue;

            if (visited[i] == 1)
                return false;
            else if (visited[i] == 2)
                continue;
            if (!dfs(i, neighbors, visited)) {
                return false;
            }
        }
        visited[curr] = 2;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
        System.out.println(obj.canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}
