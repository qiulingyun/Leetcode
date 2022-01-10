package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 * 该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同
 * 1038. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class BstToGst {

    public TreeNode bstToGst(TreeNode root) {
        _bstToGst(root);
        return root;
    }

    private int sum = 0;
    private void _bstToGst(TreeNode root) {
        if (root == null)
            return;

        _bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        _bstToGst(root.left);
    }
}
