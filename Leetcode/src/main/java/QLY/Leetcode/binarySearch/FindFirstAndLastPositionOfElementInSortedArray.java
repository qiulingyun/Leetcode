package QLY.Leetcode.binarySearch;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int[] results = new int[2];
        int left = 0, right = nums.length;  //[left, right)
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (left >= nums.length || nums[left] != target){
            return new int[]{-1, -1};
        }
        results[0] = left;

        left = 0;
        right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid + 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        results[1] = right - 1;

        return results;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray o = new FindFirstAndLastPositionOfElementInSortedArray();
//        System.out.println(Arrays.toString(o.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(o.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(o.searchRange(new int[]{2, 2}, 3)));
    }
}
