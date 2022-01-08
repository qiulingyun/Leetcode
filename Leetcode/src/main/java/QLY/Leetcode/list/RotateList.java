package QLY.Leetcode.list;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int length = 0;
        ListNode oldLastNode = null;
        for (ListNode node = head; node != null; node = node.next){
            oldLastNode = node;
            length++;
        }
        if (length == 1)
            return head;

        k = k % length;
        if (k == 0)
            return head;

        //  head -> 1 -> 2 -> newLastNode -> newHeadNode -> 6 -> 7 -> oldLastNode
        ListNode newLastNode = getRevertKthNode(head, k);
        ListNode newHeadNode = newLastNode.next;
        newLastNode.next = null;
        oldLastNode.next = head;

        return newHeadNode;
    }

    private int count = 0;
    private ListNode getRevertKthNode(ListNode head, int k){
        if (head == null)
            return null;

        ListNode listNode = getRevertKthNode(head.next, k);
        count++;
        if (count == k + 1)
            return head;
        return listNode;
    }
}
