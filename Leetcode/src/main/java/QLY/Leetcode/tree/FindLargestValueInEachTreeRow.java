package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null)
            return results;
        results.add(root.val);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            long max = Long.MIN_VALUE;
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode curr = queue.pop();
                if (curr.left != null){
                    max = Math.max(max, curr.left.val);
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    max = Math.max(max, curr.right.val);
                    queue.add(curr.right);
                }
            }
            if (max != Long.MIN_VALUE){
                results.add((int)max);
            }
        }

        return results;
    }
}
