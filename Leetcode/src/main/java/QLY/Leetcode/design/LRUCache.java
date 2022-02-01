package QLY.Leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private final class ListNode{
        public int key;
        public int value;
        public ListNode prev;
        public ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int size;
    private HashMap<Integer, ListNode> map;
    private ListNode list;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.list = new ListNode(0, 0);
        this.list.next = this.list;
        this.list.prev = this.list;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;

            node.next = list.next;
            node.prev = list;

            list.next.prev = node;
            list.next = node;
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.value = value;
            node.next.prev = node.prev;
            node.prev.next = node.next;

            node.next = list.next;
            node.prev = list;

            list.next.prev = node;
            list.next = node;
        }else {
            if (map.size() == this.size){
                ListNode remove = this.list.prev;
                remove.prev.next = this.list;
                this.list.prev = remove.prev;
                remove.prev = null;
                remove.next = null;
                map.remove(remove.key);
            }
            ListNode curr = new ListNode(key, value);
            map.put(key, curr);
            curr.next = list.next;
            curr.prev = list;
            list.next = curr;
            curr.next.prev = curr;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
