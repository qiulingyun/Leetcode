package QLY.Leetcode.list;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;

        ListNode revHead = null, revTail = null, revHeadPrev = null, revTailNext = null;
        int count = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = null, curr = dummy;
        while (curr != null){
            ListNode next = curr.next;
            if (count == left - 1){
                revHeadPrev = curr;
            }else if (count >= left && count <= right){
                if (count == left)
                    revTail = curr;
                if (count == right)
                    revHead = curr;
                curr.next = prev;
            }else if (count == right + 1){
                revTailNext = curr;
            }

            prev = curr;
            curr = next;
            count++;
        }

        revHeadPrev.next = revHead;
        revTail.next = revTailNext;

        return dummy.next;
    }

}
