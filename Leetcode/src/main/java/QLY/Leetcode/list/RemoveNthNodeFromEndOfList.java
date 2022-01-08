package QLY.Leetcode.list;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthNodeFromEndOfList {
    private int count = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode next = removeNthFromEnd(head.next, n);
        count++;
        if (n == count){
            return next;
        }else if (n + 1 == count){
            head.next = next;
        }

        return head;
    }



    public static void main(String[] args) {

    }
}
