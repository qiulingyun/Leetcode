package QLY.Leetcode.list;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        /**
         * 1  ,  4,    3,       2,        5,        2
         *                                r         l
         */
        ListNode leftHead = null, leftTail = null, rightHead = null, rightTail = null;
        for (ListNode curr = head; curr != null; curr = curr.next){
            if (curr.val < x){
                if (leftHead == null)
                    leftHead = curr;

                if (leftTail == null){
                    leftTail = curr;
                }else {
                    leftTail.next = curr;
                    leftTail = curr;
                }
            }else {
                if (rightHead == null)
                    rightHead = curr;

                if (rightTail == null){
                    rightTail = curr;
                }else {
                    rightTail.next = curr;
                    rightTail = curr;
                }

            }
        }

        if (leftTail != null)
            leftTail.next = rightHead;

        if (rightTail != null)
            rightTail.next = null;

        return leftHead != null? leftHead: rightHead;
    }
}
