package QLY.Leetcode.array;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1          5      7       9       10
        //   2    4      6
        return 0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
