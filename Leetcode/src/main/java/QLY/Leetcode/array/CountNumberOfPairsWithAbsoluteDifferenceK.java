package QLY.Leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

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
