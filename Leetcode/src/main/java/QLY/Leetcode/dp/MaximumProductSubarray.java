package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[2][nums.length];    // i下标结尾的子数组的最大/小乘积
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(Math.max(nums[i] * dp[0][i - 1], nums[i] * dp[1][i - 1]), nums[i]);
            dp[1][i] = Math.min(Math.min(nums[i] * dp[0][i - 1], nums[i] * dp[1][i - 1]), nums[i]);
        }

        return Arrays.stream(dp[0]).max().getAsInt();
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2,3,-4}));
    }
}
