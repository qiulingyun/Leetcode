package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/max-submatrix-lcci/
 * 面试题 17.24. 最大子矩阵
 * 给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 */
public class MaxSubmatrixLcci {
    public int[] getMaxMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if (n == 1 && m == 1)
            return new int[]{0,0,0,0};

        int max = matrix[0][0];
        int[] results = new int[]{0,0,0,0};

        for (int i = 0; i < n; i++) {
            int[] sum = new int[m];
            for (int k = 0; k <= i ; k++) {
                // 第i行之前的k行被合并
                for (int j = 0; j < m; j++) {
                    sum[j] += matrix[i-k][j];
                }
                int dp = sum[0];
                int len = 1;
                for (int j = 1; j < m; j++) {
                    if (dp > 0){
                        dp += sum[j];
                        len++;
                    }else {
                        dp = sum[j];
                        len = 1;
                    }

                    if (dp > max){
                        max = dp;
                        results = new int[]{i - k, j - len + 1, i, j};
                    }
                }
            }
        }

        int dp = matrix[0][0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (dp > 0){
                dp += matrix[i][0];
                len++;
            }else {
                dp = matrix[i][0];
                len = 1;
            }

            if (dp > max){
                max = dp;
                results = new int[]{i - len + 1, 0, i, 0};
            }
        }

        return results;
    }

    public static void main(String[] args) {
        MaxSubmatrixLcci max = new MaxSubmatrixLcci();
        System.out.println(Arrays.toString(max.getMaxMatrix(new int[][]{{-4, -5}})));
        System.out.println(Arrays.toString(max.getMaxMatrix(new int[][]{{8, -4, 5}, {-1, 4, 4}, {-2, 3, 1}, {-4, 4, 3}})));
    }
}
