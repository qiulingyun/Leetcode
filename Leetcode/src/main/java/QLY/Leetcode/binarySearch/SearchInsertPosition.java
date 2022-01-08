package QLY.Leetcode.binarySearch;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();
        System.out.println(obj.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(obj.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(obj.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(obj.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
