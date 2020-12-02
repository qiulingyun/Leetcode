package QLY.Leetcode.stack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 单调递减栈
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
