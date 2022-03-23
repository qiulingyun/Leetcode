package QLY.Leetcode.twopointer;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode node = head;
        for (ListNode curr = head; curr != null ; curr = curr.next) {
            if (node.val != curr.val){
                node = node.next;
                node.val = curr.val;
            }
        }
        node.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        removeDuplicatesFromSortedList.deleteDuplicates(node1);
    }
}
