package QLY.Leetcode.twopointer;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        final int n = s.length();
        boolean[][] dp = new boolean[n][n]; //dp[i][j] 表示以下标i开头，以下标j结尾的字符串是否为回文串
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = true;    //这样初始化只是为了 i > j 时可以满足递推式 dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }

        }

        int max = 1, left = 0, right = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
    }

//    private boolean isPalindrome(String s, int left, int right){
//        for (int i = left, j = right; i >= 0 && j < s.length(); i--, j++) {
//            if (s.charAt(i) != s.charAt(j))
//                return false;
//        }
//        return true;
//    }
}
