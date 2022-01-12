package QLY.Leetcode.backtrace;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrace(nums, 0, path, results);

        return results;
    }

    /**
     *                  []
     *         1         2            3
     *    12       13         23
     * 123
     */
    private void backtrace(int[] nums, int curr, LinkedList<Integer> path, List<List<Integer>> results){
        results.add(new LinkedList<>(path));
        if (curr == nums.length)
            return;

        for (int i = curr; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums, i + 1, path, results);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> lists = subsets.subsets(new int[]{1, 2, 2});
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
