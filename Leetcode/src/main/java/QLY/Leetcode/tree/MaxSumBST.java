package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 *
 */
public class MaxSumBST {
    public int maxSumBST(TreeNode root) {
        _maxSumBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.maxSum;
    }

    private static final class SumFlag{
        public boolean isBST;
        public int sum;

        public SumFlag(boolean isBST, int sum) {
            this.isBST = isBST;
            this.sum = sum;
        }
    }
    private int maxSum = 0;
    private SumFlag _maxSumBST(TreeNode root, int min, int max) {
        if (root == null)
            return new SumFlag(true, 0);

        if (root.val <= min || root.val >= max)
            return new SumFlag(false, 0);

        SumFlag leftSumFlag = _maxSumBST(root.left, min, root.val);
        SumFlag rightSumFlag = _maxSumBST(root.right, root.val, max);
        if (!leftSumFlag.isBST || !rightSumFlag.isBST)
            return new SumFlag(false, 0);

        int sum = root.val + leftSumFlag.sum + rightSumFlag.sum;
        this.maxSum = Math.max(this.maxSum, sum);

        return new SumFlag(true, sum);
    }
}
