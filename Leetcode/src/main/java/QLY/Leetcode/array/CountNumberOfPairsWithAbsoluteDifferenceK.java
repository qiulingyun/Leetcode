package QLY.Leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 * 2006. 差的绝对值为 K 的数对数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(k + num)){
                count += map.get(k + num);
            }
            if (map.containsKey(num - k)){
                count += map.get(num - k);
            }

            if (map.containsKey(num)){
                map.compute(num, (key,v)->v+1);
            }else {
                map.put(num, 1);
            }

        }

        return count;
    }

    public static void main(String[] args) {
        CountNumberOfPairsWithAbsoluteDifferenceK ct = new CountNumberOfPairsWithAbsoluteDifferenceK();
        System.out.println(ct.countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
        System.out.println(ct.countKDifference(new int[]{3, 1}, 3));
        System.out.println(ct.countKDifference(new int[]{1,2,2,1}, 1));
    }
}
