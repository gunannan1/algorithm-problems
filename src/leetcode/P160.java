package leetcode;

/**
 * 找到两个链表的第一个公共节点
 * 同 E56
 */
public class P160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode A=headA;
        ListNode B=headB;
        int lenA=getLinkedListLength(headA);
        int lenB=getLinkedListLength(headB);

        if(lenA>lenB){
            int len=lenA-lenB;
            while (len>0){
                A=A.next;
                len--;
            }

        }else if(lenB>lenA){
            int len=lenB-lenA;
            while (len>0){
                B=B.next;
                len--;
            }
        }
        while (A!=B){
            A=A.next;
            B=B.next;
        }
        return A;



    }

    private int getLinkedListLength(ListNode head){
        ListNode node=head;
        int length=1;
        while (node.next!=null){
            node=node.next;
            length++;
        }
        return length;
    }
}
