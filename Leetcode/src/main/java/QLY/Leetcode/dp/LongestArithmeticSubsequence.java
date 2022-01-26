package QLY.Leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence/
 * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 */
public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int[][] dp = new int[nums.length][nums.length]; //以num[i]结尾，前一个数字是num[j]的等差数列的最大长度
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        map.put(nums[0], new HashSet<Integer>(){{add(0);}});
//        for (int i = 0; i < nums.length; i++) {
//            HashSet<Integer> set = map.getOrDefault(nums[i], new HashSet<>());
//            set.add(i);
//            map.putIfAbsent(nums[i], set);
//        }

        int maxlen = 2;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // nums[i] - nums[j] == nums[j] - nums[x];
                int prev = 2 * nums[j] - nums[i];
                // initialize
                dp[i][j] = 2;
                if (map.containsKey(prev)){
                    HashSet<Integer> set = map.get(prev);
                    for (int index : set) {
                        if (index >= j)
                            continue;
                        dp[i][j] = Math.max(dp[i][j], dp[j][index] + 1);
//                        dp[i][j] = dp[j][index] + 1;
                        maxlen = Math.max(maxlen, dp[i][j]);
                    }
                }
            }
            HashSet<Integer> set = map.getOrDefault(nums[i], new HashSet<>());
            set.add(i);
            map.putIfAbsent(nums[i], set);
        }

        return maxlen;
    }


    public static void main(String[] args) {
        LongestArithmeticSubsequence longestArithmeticSubsequence = new LongestArithmeticSubsequence();
        System.out.println(longestArithmeticSubsequence.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
        System.out.println(longestArithmeticSubsequence.longestArithSeqLength(new int[]{22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52}));
    }
}
