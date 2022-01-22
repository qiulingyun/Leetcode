package QLY.Leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/coloring-a-border/
 * 1034. 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 *
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 * 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 */
public class ColoringABorder {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        final int N = grid.length, M = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        boolean[][] visited = new boolean[N][M];
        visited[row][col] = true;

        List<int[]> colorList = new LinkedList<>();

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            boolean isEdge = false;
            for (int[] direction :DIRECTIONS) {
                int i = curr[0] + direction[0];
                int j = curr[1] + direction[1];

                if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] != grid[curr[0]][curr[1]]){
                    isEdge = true;
                    continue;
                }

                if (visited[i][j])
                    continue;

                visited[i][j] = true;
                queue.add(new int[]{i, j});
            }
            if (isEdge)
                colorList.add(curr);
        }

        for (int[] edge : colorList) {
            grid[edge[0]][edge[1]] = color;
        }

        return grid;
    }

}
