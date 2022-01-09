package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/complete-binary-tree-inserter/
 * 919. 完全二叉树插入器
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 */
public class CompleteBinaryTreeInserter {
    private final TreeNode root;
    private ArrayList<TreeNode> nodes;

    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;

        this.nodes = new ArrayList<>();
        this.nodes.add(root);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.pop();
            if (curr.left != null){
                this.nodes.add(curr.left);
                queue.add(curr.left);
            }
            if (curr.right != null){
                this.nodes.add(curr.right);
                queue.add(curr.right);
            }

        }
    }

    public int insert(int val) {
        TreeNode curr = new TreeNode(val);
        nodes.add(curr);
        int num = nodes.size();
        TreeNode father = nodes.get(num / 2 - 1);
//        TreeNode father = getNodeN(num / 2);
        if (num % 2 == 0)
            father.left = curr;
        else
            father.right = curr;

        return father.val;
    }

    public TreeNode get_root() {
        return this.root;
    }

    /**
     *           1
     *      2         3
     *   4     5   6      [7]
     * [8]
     * @param num
     * @return
     */
    private TreeNode getNodeN(int num){
        int n = num;
        Stack<Integer> pathChoice = new Stack<>();
        while (n > 1){
            pathChoice.add(n % 2);
            n = n / 2;
        }
        TreeNode curr = root;
        while (!pathChoice.isEmpty()){
            if (curr == null)
                return curr;
            Integer choice = pathChoice.pop();
            switch (choice){
                case 0:
                    curr = curr.left;
                    break;
                case 1:
                    curr = curr.right;
                    break;
            }
        }
        return curr;
    }
}
