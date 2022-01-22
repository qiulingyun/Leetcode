package QLY.Leetcode.tree;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 */
public class BinaryTreeIsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int size = queue.size();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                set.add(curr.val);

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);

                if (curr.left != null && curr.right != null && (curr.left.val == x && curr.right.val == y || curr.left.val == y && curr.right.val ==x ))
                    return false;
            }

            if (set.contains(x) && !set.contains(y) || !set.contains(x) && set.contains(y))
                return false;
            else if (set.contains(x) && set.contains(y))
                return true;
        }

        return false;
    }
}
