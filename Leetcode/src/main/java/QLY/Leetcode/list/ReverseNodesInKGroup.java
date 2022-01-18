package QLY.Leetcode.list;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode curr = head;
        int count = 1;
        while (curr != null && count <= k){
            count++;
            curr = curr.next;
        }
        if (count <= k)
            return head;

        ListNode revHead = reverseFromLeftToRight(head, curr);
        head.next = reverseKGroup(curr, k);
        return revHead;
    }

    private ListNode reverseFromLeftToRight(ListNode left, ListNode right){
        ListNode curr = left, prev = null;
        while (curr != right){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
