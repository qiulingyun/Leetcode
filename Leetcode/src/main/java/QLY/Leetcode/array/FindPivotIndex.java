package QLY.Leetcode.array;

import java.util.Arrays;

public class FindPivotIndex {

    /**
     * https://leetcode-cn.com/problems/find-pivot-index/
     * 724. 寻找数组的中心下标
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
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
