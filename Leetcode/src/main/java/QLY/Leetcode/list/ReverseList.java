package QLY.Leetcode.list;

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode generateList(int[] val){
        if (val == null || val.length == 0)
            return null;

        ListNode prev = null, head = null;
        for (int v: val){
            ListNode listNode = new ListNode(v, null);
            if (prev == null){
                head = prev = listNode;
            }else {
                prev.next = listNode;
                prev = listNode;
            }
        }
        return head;
    }

    public ListNode reverseByLoop(ListNode head){
        if (head == null)
            return null;

        ListNode curr = head, prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseRecursively(ListNode head){
        if (head == null)
            return null;

        return  _reverseRecursively(head, null);
    }

    public ListNode _reverseRecursively(ListNode curr, ListNode prev){
        if (curr == null)
            return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return  _reverseRecursively(next, curr);
    }

    // standard reverse
    public ListNode reverseRecursively2(ListNode head){
        if (head.next == null)
            return head;

        ListNode last = reverseRecursively2(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

//    private static List<Integer> listvalues = new LinkedList<>();
//    public void scanListRecursively(ListNode list){
//        if (list == null)
//            return;
//
//        scanListRecursively(list.next);
//        listvalues.add(list.val);
//    }

    private ListNode reverseUntil(ListNode head, ListNode nextHead){
        ListNode curr = head, prev = null;
        while (curr != nextHead){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseByGroupK(ListNode head, int k){
        if (head == null)
            return null;

        int i = 0;
        ListNode nextHead = head;
        while (nextHead != null && i < k){
            nextHead = nextHead.next;
            i++;
        }
        if (i < k){
            return head;
        }

        ListNode newHead = reverseUntil(head, nextHead);
        head.next = reverseByGroupK(nextHead, k);
        return newHead;

    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode list = reverseList.generateList(new int[]{0, 1, 2, 3, 4});
        ListNode reversed = reverseList.reverseByGroupK(list, 3);
//        reverseList.scanListRecursively(list);
        System.out.println(reversed);
    }
}
