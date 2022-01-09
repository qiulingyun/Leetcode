package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // dp[n] stand for n个元素能够形成dp[n]种不同的二叉搜索树
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int sum = 0;
            // j 表示选择j号元素为根节点
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - j - 1];
            }
            dp[i] = sum;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(1));
    }
}
