package QLY.Leetcode.sort;

import java.util.PriorityQueue;

public class KthBigest {

    private static PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int findKthBigest(int[] nums, int k){

        for (int i = 0; i < nums.length;i ++){
            if (i < k){
                queue.add(nums[i]);
            }else {
                if (nums[i] > queue.peek()){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }

        return queue.peek();
    }


    private int partition(int[] nums, int low, int high){
        int partition = low-1;
        for (int i = low; i < high; i++){
            if (nums[i] <=  nums[high]){
                partition++;
                int temp = nums[partition];
                nums[partition] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[++partition];
        nums[partition] =  nums[high];
        nums[high] = temp;

        return partition;
    }

    private int findKthBigest2(int[] nums, int k){
        int low = 0, high = nums.length - 1;
        int kIndex = nums.length - k;
        while (low < high){
            int partition = partition(nums, low, high);
            if (partition == kIndex){
                break;
            }else if (partition < kIndex){
                low = partition + 1;
            }else {
                high = partition - 1;
            }
        }
        return nums[kIndex];
    }

    public static void main(String[] args) {
        KthBigest KthBigest = new KthBigest();
        System.out.println(KthBigest.findKthBigest2(new int[]{1,3,5,7,2,4,6,8}, 4));

//        while (!queue.isEmpty()){
//            System.out.print(queue.poll());
//        }
    }
}
