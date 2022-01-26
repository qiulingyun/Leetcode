package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 *
 * 注意 这个数列必须是 严格 递增的。
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];    //下标为i的最长递增子序列长度
        int[] count = new int[nums.length];  //下标为i的最长递增子序列个数
        dp[0] = 1;
        Arrays.fill(count, 1);
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    if (max < dp[j]){
                        max = dp[j];
                        count[i] = count[j];
                    }else if (max == dp[j]){
                        count[i] += count[j];
                    }
                }
            }
            dp[i] = max + 1;
        }

        int max = 0, ct = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max){
                max = dp[i];
                ct = count[i];
            }else if (dp[i] == max){
                ct += count[i];
            }
        }

        return ct;
    }

    public static void main(String[] args) {
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        System.out.println(findNumberOfLIS.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
