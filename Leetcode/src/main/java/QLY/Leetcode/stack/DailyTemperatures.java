package QLY.Leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * 单调递减栈：每个元素弹出时，可以知道下一个更大的元素位置，和之前更大的元素数量
 */
public class DailyTemperatures {

    private class KeyValue{
        public int index;
        public int value;

        public KeyValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<KeyValue> desc = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++){
            while (!desc.isEmpty() && desc.peek().value < T[i]){
                KeyValue pop = desc.pop();
                result[pop.index] = i - pop.index;
            }
            desc.push(new KeyValue(i, T[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70})));
    }
}
