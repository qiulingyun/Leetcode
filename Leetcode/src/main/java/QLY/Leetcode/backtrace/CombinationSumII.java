package QLY.Leetcode.backtrace;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 */
public class CombinationSumII {
    class Pair{
        public int candidate;
        public int freq;

        public Pair(int candidate, int freq) {
            this.candidate = candidate;
            this.freq = freq;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();

        Arrays.sort(candidates);
        ArrayList<Pair> candidatesList = new ArrayList<>();
        for (int candidate : candidates) {
            if (!candidatesList.isEmpty() && candidatesList.get(candidatesList.size()-1).candidate == candidate){
                candidatesList.get(candidatesList.size()-1).freq++;
            }else {
                candidatesList.add(new Pair(candidate, 1));
            }
        }

        backtrace(candidatesList, target, 0, new LinkedList<>(), 0, results);


        return results;
    }

    private void backtrace(ArrayList<Pair> candidatesList, int target, int curr, LinkedList<Integer> path, int sum, List<List<Integer>> results){
        if (sum > target){
            return;
        }else if (sum == target){
            results.add(new LinkedList<>(path));
            return;
        }

        for (int i = curr; i < candidatesList.size(); i++) {
            Pair candidate = candidatesList.get(i);

            for (int j = 1; j <= candidate.freq; j++){
                if (candidate.candidate * j + sum > target)
                    continue;

                for (int k = 0; k < j; k++)
                    path.add(candidate.candidate);

                backtrace(candidatesList, target, i+1, path, sum + candidate.candidate * j, results);

                for (int k = 0; k < j; k++)
                    path.removeLast();
            }

        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
//        System.out.println(combinationSumII.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSumII.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
