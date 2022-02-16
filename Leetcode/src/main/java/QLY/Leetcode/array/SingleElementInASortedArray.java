package QLY.Leetcode.array;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int prev = mid == 0? -1: nums[mid-1];
            int next = mid == nums.length - 1? -1: nums[mid+1];
            if (nums[mid] != prev && nums[mid] != next){
                return nums[mid];
            }else if (nums[mid] != prev){
                if ((mid-left) % 2 == 0){
                    // 1,1,2,2,3,3,4,4,8
                    // 0,1,2,3,4,5,6,7,8
                    left = mid;
                }else {

                    right = mid - 1;
                }
            }else {
                if ((mid-left) % 2 == 0){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        System.out.println(singleElementInASortedArray.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleElementInASortedArray.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 8}));
        System.out.println(singleElementInASortedArray.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(singleElementInASortedArray.singleNonDuplicate(new int[]{3}));
    }
}
