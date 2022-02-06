package QLY.Leetcode.graph;

/**
 * https://leetcode-cn.com/problems/path-with-maximum-gold/
 * 1219. 黄金矿工
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 */
public class PathWithMaximumGold {
    private int n = 0;
    private int m = 0;
    private boolean[][] visited = null;
    private int[][] grid = null;

    private static final int[][] DIRECTION = {{0,1},{1,0},{0,-1},{-1,0}};

    public int getMaximumGold(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;

                this.visited = new boolean[n][m];
                sum = Math.max(sum, dfs(i, j));
            }
        }

        return sum;
    }

    private int dfs(int x, int y){
        visited[x][y] = true;
        int temp = 0;

        for (int[] direction : DIRECTION) {
            int nextx = x + direction[0];
            int nexty = y + direction[1];
            if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m)
                continue;
            if (grid[nextx][nexty] == 0 || visited[nextx][nexty])
                continue;

            temp = Math.max(temp, dfs(nextx, nexty));
        }

        visited[x][y] = false;  // 这里是回溯的关键，如果不加这一句，就是DFS
        return grid[x][y] + temp;
    }

    public static void main(String[] args) {
        PathWithMaximumGold pathWithMaximumGold = new PathWithMaximumGold();
//        System.out.println(pathWithMaximumGold.getMaximumGold(new int[][]{{1, 0, 7},
//                {2, 0, 6},
//                {3, 4, 5},
//                {0, 3, 0},
//                {9, 0, 20}}));

//        System.out.println(pathWithMaximumGold.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        System.out.println(pathWithMaximumGold.getMaximumGold(new int[][]{{0,0,19,5,8},{11,20,14,1,0},{0,0,1,1,1},{0,2,0,2,0}}));
    }
}
