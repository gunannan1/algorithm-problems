package jzoffer;

/**
 * 在给定的单向列表的头指针和一个结点指针，定义在一个函数在O(1)时间删除该结点。
 *
 * 同 P237
 */
public class E19 {
    public static ListNode delete(ListNode head, ListNode toBeDelete){
        if(head==null||toBeDelete==null){
            return null;
        }

        //不是尾节点
        if(toBeDelete.next!=null){
            ListNode node=toBeDelete.next;
            toBeDelete.val=node.val;
            toBeDelete.next=node.next;
            node=null;
        }

        //如果只有一个节点
        else if(head==toBeDelete){
            toBeDelete=null;
            head=null;

        }

        //尾节点
        else{
            ListNode node = head;
            while(node.next != toBeDelete){
                node = node.next;
            }

            node.next = null;
            toBeDelete = null;
        }

        return head;

    }


}
