package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 * 814. 二叉树剪枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        boolean rootInclude = _pruneTree(root);
        if (!rootInclude)
            return null;
        return root;
    }

    /**
     * @param root
     * @return if includes node 1
     */
    private boolean _pruneTree(TreeNode root){
        if (root == null)
            return false;

        boolean leftInclude = _pruneTree(root.left);
        if (!leftInclude)
            root.left = null;
        boolean rightInclude = _pruneTree(root.right);
        if (!rightInclude)
            root.right = null;
        return root.val == 1 || leftInclude || rightInclude;
    }
}
