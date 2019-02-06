package leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 */
public class P24 {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null)){
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;

    }

    public ListNode swapPairs2(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }
}
