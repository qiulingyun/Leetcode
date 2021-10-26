package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, true);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null){
            if (isLeft)
                return root.val;
            return 0;
        }

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
