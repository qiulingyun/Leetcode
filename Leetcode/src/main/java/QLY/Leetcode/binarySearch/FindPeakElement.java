package QLY.Leetcode.binarySearch;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            long numLeft = Long.MIN_VALUE, numRight = Long.MIN_VALUE;
            if (mid > 0){
                numLeft = nums[mid - 1];
            }
            if (mid < nums.length - 1){
                numRight = nums[mid + 1];
            }

            if (nums[mid] > numLeft && nums[mid] > numRight){
                return mid;
            }else if (nums[mid] <= numLeft){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(new int[]{-2147483648,-2147483647}));
    }
}
