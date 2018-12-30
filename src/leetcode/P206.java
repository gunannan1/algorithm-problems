package leetcode;

/**
 * 反转链表
 */
public class P206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    //递归做法
//    public ListNode reverseList(ListNode head) {
//    /* recursive solution */
//        return reverseListInt(head, null);
//    }
//
//    private ListNode reverseListInt(ListNode head, ListNode newHead) {
//        if (head == null)
//            return newHead;
//        ListNode next = head.next;
//        head.next = newHead;
//        return reverseListInt(next, head);
//    }


}
