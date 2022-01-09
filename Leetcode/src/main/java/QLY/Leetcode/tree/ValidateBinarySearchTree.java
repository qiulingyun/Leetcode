package QLY.Leetcode.tree;


/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {
//        return _isValidBST(root).isValid;
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean _isValidBST(TreeNode root, long min, long max){
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return _isValidBST(root.left, min, root.val) && _isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        System.out.println(obj.isValidBST(null));
    }
}
