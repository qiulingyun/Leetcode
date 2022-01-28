package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * 这个是最长公共子序列的相似题，最长公共子序列：https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1]; // [0, n) in word1, [0, m) in word2 的删除的最少字符数量
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings del = new DeleteOperationForTwoStrings();
        System.out.println(del.minDistance("leetcode", "etco"));
    }
}
