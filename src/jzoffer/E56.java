package jzoffer;


import java.util.HashMap;


/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class E56 {
//    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        ListNode l1=pHead1;
//        ListNode l2=pHead2;
//
//        HashMap<ListNode,Integer> hashMapMap=new HashMap<>();
//
//        while (l1!=null){
//            hashMapMap.put(l1,null);
//            l1=l1.next;
//        }
//        while (l2!=null){
//            if(hashMapMap.containsKey(l2)){
//                return l2;
//            }
//            l2=l2.next;
//        }
//        return null;
//    }


    //设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
    //当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
    // 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
    // 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1=pHead1;
        ListNode l2=pHead2;

        int h1= getLength(l1);
        int h2=getLength(l2);

        if(h1>h2){
            int h=h1-h2;
            while (h>0){
                l1=l1.next;
                h--;
            }
        }
        else if(h1<h2){
            int h=h2-h1;
            while (h>0){
                l2=l2.next;
                h--;
            }
        }

        while (l1!=l2){
            l1=l1.next;
            l2=l2.next;
        }


        return l1;
    }

    public static int getLength(ListNode listNode){
        int length=0;
        ListNode l =listNode;
        while (l!=null){
            length++;
            l=l.next;
        }
        return length;

    }




}
