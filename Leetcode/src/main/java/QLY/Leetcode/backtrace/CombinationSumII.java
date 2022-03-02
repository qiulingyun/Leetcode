package QLY.Leetcode.backtrace;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 *
 * The same with Subsets2
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrace(candidates, target, 0, 0);

        return results;
    }

    List<List<Integer>> results = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    private void backtrace(int[] candidates, int target, int curr, int sum){
        if (sum > target){
            return;
        }else if (sum == target){
            results.add(new LinkedList<>(path));
            return;
        }

        for (int i = curr; i < candidates.length; i++) {
            if (i > curr && candidates[i] == candidates[i - 1])
                continue;

            path.add(candidates[i]);
            sum += candidates[i];

            backtrace(candidates, target, i + 1, sum);

            path.removeLast();
            sum -= candidates[i];
        }
    }


    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        System.out.println(combinationSumII.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(combinationSumII.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
