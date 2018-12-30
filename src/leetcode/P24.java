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
}
