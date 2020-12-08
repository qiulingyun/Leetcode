package QLY.Leetcode.tree;

public class ConvertBST {
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

    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        _convertBST(root);
        return root;
    }

    private int sum = 0;
    public void _convertBST(TreeNode root) {
        if (root == null)
            return;

        _convertBST(root.right);
        sum += root.val;
        root.val = sum;
        _convertBST(root.left);
    }

    public static void main(String[] args) {
        ConvertBST convertBST = new ConvertBST();
        System.out.println(convertBST.convertBST(null));
    }
}
