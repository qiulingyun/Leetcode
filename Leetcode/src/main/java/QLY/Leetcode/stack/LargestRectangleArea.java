package QLY.Leetcode.stack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 单调递增栈
 */

/**
 * 84. 柱状图中最大的矩形
 * 难度 困难
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleArea {

    // 2,1,5,6,2,3
    // 0,1,2,3,4,5
    private class IndexValue{
        public int index;
        public int value;

        public IndexValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int result = 0;
        Stack<IndexValue> asc = new Stack<>();
        for (int i = 0; i < heights.length; i++){
            while (!asc.isEmpty() && asc.peek().value > heights[i]){
                IndexValue pop = asc.pop();

                int length;
                if (asc.isEmpty()){
                    length = i;
                }else {
                    length = i - asc.peek().index - 1;
                }
                int size = length * pop.value;

                if (size > result){
                    result = size;
                }

            }

            asc.push(new IndexValue(i, heights[i]));
        }

        while (!asc.isEmpty()){
            IndexValue pop = asc.pop();

            int length = heights.length - pop.index;
            if (asc.isEmpty()){
                length = heights.length;
            }else {
                length += pop.index - asc.peek().index - 1;
            }
            int size = length * pop.value;

            if (size > result){
                result = size;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{4,2,0,3,2,5}));
    }
}
