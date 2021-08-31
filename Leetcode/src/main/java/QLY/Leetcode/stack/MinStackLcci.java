package QLY.Leetcode.stack;

import java.util.Stack;

public class MinStackLcci {

    Stack<Integer> st;
    Stack<Integer> min;

    /** initialize your data structure here. */
    // public MinStack() {}
    public MinStackLcci(){
        st = new Stack<>();
        min = new Stack<>();
    }


    public void push(int x) {
        st.push(x);
        if (min.isEmpty()){
            min.push(x);
            return;
        }
        int m = min.peek();
        min.push(Math.min(x, m));
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {

    }
}
