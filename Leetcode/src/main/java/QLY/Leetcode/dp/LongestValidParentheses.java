package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.isEmpty())
            return 0;

        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                continue;

            char b = s.charAt(i - 1);
            if (b == '('){
                if (i - 2 >= 0)
                    dp[i] = 2 + dp[i-2];
                else
                    dp[i] = 2;
            }else {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = 2 + dp[i-1];
                    if (i - dp[i - 1] - 2 >= 0)
                        dp[i] += dp[i - dp[i - 1] - 2];
                }

            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
    }
}
