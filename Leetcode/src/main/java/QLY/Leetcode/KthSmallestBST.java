package QLY.Leetcode;

public class KthSmallestBST {
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

    public int kthSmallest(TreeNode root, int k) {
        this.index = 0;
        _kthSmallest(root, k);
        return this.answer;
    }

    private int answer;
    private int index;
    public void _kthSmallest(TreeNode root, int k) {
        if (root == null)
            return;

        _kthSmallest(root.left, k);
        index++;
        if (index == k){
            answer = root.val;
            return;
        }
        _kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        KthSmallestBST kthSmallestBST = new KthSmallestBST();
        System.out.println(kthSmallestBST.kthSmallest(null, 2));
    }

}
