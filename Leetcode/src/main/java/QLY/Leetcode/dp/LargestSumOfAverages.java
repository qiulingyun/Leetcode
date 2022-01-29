package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-sum-of-averages/
 * 813. 最大平均值和的分组
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * good answer: https://leetcode-cn.com/problems/largest-sum-of-averages/solution/dong-tai-gui-hua-xiang-jie-by-wang-nmana-v1vk/
 */
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        final int n = nums.length;
        int[] sums = new int[n];    // 前缀和
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] += nums[i] + sums[i - 1];
        }

        double[][] dp = new double[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = (double)sums[i] / (i + 1);
        }
        for (int i = 1; i <= k; i++) {
            dp[0][i] = nums[0];
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                for (int l = 0; l < j; l++) {
                    dp[j][i] = Math.max(dp[j][i], dp[l][i-1] + (double) (sums[j] - sums[l]) / (j - l));
                }
            }
        }

        return dp[n-1][k];
    }

    public static void main(String[] args) {
        LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
        System.out.println(largestSumOfAverages.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }
}
