package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        backtrace(candidates, target, 0, new LinkedList<>(), 0, results);

        return results;
    }

    private void backtrace(int[] candidates, int target, int curr, LinkedList<Integer> path, int sum, List<List<Integer>> results){
        if (sum > target){
            return;
        }else if (sum == target){
            results.add(new LinkedList<>(path));
            return;
        }

        for (int i = curr; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                continue;

            path.add(candidates[i]);

            backtrace(candidates, target, i, path, sum + candidates[i], results);

            path.removeLast();
        }

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
