package QLY.Leetcode.list;

import QLY.Leetcode.tree.TreeNode;

public class ListUtil {
    public static ListNode constructList(int[] inputs){
        if (inputs == null || inputs.length == 0)
            return null;

        ListNode head = null, curr = null;
        for (int i = 0; i < inputs.length; i++) {
            if (i == 0){
                head = curr = new ListNode(inputs[0]);
            }else {
                curr.next = new ListNode(inputs[i]);
                curr = curr.next;
            }
        }

        return head;
    }
}
