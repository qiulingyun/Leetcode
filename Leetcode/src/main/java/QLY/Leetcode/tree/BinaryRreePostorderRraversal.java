package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class BinaryRreePostorderRraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, lastVisit = null;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()){
                curr = stack.pop();
                if (curr.right == null || curr.right == lastVisit){
                    results.add(curr.val);
                    lastVisit = curr;
                    curr = null;
                }else {
                    stack.add(curr);
                    curr = curr.right;
                }
            }
        }

        return results;
    }
}
