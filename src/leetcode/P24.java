package leetcode;

/**
 Given a linked list, swap every two adjacent nodes and return its head.

 You may not modify the values in the list's nodes, only nodes itself may be changed.



 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.

 将单链表每2个节点之间逆序

 */
public class P24 {
    //递归
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null)){
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;

    }

    //迭代
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
