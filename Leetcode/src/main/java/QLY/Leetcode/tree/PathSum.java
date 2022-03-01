package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int currSum) {
        if (root == null)
            return false;
        else if (root.left == null && root.right == null)
            return root.val + currSum == targetSum;

        int curr = root.val + currSum;

        return hasPathSum(root.left, targetSum, curr) || hasPathSum(root.right, targetSum, curr);
    }
}
