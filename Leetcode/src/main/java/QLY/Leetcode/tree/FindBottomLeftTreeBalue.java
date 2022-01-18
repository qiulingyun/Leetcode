package QLY.Leetcode.tree;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 */
public class FindBottomLeftTreeBalue {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode left = null;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (left == null)
                    left = curr;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            result = left.val;
        }

        return result;
    }
}
