package jzoffer;

/**
 * 有序的环形单链表插入新节点
 */
public class M6 {
    public static ListNode insert(ListNode head,int num){
        ListNode node=new ListNode(num);
        if(head==null){
            node.next=node;
            return node;
        }
        ListNode pre=head;
        ListNode cur=head.next;

        while (cur!=head){
            if(pre.val<=num&&cur.val>=num){
                break;
            }
            pre=cur;
            cur=cur.next;
        }
        pre.next=node;
        node.next=cur;
        return head.val<num?head:node;


    }
}
