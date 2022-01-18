package QLY.Leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        _longestUnivaluePath(root);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: val2len.entrySet()){
            if (entry.getValue() > max)
                max = entry.getValue();
        }
        return max - 1;
    }

    Map<Integer, Integer> val2len = new HashMap<>();
    /**
     *
     * @param root
     * @return 当前子树的最长同值路径长度
     */
    private int _longestUnivaluePath(TreeNode root){
        if (root == null)
            return 0;

        int left = _longestUnivaluePath(root.left);
        int right = _longestUnivaluePath(root.right);
        if (root.left != null && root.val == root.left.val && root.right != null && root.val == root.right.val){
            int len = val2len.getOrDefault(root.val, 0);
            if (left + right + 1 > len)
                val2len.put(root.val, left + right + 1);
            return left >= right? left + 1: right + 1;
        }else if (root.left != null && root.val == root.left.val){
            int len = val2len.getOrDefault(root.val, 0);
            if (left + 1 > len)
                val2len.put(root.val, left + 1);
            return left + 1;
        }else if (root.right != null && root.val == root.right.val){
            int len = val2len.getOrDefault(root.val, 0);
            if (right + 1 > len)
                val2len.put(root.val, right + 1);
            return right + 1;
        }

        val2len.putIfAbsent(root.val, 1);
        return 1;
    }
}
