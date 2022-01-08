package QLY.Leetcode.window;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (right < nums.length){
            sum += nums[right];
            while (left <= right && sum >= target){
                if (left == right)
                    return 1;
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];

            }
            right++;
        }
        if (result != Integer.MAX_VALUE)
            return result;
        return 0;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        System.out.println(m.minSubArrayLen(11, new int[]{1,4,4}));
    }
}
