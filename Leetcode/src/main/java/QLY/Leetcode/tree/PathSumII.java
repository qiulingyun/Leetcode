package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
//public class PathSumII {
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    private int count = 0;
//    public int pathSum(TreeNode root, int targetSum) {
//        _pathSum(root, targetSum, 0);
//
//        return  count;
//    }
//
//    private int _pathSum(TreeNode root, int targetSum) {
//        if (root == null)
//            return 0;
//
//        if (root.val == targetSum)
//            count++;
//
//
//        int left = _pathSum(root.left, targetSum);
//        int right = _pathSum(root.right, targetSum);
//
//        return 0;
//    }
//
//
//
//}
