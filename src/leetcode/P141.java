package leetcode;

/**
 * 判断链表是否有环
 * 部分同 E25
 */
public class P141 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode l1=head;
        ListNode l2=head;

        while (l2.next!=null&&l1.next!=null){
            l1=l1.next;
            l2=l2.next;
            if(l2.next!=null){
                l2=l2.next;
            }
            else {
                break;
            }
            if(l2==l1){
                return true;
            }
        }
        return false;



    }
}
