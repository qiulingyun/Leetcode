package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new LinkedList<>();
        backtrace(k, n, 1, new LinkedList<>(), new HashSet<>(), results);
        return results;
    }

    private void backtrace(int k, int n, int curr, LinkedList<Integer> path, HashSet<Integer> used, List<List<Integer>> results){
        if (k == 0){
            if (n == 0)
                results.add(new LinkedList<>(path));
            return;
        }


        for (int i = curr; i <= 9 ; i++) {
            if (used.contains(i))
                continue;
            path.add(i);
            used.add(i);
            backtrace(k - 1, n - i, i + 1, path, used, results);
            path.removeLast();
            used.remove(i);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII cs3 = new CombinationSumIII();
        List<List<Integer>> lists = cs3.combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
