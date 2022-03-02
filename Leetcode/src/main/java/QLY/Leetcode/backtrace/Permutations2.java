package QLY.Leetcode.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.visited = new boolean[nums.length];
        backtrace(nums, new LinkedList<>());
        return results;
    }

    List<List<Integer>> results = new LinkedList<>();
    boolean[] visited;

    private void backtrace(int[] nums, LinkedList<Integer> path){
        if (path.size() == nums.length){
            results.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])
                continue;

            path.add(nums[i]);
            visited[i] = true;

            backtrace(nums, path);

            path.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        System.out.println(permutations2.permuteUnique(new int[]{1, 2, 2}));
    }
}
