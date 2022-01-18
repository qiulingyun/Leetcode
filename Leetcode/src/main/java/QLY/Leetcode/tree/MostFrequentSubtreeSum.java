package QLY.Leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return null;

        calSubtreeSum(root);
        int max = 0;
        List<Integer> resultList = null;
        for (Map.Entry<Integer, Integer> entry : occurMap.entrySet()){
            if (entry.getValue() > max){
                resultList = new ArrayList<>();
                resultList.add(entry.getKey());
                max = entry.getValue();
            }else if (entry.getValue() == max){
                resultList.add(entry.getKey());
            }
        }

        return resultList.stream().mapToInt(o->o).toArray();
    }
    Map<Integer, Integer> occurMap = new HashMap<>();
    private int calSubtreeSum(TreeNode root){
        if (root == null)
            return 0;
        int sum = root.val + calSubtreeSum(root.left) + calSubtreeSum(root.right);
        if (occurMap.containsKey(sum)){
            occurMap.compute(sum, (k, v)->v+1);
        }else {
            occurMap.put(sum, 1);
        }
        return sum;
    }
}
