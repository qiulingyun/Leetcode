package QLY.Leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 提示：
 *
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class TwoSum {

    class KeyValue{
        public int index;
        public int value;

        public KeyValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        KeyValue[] keyValues = new KeyValue[nums.length];
        for (int i = 0; i < nums.length; i++) {
            keyValues[i] = new KeyValue(i, nums[i]);
        }
        Arrays.sort(keyValues, (a,b)-> a.value - b.value);
        int left = 0, right = nums.length - 1;
        while (left < right){
            if (keyValues[left].value + keyValues[right].value == target){
                return new int[]{keyValues[left].index, keyValues[right].index};
            }else if (keyValues[left].value + keyValues[right].value < target){
                left++;
            }else if (keyValues[left].value + keyValues[right].value > target){
                right--;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,2,4}, 6)));
    }
}
