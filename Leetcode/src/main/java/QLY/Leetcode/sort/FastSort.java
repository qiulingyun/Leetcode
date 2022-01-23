package QLY.Leetcode.sort;

import java.util.Arrays;

public class FastSort {
    public int[] fastSort(int[] nums){
        int[] result = Arrays.copyOf(nums, nums.length);
        fastSort(result, 0, nums.length - 1);
        return result;
    }

    private void fastSort(int[] nums, int low, int high){
        if (low >= high)
            return;
        int p = partition(nums, low, high);
        fastSort(nums, low, p-1);
        fastSort(nums, p+1, high);
    }

    private int partition(int[] nums, int low, int high){

        int target = nums[high];
        int partition = low - 1;
        for (int i = low; i < high; i++){
            if (nums[i] <= target){
                partition++;
                int temp = nums[i];
                nums[i] = nums[partition];
                nums[partition] = temp;

            }
        }
        int temp = nums[++partition];
        nums[partition] = target;
        nums[high] = temp;
        return partition;
    }

    public static void main(String[] args) {
        FastSort fastSort = new FastSort();
        System.out.println(Arrays.toString(fastSort.fastSort(new int[]{1,6,3,5,9,0,4})));
    }
}
