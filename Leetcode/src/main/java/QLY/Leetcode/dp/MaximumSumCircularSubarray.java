package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/maximum-sum-circular-subarray/
 * 918. 环形子数组的最大和
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 *
 * anser: https://leetcode-cn.com/problems/maximum-sum-circular-subarray/solution/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-892u/
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int dpmax = nums[0], dpmin = nums[0], max = nums[0], min = nums[0], total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpmax = nums[i] + Math.max(dpmax, 0);
            max = Math.max(max, dpmax);
            dpmin = nums[i] + Math.min(dpmin, 0);
            min = Math.min(min, dpmin);

            total += nums[i];
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray max = new MaximumSumCircularSubarray();
        System.out.println(max.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(max.maxSubarraySumCircular(new int[]{5, -3, 5}));
    }
}
