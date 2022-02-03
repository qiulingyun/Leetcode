package QLY.Leetcode.design;

import java.util.LinkedList;

public class MaxQueue {

    private final LinkedList<Integer> queue;
    private final LinkedList<Integer> increase;

    public MaxQueue() {
        queue = new LinkedList<>();
        increase = new LinkedList<>();
    }

    public int max_value() {
        if (increase.isEmpty())
            return -1;
        return increase.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        int ct = 0;
        while (!increase.isEmpty() && increase.getLast() < value){
            increase.pollLast();
            ct++;
        }
        while (ct != 0){
            increase.add(value);
            ct--;
        }
        increase.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;

        increase.pollFirst();

        return queue.pollFirst();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();

        maxQueue.push_back(2);
        maxQueue.push_back(2);
        maxQueue.push_back(1);

        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
