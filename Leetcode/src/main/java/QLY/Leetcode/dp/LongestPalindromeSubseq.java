package QLY.Leetcode.dp;

/**
 * 516. 最长回文子序列
 * 难度 中等
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j] 表示 s[i..j] 最长回文子序列长度
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i + 1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq("c"));
    }
}
