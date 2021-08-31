package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        while (!(curr == null && st.isEmpty())){
            while (curr != null){
                st.push(curr);
                curr = curr.left;
            }
            if (!st.isEmpty()){
                curr = st.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }

        return  ans;
    }
}
