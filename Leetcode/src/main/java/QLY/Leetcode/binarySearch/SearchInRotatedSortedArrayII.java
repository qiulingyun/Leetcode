package QLY.Leetcode.binarySearch;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }
            if(nums[left] ==nums[mid] && nums[mid] == nums[right - 1]){
                left++;
                right--;
            }else if (nums[mid] <= nums[right - 1]){
                // 1, 2, 3, 5, 5
                // 1, 2, 5, 5, 5
                // right part is sorted
                if (nums[mid] < target && nums[right - 1] >= target){
                    left = mid + 1;

                }else {
                    right = mid;
                }

            }else {
                // left part is sorted
                if (nums[left] <= target && target < nums[mid]){
                    right = mid;
                }else {
                    left = mid + 1;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII o = new SearchInRotatedSortedArrayII();
        System.out.println(o.search(new int[]{1,2,0,1,1,1}, 0));
    }
}
