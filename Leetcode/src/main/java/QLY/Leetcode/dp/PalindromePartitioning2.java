package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 */
public class PalindromePartitioning2 {


    public int minCut(String s) {
        int n = s.length();
        if (n == 1)
            return 0;

        boolean[][] isPalindromes = new boolean[n][n];
        for (boolean[] isPalindrome: isPalindromes) {
            Arrays.fill(isPalindrome, true);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                isPalindromes[j][i] = s.charAt(j) == s.charAt(i) && isPalindromes[j + 1][i - 1];
            }
        }

        int[] dp = new int[n];  //[0,i] 范围内字符串的最小分割次数
        for (int i = 1; i < n; i++) {
            if (isPalindromes[0][i])
                dp[i] = 0;
            else {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindromes[j + 1][i])
                        temp = Math.min(dp[j], temp);
                }
                dp[i] = temp + 1;
            }
        }

        return dp[n - 1];
    }

//    private static boolean isPalindrome(String s, int left, int right){
//        while (left <= right){
//            if (s.charAt(left) != s.charAt(right))
//                return false;
//            left++;
//            right--;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        PalindromePartitioning2 palindromePartitioning2 = new PalindromePartitioning2();
        System.out.println(palindromePartitioning2.minCut("ab"));
    }
}
