package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * 1008. 前序遍历构造二叉搜索树
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 */
public class BSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return  _bstFromPreorder(preorder, 0, preorder.length);
    }

    // [left, right)
    private TreeNode _bstFromPreorder(int[] preorder, int left, int right) {
        if (left == right)
            return null;

        TreeNode curr = new TreeNode(preorder[left]);
        if (left + 1 == right)
            return curr;

        int mid = left + 1;
        while (mid < right && preorder[mid] < preorder[left])
            mid++;

        // [left+1, mid), [mid, right)
        curr.left = _bstFromPreorder(preorder, left + 1, mid);
        curr.right = _bstFromPreorder(preorder, mid, right);

        return curr;
    }
}
