package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 * answer: https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/solution/dong-tai-gui-hua-yu-zhuang-tai-zhuan-yi-by-christm/
 *
 */
public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        final int n = nums.length;
        int[][] dp = new int[n][3]; //到i下标为止，余0、1、2 的最大和
        dp[0][nums[0] % 3] = nums[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = dp[i-1][j] + nums[i];
                switch (sum % 3){
                    case 0:
                        dp[i][0] = Math.max(sum, dp[i][0]);
                        break;
                    case 1:
                        dp[i][1] = Math.max(sum, dp[i][1]);
                        break;
                    case 2:
                        dp[i][2] = Math.max(sum, dp[i][2]);
                        break;
                }
            }

            dp[i][nums[i] % 3] = Math.max(dp[i][nums[i] % 3], nums[i]);
        }

        int max = 0;
        for (int[] d: dp) {
            max = Math.max(max, d[0]);
        }
        return max;
    }

    public static void main(String[] args) {
        GreatestSumDivisibleByThree greatestSumDivisibleByThree = new GreatestSumDivisibleByThree();
        System.out.println(greatestSumDivisibleByThree.maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }
}
