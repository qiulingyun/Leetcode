package QLY.Leetcode.tree;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int result = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            result = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.pop();
                result += curr.val;
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
        }

        return result;
    }

}
