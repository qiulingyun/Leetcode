package QLY.Leetcode.array;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 */
public class SubarraySumEqualsK {
//    public int subarraySum(int[] nums, int k) {
//        HashMap<Integer, Integer> counts = new HashMap<>();
//        counts.put(0, 1);
//
//        int sum = 0;
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//
//            if (counts.containsKey(sum - k)){
//                result += counts.get(sum - k);
//            }
//
//            if (counts.containsKey(sum)){
//                counts.compute(sum, (key, val)->val+1);
//            }else {
//                counts.put(sum, 1);
//            }
//        }
//
//        return result;
//    }

    public int  subarraySum(int[] nums, int target) {
        int result = 0;

        HashMap<Integer, Integer> maps = new HashMap<>();
        maps.put(0, 1);
        int[] pre = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                pre[i] = pre[i - 1] + nums[i];
            else
                pre[0] = nums[0];

            if (maps.containsKey(pre[i] - target))
                result += maps.get(pre[i] - target);

            maps.put(pre[i], maps.getOrDefault(pre[i], 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(obj.subarraySum(new int[]{1}, 0));
    }
}
