package QLY.Leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {
    private static final class Pair{
        public ListNode ref;
        public int value;

        public Pair(ListNode ref, int value) {
            this.ref = ref;
            this.value = value;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ArrayList<Pair> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next){
            list.add(new Pair(node, node.val));
        }
        Pair[] pairs = list.toArray(new Pair[list.size()]);
        Arrays.sort(pairs, (l, r)-> l.value - r.value);

        ListNode newHead = pairs[0].ref;
        ListNode tail = newHead;
        for (int i = 1; i < pairs.length; i++) {
            tail.next = pairs[i].ref;
            tail = pairs[i].ref;
        }
        tail.next = null;
        return newHead;
    }
}
