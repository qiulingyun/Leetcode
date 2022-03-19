package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 */
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        if (root == null)
            return "";

        String val = String.valueOf(root.val);
        if (root.left == null && root.right == null)
            return val;

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (root.left != null && root.right == null)
            return val + "(" + left + ")" ;

        return val + "(" + left + ")" + "(" + right + ")";
    }

}
