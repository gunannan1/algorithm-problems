package leetcode;


/**
 * 原题很蠢，这个用剑指offer 19题替代
 * 同 E19
 */
public class P237 {
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
