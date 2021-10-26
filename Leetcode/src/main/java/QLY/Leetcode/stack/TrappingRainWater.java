package QLY.Leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class TrappingRainWater {
    private static class Pair{
        public int index;
        public int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
//    public int trap(int[] height) {
//        Stack<Pair> desc = new Stack<>();
//        for (int i = 0; i < height.length; i++) {
//            LinkedList<Pair> popouts = new LinkedList<>();
//            while (!desc.isEmpty() && desc.peek().value < height[i]){
//                Pair pop = desc.pop();
//                popouts.addFirst(pop);
//            }
//            int sum = popouts.stream().mapToInt(o->o.value).sum();
//
//            for (Pair pop : popouts) {
//                sum
//            }
//            desc.push(new Pair(i, height[i]));
//
//        }
//    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
//        System.out.println(obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
