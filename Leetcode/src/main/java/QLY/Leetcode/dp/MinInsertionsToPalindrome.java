package QLY.Leetcode.dp;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 * 难度 困难
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * 「回文串」是正读和反读都相同的字符串。
 *
 * 示例 1：
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 * 输入：s = "no"
 * 输出：1
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 */
public class MinInsertionsToPalindrome {
    public int minInsertions(String s) {
        // s[i..j] 成为回文串的最小插入次数
        final int N = s.length();
        int[][] dp = new int[N][N];

        for (int i = N - 2; i >= 0; i--){
            for (int j = i + 1; j < N; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][N-1];
    }

    public static void main(String[] args) {
        MinInsertionsToPalindrome minInsertionsToPalindrome = new MinInsertionsToPalindrome();
        System.out.println(minInsertionsToPalindrome.minInsertions("leetcode"));
    }
}
