package jzoffer;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 与P19相似（删除倒数第k个节点）

 */
public class E24 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }

        //快慢两节点
        ListNode l1=head;
        ListNode l2=head;

        //快节点先移动 k-1步
        for(int i=0;i<k-1;i++){
            if(l1.next!=null){
                l1=l1.next;
            }
            else {
                return null;
            }
        }

        //两个节点再一起走，快节点走到底，慢节点正好在倒数k节点
        while(l1.next!=null){
            l1=l1.next;
            l2=l2.next;
        }

        return l2;

    }
}

