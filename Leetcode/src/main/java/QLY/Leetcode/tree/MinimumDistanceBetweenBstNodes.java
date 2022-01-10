package QLY.Leetcode.tree;

public class MinimumDistanceBetweenBstNodes {

    public int minDiffInBST(TreeNode root) {
        _minDiffInBST(root);
        return minDiff;

    }

    private TreeNode prev = null;
    private int minDiff = Integer.MAX_VALUE;
    private void _minDiffInBST(TreeNode root) {
        if (root == null)
            return;

        _minDiffInBST(root.left);
        if (prev != null){
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        _minDiffInBST(root.right);
    }
}
