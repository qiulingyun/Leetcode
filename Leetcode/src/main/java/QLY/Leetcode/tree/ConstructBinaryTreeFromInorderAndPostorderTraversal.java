package QLY.Leetcode.tree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 提示:d
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length - 1;
        return buildTreeWithIndex(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeWithIndex(int[] inorder, int[] postorder, int begin, int end) {
        if (index < 0)
            return null;

        int val = postorder[index--];
        TreeNode curr = new TreeNode(val);

        int currIndex = find(inorder, val, begin, end);
        if (currIndex + 1 <= end)
            curr.right = buildTreeWithIndex(inorder, postorder, currIndex + 1, end);

        if (currIndex - 1 >= begin)
            curr.left = buildTreeWithIndex(inorder, postorder, begin, currIndex - 1);

        return curr;
    }

    private int find(int[] arr, int target, int begin, int end){
        for (int i = begin; i <= end; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
