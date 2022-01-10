package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class RangeSumOfBst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        _rangeSumBST(root);
        return sum;
    }

    private int sum = 0;
    private int low = 0, high = 0;
    private void _rangeSumBST(TreeNode root) {
        if (root == null)
            return;

        _rangeSumBST(root.left);
        if (root.val >= this.low && root.val <= this.high)
            sum += root.val;
        _rangeSumBST(root.right);
    }
}
