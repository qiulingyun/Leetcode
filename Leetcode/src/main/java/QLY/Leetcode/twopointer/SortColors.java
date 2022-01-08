package QLY.Leetcode.twopointer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // [0, p0) =>0, [p0, p1]=>1, (p1, length-1]=>2
        int p0 = 0, p1 = nums.length - 1;
        for (int i = 0; i <= p1; i++) {

            // 0  0  1  1    2
            //   p0    p1,i
            switch (nums[i]){
                case 0:
                    swap(nums, i, p0);
                    p0++;
                    break;
                case 1:
                    break;
                case 2:
                    swap(nums, i, p1);
                    p1--;
                    i--;
                    break;
            }
        }


    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
