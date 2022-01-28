package QLY.Leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2]; //dp[i][0] 表示第i位的最长整除子集长度，dp[i][0] 表示第i位的最长整除子集前一个元素的下标
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }
        LinkedList<Integer> results = new LinkedList<>();
        int maxlen = 0, maxpos = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i][0] < dp[j][0] + 1){
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                    if (maxlen < dp[i][0]){
                        maxlen = dp[i][0];
                        maxpos = i;
                    }
                }

            }
        }

        for (int i = maxpos; i >= 0; i = dp[i][1]) {
            results.addFirst(nums[i]);
        }

        return results;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{2,3,8,9,27}));
    }
}
