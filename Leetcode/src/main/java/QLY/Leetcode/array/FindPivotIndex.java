package QLY.Leetcode.array;

import java.util.Arrays;

public class FindPivotIndex {
    /**
     * https://leetcode-cn.com/problems/find-pivot-index/
     */

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int temp = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > 0){
                temp += nums[i - 1];
            }

            if ( (sum - nums[i]) % 2 != 0)
                continue;

            if (temp == (sum - nums[i]) / 2)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex obj = new FindPivotIndex();
//        System.out.println(obj.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(obj.pivotIndex(new int[]{2, 1, -1}));
        System.out.println(obj.pivotIndex(new int[]{1, 2, 3}));
    }
}
