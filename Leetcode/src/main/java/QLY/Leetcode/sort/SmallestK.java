package QLY.Leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 ) {
            return new int[0];
        }else if (k == 0){
            return new int[0];
        }else if (k >= arr.length){
            return arr;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->o2-o1);
        for (int i = 0; i < arr.length; i++){
            if (i < k){
                queue.add(arr[i]);
            }else {
                if (arr[i] < queue.peek()){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        return queue.stream().mapToInt(o->o.intValue()).toArray();
    }


    public static void main(String[] args) {
        SmallestK smallestK = new SmallestK();
        System.out.println(Arrays.toString(smallestK.smallestK(new int[]{1,3,5,7,2,4,6,8}, 4)) );
    }
}
