package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        return _generateTrees(1, n);
    }

    private List<TreeNode> _generateTrees(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left == right){
            list.add(new TreeNode(left));
            return list;
        }

        for (int i = left; i <= right ; i++) {

            List<TreeNode> lefts = null, rights = null;
            if (i == left){
                rights = _generateTrees(i + 1, right);
                for (TreeNode node : rights) {
                    TreeNode curr = new TreeNode(i);
                    curr.right = node;
                    list.add(curr);
                }
            }else if (i == right){
                lefts = _generateTrees(left, i - 1);
                for (TreeNode node : lefts) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = node;
                    list.add(curr);
                }
            }else {
                lefts = _generateTrees(left, i - 1);
                rights = _generateTrees(i + 1, right);
                for (TreeNode leftNode : lefts) {
                    for (TreeNode rightNode : rights) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = leftNode;
                        curr.right = rightNode;
                        list.add(curr);
                    }
                }
            }

        }

        return list;
    }
}
