package QLY.Leetcode.stack;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }

            res[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(new int[]{2,1,2,4,3})));
    }
}
