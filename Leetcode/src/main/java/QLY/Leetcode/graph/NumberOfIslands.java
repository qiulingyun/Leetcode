package QLY.Leetcode.graph;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumberOfIslands {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0' || visited[i][j])
                    continue;

                visited[i][j] = true;
                queue.add(new int[]{i, j});
                count++;

                while (!queue.isEmpty()){
                    int[] curr = queue.poll();
                    for (int[] direction : DIRECTIONS) {
                        int[] adj = new int[]{curr[0] + direction[0], curr[1] + direction[1]};
                        if (adj[0] < 0 || adj[0] >= grid.length || adj[1] < 0 || adj[1] >= grid[curr[0]].length || visited[adj[0]][adj[1]])
                            continue;

                        if (grid[adj[0]][adj[1]] == '0')
                            continue;

                        visited[adj[0]][adj[1]] = true;
                        queue.add(adj);
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }
}
