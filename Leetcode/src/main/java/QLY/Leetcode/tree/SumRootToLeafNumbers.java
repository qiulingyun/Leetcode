package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class SumRootToLeafNumbers {
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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);

    }

    private int sumNumbers(TreeNode root, int sum){
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return sum + root.val;

        return sumNumbers(root.left, (sum + root.val) * 10) + sumNumbers(root.right, (sum + root.val) * 10);
    }
}
