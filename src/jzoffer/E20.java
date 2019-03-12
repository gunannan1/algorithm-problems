package jzoffer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class E20 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return null;
        }

        ListNode first=new ListNode(0);

        first.next=pHead;

        ListNode last=first;
        ListNode node=pHead;
        while (node!=null&&node.next!=null){
            if(node.val==node.next.val){
                int val=node.val;
                while (node!=null&&node.val==val){
                    node=node.next;
                }
                last.next=node;
            }
            else {
                last=node;
                node=node.next;
            }

        }

        return first.next;
    }

    //递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }


}
