package QLY.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        permute(nums, result, new HashSet<>(), new LinkedList<>());

        return result;
    }

    public void permute(int[] nums, List<List<Integer>> result, HashSet<Integer> usedIndex, LinkedList<Integer> currList){
        if (usedIndex.size() == nums.length){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(currList);
            result.add(tmp);
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (usedIndex.contains(i)){
                continue;
            }

            currList.add(nums[i]);
            usedIndex.add(i);

            permute(nums, result, usedIndex, currList);

            currList.removeLast();
            usedIndex.remove(i);

        }
    }

    public static void main(String[] args) {
        Permute Permute = new Permute();
        System.out.println(Permute.permute(new int[]{1,2,3}));
    }
}
