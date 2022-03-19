package QLY.Leetcode.array;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 */
public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        final int n = arr.length;
        HashMap<Integer, Integer> val2lenMap = new HashMap<>(); // value to max length of subsequence
        val2lenMap.put(arr[0], 1);
        int result = 1;
        for (int i = 1; i < n; i++) {
            int prev = arr[i] - difference;
            if (val2lenMap.containsKey(prev)){
                int count = val2lenMap.get(prev) + 1;
                val2lenMap.put(arr[i], Math.max(count, val2lenMap.getOrDefault(arr[i], 0)));
            }else {
                val2lenMap.put(arr[i], 1);
            }

            result = Math.max(result, val2lenMap.get(arr[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfGivenDifference longestArithmeticSubsequenceOfGivenDifference = new LongestArithmeticSubsequenceOfGivenDifference();
        System.out.println(longestArithmeticSubsequenceOfGivenDifference.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}
