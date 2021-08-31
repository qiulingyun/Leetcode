package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }

    private void preorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }

    private void preorderTraversalWithStack(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (!(curr == null && st.isEmpty() )){
            while (curr != null){
                ans.add(curr.val);
                st.push(curr);
                curr = curr.left;
            }
            if (!st.isEmpty()){
                curr = st.pop();
                curr = curr.right;
            }
        }
    }
}
