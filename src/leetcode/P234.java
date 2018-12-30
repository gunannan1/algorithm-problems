package leetcode;

import java.util.Stack;

/**
 * 判断是不是回文链表
 *
 * Input: 1->2
 Output: false

 Input: 1->2->2->1
 Output: true
 *
 */
public class P234 {
    public boolean isPalindrome(ListNode head) {
        //简单做法可以用栈，
//        Stack<ListNode> stack = new Stack<>();
//        ListNode node = head;
//        while (node != null){
//            stack.push(node);
//            node = node.next;
//        }
//        while (head != null){
//            if(head.val != stack.pop().val){
//                return false;
//            }
//            head=head.next;
//        }
//        return true;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}
