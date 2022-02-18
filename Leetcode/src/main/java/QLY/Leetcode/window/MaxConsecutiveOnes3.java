package QLY.Leetcode.window;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k ，如果可以翻转最多k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        final int n = nums.length;
        int left = 0, right = 0;
        int ct = 0;
        int result = 0;
        while (right < n){
            if (nums[right] == 0)
                ct++;

            right++;
            if (ct <= k)
                result = Math.max(result, right - left);
            else {
                while (ct > k && left < right){
                    if (nums[left] == 0)
                        ct--;
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes3 maxConsecutiveOnes3 = new MaxConsecutiveOnes3();
        System.out.println(maxConsecutiveOnes3.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
