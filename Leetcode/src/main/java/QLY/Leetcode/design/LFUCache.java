package QLY.Leetcode.design;

import java.util.*;

public class LFUCache {

    private static final class Node{
        public int key;
        public int value;
        public int count;
        public long time;

        public Node(int key, int value, long time) {
            this.key = key;
            this.value = value;
            this.count = 1;
            this.time = time;
        }
//        @Override
//        public int compareTo(Object o) {
//            if (!(o instanceof Node))
//                throw new RuntimeException("Not Node.class");
//            Node target = (Node) o;
//
//            if (this.count == target.count){
//                return (int) (this.time - target.time);
//            }
//
//            return this.count - target.count;
//        }
    }
    private final int capacity;
    private long time;
    private final HashMap<Integer, Node> map;
    private final TreeSet<Node> set;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        map = new HashMap<>();
        set = new TreeSet<>((a,b)-> {
            if (a.count == b.count)
                return (int) (a.time - b.time);
            return a.count - b.count;
        });
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        set.remove(node);
        node.count++;
        node.time = this.time++;
        set.add(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (this.capacity == 0)
            return;

        if (map.containsKey(key)){
            Node node = map.get(key);
            set.remove(node);
            node.count++;
            node.time = this.time++;
            node.value = value;
            set.add(node);
        }else {
            if (map.size() == this.capacity){
                Node node = set.pollFirst();
                map.remove(node.key);
            }

            Node node = new Node(key, value, time++);
            set.add(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
//        lfu.put(3, 1);   // cache=[1,_], cnt(1)=1
//        lfu.put(2, 1);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//        lfu.put(2, 2);
//        lfu.put(4, 4);
//        System.out.println(lfu.get(2));

        lfu.put(0, 0);
        System.out.println(lfu.get(0));


    }
}
