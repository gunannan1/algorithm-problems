package leetcode;


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Example:

 Input: head = 1->4->3->2->5->2, x = 3
 Output: 1->2->2->4->3->5

 将单向链表按值分为左边小，中间相等，右边大的格式
 */
public class P86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (head!=null){
            if (head.val<x) {
                cur1.next = head;
                cur1 = head;
            }
            else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        cur2.next = null;  //important! avoid cycle in linked list. otherwise u will get TLE.
        cur1.next = dummy2.next;
        return dummy1.next;

    }
}
