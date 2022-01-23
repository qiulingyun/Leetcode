package QLY.Leetcode.sort;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> big;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((o1,o2)->o2-o1);
        big = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() <= big.size()){
            big.add(num);
            small.add(big.poll());
        }else if (small.size() > big.size()){
            small.add(num);
            big.add(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() > big.size()){
            return small.peek();
        }else if (small.size() < big.size()){
            return big.peek();
        }

        return (small.peek()+big.peek())/2.0;
    }
}
