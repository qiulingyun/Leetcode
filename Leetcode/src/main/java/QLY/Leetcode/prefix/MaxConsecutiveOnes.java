package QLY.Leetcode.prefix;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0){
                curr = 0;
            }else {
                curr++;
                result = Math.max(result, curr);
            }
        }
        return result;
    }
}
