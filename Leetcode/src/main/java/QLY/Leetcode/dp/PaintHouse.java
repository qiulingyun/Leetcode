package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/paint-house/
 * 256. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        final int n = costs.length, m = costs[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m ; k++) {
                    if (k == j)
                        continue;
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = costs[i][j] + min;
            }

        }

        return Arrays.stream(dp[n-1]).min().getAsInt();
    }

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(paintHouse.minCost(new int[][]{{7, 6, 2}}));
    }
}
