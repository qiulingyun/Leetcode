package QLY.Leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;

        int left = -1, right = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]){
                left = i - 1;
                break;
            }
        }
        if (left == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        right = nums.length - 1;
        while (nums[left] >= nums[right])
            right--;

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        reverse(nums, left + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right){
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1,2,3};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
