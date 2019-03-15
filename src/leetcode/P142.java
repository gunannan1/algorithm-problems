package leetcode;

/**
 * 判断链表是否有环，返回环的头节点
 * 同 E25
 */
public class P142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            //快指针与慢指针相遇时,实际快指针比慢指针多走了一个环的步数（假设慢指针没走满一个环）
            //因为快指针走的是慢指针的2倍，所以慢指针走了一个环的步数，等于 从头节点到环入口+环入口到相遇节点
            //这时让快指针重回头节点，头节点到环入口，慢指针从相遇点同时走，正好也走到环入口。所以再次相遇点就是环入口
            if(fast==slow){
                fast=head;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }

        }

        //如果while里出现了null，说明没有环，返回null
        return null;

    }

}
