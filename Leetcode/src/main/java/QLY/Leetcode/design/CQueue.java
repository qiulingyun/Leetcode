package QLY.Leetcode.design;

import java.util.Stack;

public class CQueue {
    private final Stack<Integer> in;
    private final Stack<Integer> out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.add(value);
    }

    public int deleteHead() {
        if (!out.isEmpty())
            return out.pop();

        while (!in.isEmpty())
            out.push(in.pop());

        if (out.isEmpty())
            return -1;

        return out.pop();
    }
}
