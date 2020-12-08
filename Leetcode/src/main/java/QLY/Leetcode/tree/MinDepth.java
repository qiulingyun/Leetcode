package QLY.Leetcode.tree;

import java.util.LinkedList;

public class MinDepth {
    /**
     * Definition for a binary tree node.
     */
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

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        root.val = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if (curr.left == null && curr.right == null){
                return curr.val;
            }

            TreeNode left = curr.left;
            if (left != null){
                left.val = curr.val + 1;
                queue.add(left);
            }

            TreeNode right = curr.right;
            if (right != null){
                right.val = curr.val + 1;
                queue.add(right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinDepth minDepth = new MinDepth();
        System.out.println(minDepth.minDepth(null));
    }
}
