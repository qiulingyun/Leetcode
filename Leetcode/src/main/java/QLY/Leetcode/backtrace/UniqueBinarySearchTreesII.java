package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class UniqueBinarySearchTreesII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> results = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
//        backtrace(n, results, used, null, null);
        return null;
    }

//    public void backtrace(int n, List<TreeNode> results, Set<Integer> used, TreeNode curr, TreeNode root){
//        if (used.size() == n){
//            results.add(root);
//            return;
//        }
//    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII obj = new UniqueBinarySearchTreesII();
        obj.generateTrees(3);
    }
}
