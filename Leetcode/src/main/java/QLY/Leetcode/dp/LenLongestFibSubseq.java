package QLY.Leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/Q91FMA/
 * https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
 * 剑指 Offer II 093. 最长斐波那契数列
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * （回想一下，子序列是从原序列  arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];   //dp[i][j] 表示以arr【i】结尾前一个数字是arr【j】的斐波那契数列的最大长度
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int first = arr[i] - arr[j];
                if (map.containsKey(first) && map.get(first) < j){
                    dp[i][j] = dp[j][map.get(first)] + 1;
                }else {
                    dp[i][j] = 2;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        if (max == 2)
            return 0;
        return max;
    }

    public static void main(String[] args) {
        LenLongestFibSubseq lenLongestFibSubseq = new LenLongestFibSubseq();
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,3,7}));
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{6,7,8,9,13,15,16,19,24,32,39,40,51}));
    }
}
