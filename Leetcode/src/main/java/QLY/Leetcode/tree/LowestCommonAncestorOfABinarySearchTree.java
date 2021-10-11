package QLY.Leetcode.tree;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestorOfABinarySearchTree {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> ppath = find(root, p);
        LinkedList<TreeNode> qpath = find(root, q);
        HashSet<TreeNode> pset = new HashSet<>(ppath);
        for (TreeNode node = qpath.getLast(); !qpath.isEmpty(); node = qpath.getLast()){
            if (pset.contains(node))
                return node;
            qpath.pollLast();
        }
        return null;
    }

    private LinkedList<TreeNode> find(TreeNode root, TreeNode target){
        LinkedList<TreeNode> result = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null){
            result.add(curr);
            if (target == curr)
                break;
            if (target.val < curr.val){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
        return result;
    }
}
