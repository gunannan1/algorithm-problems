package jzoffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 同 P21
 */
public class E27 {

    //递归做法，P21为迭代做法
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        else if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }
        else {
            list2.next=Merge(list2.next,list1);
            return list2;
        }


    }

}
