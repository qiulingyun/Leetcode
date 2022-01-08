package QLY.Leetcode.list;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        /**
         * 1,2,3,3,4,4,5
         *
         */
        ListNode dummyHead = new ListNode(0, head);
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null){
            if (curr.next.val != curr.next.next.val){
                curr = curr.next;
            }else {
                ListNode firstDuplicate = curr.next;
                ListNode lastNotDuplicate = curr.next.next;
                while (lastNotDuplicate != null && firstDuplicate.val == lastNotDuplicate.val)
                    lastNotDuplicate = lastNotDuplicate.next;
                curr.next = lastNotDuplicate;
            }
        }
        return dummyHead.next;
    }

}
