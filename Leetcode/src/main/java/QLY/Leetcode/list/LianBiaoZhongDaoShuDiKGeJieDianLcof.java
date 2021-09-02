package QLY.Leetcode.list;

public class LianBiaoZhongDaoShuDiKGeJieDianLcof {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int k = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {
        this.k = k;
        return _getKthFromEnd(head);
    }
    public ListNode _getKthFromEnd(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode node = _getKthFromEnd(head.next);
        if (node != null)
            return node;
        if (--this.k == 0)
            return head;
        return null;
    }

    public static void main(String[] args) {
        LianBiaoZhongDaoShuDiKGeJieDianLcof obj = new LianBiaoZhongDaoShuDiKGeJieDianLcof();
        obj.getKthFromEnd(null, 1);
    }
}
