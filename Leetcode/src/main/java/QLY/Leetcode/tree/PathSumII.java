package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, 0, new LinkedList<>());
        return results;
    }

    private final List<List<Integer>> results = new ArrayList<>();
    private void pathSum(TreeNode root, int targetSum, int currSum, LinkedList<Integer> path) {
        if (root == null)
            return;

        path.add(root.val);
        int curr = root.val + currSum;

        if (root.left == null && root.right == null && curr == targetSum){
            results.add(new LinkedList<>(path));
        }

        pathSum(root.left, targetSum, curr, path);
        pathSum(root.right, targetSum, curr, path);

        path.removeLast();
    }



}
