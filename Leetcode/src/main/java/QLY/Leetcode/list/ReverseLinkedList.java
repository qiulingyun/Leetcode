package QLY.Leetcode.list;

import QLY.Leetcode.list.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 1->2->3
    //       return 3
    // 1->2->3
    //    2<-3
    // 1<-2
    public ListNode reverseListRecursive(ListNode head){
        if (head == null)
            return null;
        else if (head.next == null)
            return head;

        ListNode node = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }

    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode listNode = ListUtil.constructList(new int[]{1, 2, 3});
        ListNode reverse = r.reverseListRecursive(listNode);
    }
}
