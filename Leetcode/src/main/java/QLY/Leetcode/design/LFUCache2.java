package QLY.Leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache2 {

    private final int capacity;
    private int minFreq;
    private final HashMap<Integer, Node> map;
    private final HashMap<Integer, LinkedList<Node>> freq;

    private static final class Node{
        public int key;
        public int value;
        public int count;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.freq = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        LinkedList<Node> list = freq.get(node.count);
        list.remove(node);
        if (list.isEmpty() && node.count == this.minFreq)
            this.minFreq++;

        node.count++;
        list = freq.getOrDefault(node.count, new LinkedList<>());
        list.addFirst(node);
        freq.putIfAbsent(node.count, list);

        return node.value;
    }

    public void put(int key, int value) {
        if (this.capacity == 0)
            return;

        if (map.containsKey(key)){
            Node node = map.get(key);
            LinkedList<Node> list = freq.get(node.count);
            list.remove(node);
            if (list.isEmpty() && node.count == this.minFreq)
                this.minFreq++;

            node.count++;
            node.value = value;
            list = freq.getOrDefault(node.count, new LinkedList<>());
            list.addFirst(node);
            freq.putIfAbsent(node.count, list);

        }else {
            if (map.size() == this.capacity){
                LinkedList<Node> list = freq.get(minFreq);
                Node remove = list.removeLast();
                map.remove(remove.key);
            }

            Node curr = new Node(key, value);
            map.put(key, curr);
            LinkedList<Node> list = freq.getOrDefault(1, new LinkedList<>());
            list.addFirst(curr);
            freq.putIfAbsent(curr.count, list);
            this.minFreq = 1;
        }
    }

    public static void main(String[] args) {
        LFUCache2 lfu = new LFUCache2(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // 返回 -1（未找到）
        lfu.get(3);      // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // 返回 -1（未找到）
        lfu.get(3);      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // 返回 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
    }
}
