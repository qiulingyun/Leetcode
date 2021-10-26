package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = s.length() - 2; i >= 0 ; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (i + 1 <= j - 1)
                        dp[i][j] = dp[i + 1][j - 1];
                    else
                        dp[i][j] = true;
                }

            }
        }

        int maxl = 1, left = 0, right = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[i][j] && j - i + 1 > maxl){
                    maxl = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("ac"));
    }
}
