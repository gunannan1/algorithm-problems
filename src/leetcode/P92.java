package leetcode;

/**
 * 反转部分链表
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 Output: 1->4->3->2->5->NULL
 */
public class P92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        ListNode dumpy = new ListNode(0);
        ListNode pre = dumpy;


        pre.next = head;
        for(int i = 0; i<m-1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        for(int i=0; i<n-m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dumpy.next;


    }

}
