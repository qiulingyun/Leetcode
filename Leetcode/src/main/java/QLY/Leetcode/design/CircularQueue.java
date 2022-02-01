package QLY.Leetcode.design;

public class CircularQueue {

    private int[] queue;
    private final int capacity;
    private int front;
    private int size;
    public CircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (this.size == capacity)
            return false;

        this.queue[(this.front + this.size) % this.capacity] = value;
        this.size++;
        return true;
    }

    public boolean deQueue() {
        if (this.size == 0)
            return false;

        this.front = (this.front + 1) %  this.capacity;
        this.size--;
        return true;
    }

    public int Front() {
        if (this.size == 0)
            return -1;
        return this.queue[this.front];
    }

    public int Rear() {
        if (this.size == 0)
            return -1;
        return queue[(this.front + this.size - 1) % this.capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }
}
