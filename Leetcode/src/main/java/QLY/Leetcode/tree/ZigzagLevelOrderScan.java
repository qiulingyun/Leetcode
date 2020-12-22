package QLY.Leetcode.tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 难度 中等
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigzagLevelOrderScan {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        List<List<Integer>> results = new ArrayList<>();
        if (root == null)
            return results;

        stack0.push(root);
        while (!stack0.isEmpty() || !stack1.isEmpty()){
            List<Integer> result = new ArrayList<>();
            if (!stack0.isEmpty()){
                while (!stack0.isEmpty()){
                    TreeNode curr = stack0.pop();
                    result.add(curr.val);
                    if (curr.left != null)
                        stack1.push(curr.left);
                    if (curr.right != null)
                        stack1.push(curr.right);
                }

            }else {
                while (!stack1.isEmpty()){
                    TreeNode curr = stack1.pop();
                    result.add(curr.val);
                    if (curr.right != null)
                        stack0.push(curr.right);
                    if (curr.left != null)
                        stack0.push(curr.left);

                }
            }
            results.add(result);

        }
        return results;
    }

    public static void main(String[] args) {

    }
}
