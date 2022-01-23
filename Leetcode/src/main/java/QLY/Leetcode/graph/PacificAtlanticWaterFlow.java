package QLY.Leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * 417. 太平洋大西洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 */
public class PacificAtlanticWaterFlow {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int m = heights.length, n = heights[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        List<List<Integer>> resutls = new ArrayList<>();
//        resutls.add(new ArrayList<Integer>(){{add(0);add(n-1);}});
//        resutls.add(new ArrayList<Integer>(){{add(m-1);add(0);}});

        // pacific
        for (int i = 0; i < m; i++) {
            if (visited[i][0] > 0)
                continue;
            resutls.addAll(bfs(heights, visited, new int[]{i, 0}, 1, 2));
        }

        for (int i = 0; i < n; i++) {
            if (visited[0][i] > 0)
                continue;
            resutls.addAll(bfs(heights, visited, new int[]{0, i}, 1, 2));
        }
        // atlantic
        for (int i = 0; i < m; i++) {
            if (visited[i][n-1] == 2)
                continue;
            resutls.addAll(bfs(heights, visited, new int[]{i, n-1}, 2, 1));
        }
        for (int i = 0; i < n; i++) {
            if (visited[m-1][i] == 2)
                continue;
            resutls.addAll(bfs(heights, visited, new int[]{m-1, i}, 2, 1));
        }
        return resutls;
    }

    private List<List<Integer>> bfs(int[][] heights, int[][] visited, int[] source, int visitVal, int contactVal){
        final int m = heights.length, n = heights[0].length;
        List<List<Integer>> resutls = new ArrayList<>();
        LinkedList<int[]> queue = new LinkedList<>();

        queue.add(new int[]{source[0], source[1]});
        if (visited[source[0]][source[1]] == contactVal){
            resutls.add(new ArrayList<Integer>(){{add(source[0]);add(source[1]);}});
        }
        visited[source[0]][source[1]] = visitVal;


        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int[] direction :DIRECTIONS) {
                int nexti = curr[0] + direction[0];
                int nextj = curr[1] + direction[1];

                if (nexti < 0 || nextj < 0 || nexti >= m || nextj >= n){
                    continue;
                }


                if (heights[curr[0]][curr[1]] > heights[nexti][nextj] )
                    continue;

                if (visited[nexti][nextj] == visitVal){
                    continue;
                }else if (visited[nexti][nextj] == contactVal){
                    resutls.add(new ArrayList<Integer>(){{add(nexti);add(nextj);}});
                }

                visited[nexti][nextj] = visitVal;
                queue.add(new int[]{nexti, nextj});
            }


        }

        return resutls;
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        List<List<Integer>> lists = pacificAtlanticWaterFlow.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
