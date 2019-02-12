package jzoffer;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}



public class E4 {


    ArrayList<Integer> result =new ArrayList<>();

    //递归解法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return result;
        }
        else{
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;

    }


}
