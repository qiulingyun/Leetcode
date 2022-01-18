package QLY.Leetcode.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traversal(root);
        List<Integer> results = new ArrayList<>();

        List<TreeNode> list = new ArrayList<>();
        list.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        for (int i = 0; i <= k; i++) {
            if (i == k){
                list.forEach(treeNode -> results.add(treeNode.val));
            }else {
                List<TreeNode> temp = new ArrayList<>();
                for (TreeNode node : list) {
                    visited.add(node);
                    List<TreeNode> currNeighbours = neighbours.get(node);
                    if (currNeighbours != null)
                        currNeighbours.stream().filter(treeNode -> !visited.contains(treeNode)).forEach(temp::add);
                }
                list = temp;
            }

        }
        return results;
    }

    Map<TreeNode, List<TreeNode>> neighbours = new HashMap();

    private void traversal(TreeNode root){
        if (root == null)
            return;
        if (root.left != null){
            List<TreeNode> rootNeighbours = neighbours.getOrDefault(root, new ArrayList<>());
            rootNeighbours.add(root.left);
            neighbours.putIfAbsent(root, rootNeighbours);

            List<TreeNode> leftNeighbours = neighbours.getOrDefault(root.left, new ArrayList<>());
            leftNeighbours.add(root);
            neighbours.putIfAbsent(root.left, leftNeighbours);

            traversal(root.left);
        }

        if (root.right != null){
            List<TreeNode> rootNeighbours = neighbours.getOrDefault(root, new ArrayList<>());
            rootNeighbours.add(root.right);
            neighbours.putIfAbsent(root, rootNeighbours);

            List<TreeNode> rightNeighbours = neighbours.getOrDefault(root.right, new ArrayList<>());
            rightNeighbours.add(root);
            neighbours.putIfAbsent(root.right, rightNeighbours);

            traversal(root.right);
        }
    }
}
