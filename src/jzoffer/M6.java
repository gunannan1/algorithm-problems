package jzoffer;

/**
 * 有序的环形单链表插入新节点
 */
public class M6 {
    public static ListNode insert(ListNode head,int num){
        ListNode node=new ListNode(num);
        //如果原链表为空，构建只有1个节点的环形链表
        if(head==null){
            node.next=node;
            return node;
        }

        ListNode pre=head;
        ListNode cur=head.next;

        //限制条件为第一次遍历，找到需要插入的节点的位置
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
