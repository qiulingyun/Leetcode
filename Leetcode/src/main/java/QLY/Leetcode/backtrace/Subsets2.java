package QLY.Leetcode.backtrace;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * solution:
 * https://leetcode-cn.com/problems/subsets-ii/solution/90-zi-ji-iiche-di-li-jie-zi-ji-wen-ti-ru-djmf/
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        backtrace(nums, 0, new boolean[nums.length], new LinkedList<>(), results);
        return results;
    }

    private void backtrace(int[] nums, int curr, boolean[] used, LinkedList<Integer> path, List<List<Integer>> results){
        results.add(new LinkedList<>(path));
        if (curr == nums.length)
            return;

        for (int i = curr; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtrace(nums, i + 1, used, path, results);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Subsets2 s = new Subsets2();
        System.out.println(s.subsetsWithDup(new int[]{2, 2, 2}));
        //[[], [1], [1, 2], [1, 2], [2], [2]]
        // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3], [3, 2]]
    }
}
