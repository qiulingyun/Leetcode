package QLY.Leetcode.design;

import java.util.HashMap;
import java.util.Stack;

public class FreqStack {
    private final HashMap<Integer, Integer> freqMap;
    private final HashMap<Integer, Stack<Integer>> stackMap;
    private int maxFreq;

    public FreqStack() {
        this.freqMap = new HashMap<>();
        this.stackMap = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        int times;
        if (freqMap.containsKey(val)){
            times = freqMap.get(val);
            times++;
        }else {
            times = 1;
        }

        maxFreq = Math.max(maxFreq, times);
        freqMap.put(val, times);
        Stack<Integer> stack = stackMap.getOrDefault(times, new Stack<>());
        stack.push(val);
        stackMap.putIfAbsent(times, stack);
    }

    public int pop() {
        Stack<Integer> stack = stackMap.get(maxFreq);
        int result = stack.pop();
        if (stack.isEmpty())
            maxFreq--;

        freqMap.compute(result, (k, v)->v-1);
        return result;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push (5);//堆栈为 [5]
        freqStack.push (7);//堆栈是 [5,7]
        freqStack.push (5);//堆栈是 [5,7,5]
        freqStack.push (7);//堆栈是 [5,7,5,7]
        freqStack.push (4);//堆栈是 [5,7,5,7,4]
        freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());

    }
}
