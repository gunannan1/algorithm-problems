package jzoffer;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。

 */
public class E24 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }

        ListNode l1=head;
        ListNode l2=head;

        for(int i=0;i<k-1;i++){
            if(l1.next!=null){
                l1=l1.next;
            }
            else {
                return null;
            }
        }

        while(l1.next!=null){
            l1=l1.next;
            l2=l2.next;
        }

        return l2;

    }
}

