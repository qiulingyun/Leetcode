package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null)
            return results;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if (i == 0)
                    results.add(curr.val);

                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
            }
        }

        return results;
    }
}
