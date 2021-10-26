package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        return height(root, 0) != -1;
    }

    private int height(TreeNode root, int height){
        if (root == null)
            return height;

        int left = height(root.left, height + 1);
        int right = height(root.right, height + 1);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right);
    }
}
