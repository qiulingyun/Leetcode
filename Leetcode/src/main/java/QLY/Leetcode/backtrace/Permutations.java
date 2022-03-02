package QLY.Leetcode.backtrace;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums, new LinkedList<>());
        return results;
    }

    private final List<List<Integer>> results = new ArrayList<>();
    private final HashSet<Integer> visited = new HashSet<>();

    private void backtrace(int[] nums, LinkedList<Integer> path){
        if (path.size() == nums.length){
            results.add(new LinkedList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i))
                continue;

            path.add(nums[i]);
            visited.add(i);

            backtrace(nums, path);

            path.removeLast();
            visited.remove(i);
        }

    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }
}
