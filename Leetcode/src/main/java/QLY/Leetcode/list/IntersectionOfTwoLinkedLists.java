package QLY.Leetcode.list;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int len1 = 0, len2 = 0;
        for (ListNode curr = headA; curr != null; curr = curr.next){
            len1++;
        }
        for (ListNode curr = headB; curr != null; curr = curr.next){
            len2++;
        }

        int diff = len2 - len1;
        ListNode curr1 = headA, curr2 = headB;
        if (diff > 0){
            for (int i = diff; i > 0 ; i--) {
                curr2 = curr2.next;
            }
        }else {
            for (int i = -diff; i > 0 ; i--) {
                curr1 = curr1.next;
            }
        }

        while (curr1 != null && curr2 != null){
            if (curr1 == curr2)
                return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null;
    }
}
