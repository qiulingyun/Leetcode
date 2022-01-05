package QLY.Leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class TwoSumHash {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])){
                if (indexMap.get(target - nums[i]) == i)
                    continue;

                result[0] = i;
                result[1] = indexMap.get(target - nums[i]);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumHash twoSumHash = new TwoSumHash();
        System.out.println(Arrays.toString(twoSumHash.twoSum(new int[]{3,2,4}, 6)));
    }
}
