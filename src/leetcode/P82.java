package leetcode;

/**
 * 同E20
 */
public class P82 {
    public ListNode deleteDuplicates(ListNode pHead) {
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
}
