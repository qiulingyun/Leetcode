package QLY.Leetcode.tree;

public class PathSumIII {
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

    private int count = 0;
    private int targetSum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        _pathSum(root, 0);
        return count;
    }

    private void _pathSum(TreeNode root, int sum){
        if (root == null)
            return;
        sum += root.val;
        if (sum == this.targetSum)
            count++;

        _pathSum(root.left, sum);
        _pathSum(root.right, sum);

        _pathSum(root.left, 0);
        _pathSum(root.right, 0);
    }
}
