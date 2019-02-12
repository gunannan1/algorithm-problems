package jzoffer;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * ﻿第一步判断有没有环，设定一个快指针每次走2步，慢指针每次走一步，如果快指针追上慢指针，则有环。
 第二步找到环中节点数量，从上一步相遇节点出发，看再次回到这个节点走了几步
 第三步找到入口，令快指针先走环中节点数量的步数，慢指针再出发，快慢指针相遇点即为环入口

 时间复杂度 o（n）
 */
public class E25 {

    //先找到一快一慢两个指针相遇的节点，该节点一定在环中
    public ListNode MeetingNode(ListNode pHead){
        if(pHead==null){
            return null;
        }

        ListNode pSlow=pHead.next;
        if(pSlow==null){
            return null;
        }

        ListNode pFast=pSlow.next;
        while(pSlow!=null&&pFast!=null){
            if(pSlow==pFast){
                return pFast;
            }
            pFast=pFast.next;
            pSlow=pSlow.next;

            if(pFast!=null){
                pFast=pFast.next;
            }
        }
        return null;

    }


    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode meetingNode=MeetingNode(pHead);

        if(meetingNode==null){
            return null;
        }

        //计算环中有多少节点
        int nodeInLoop=1;
        ListNode p1=meetingNode;
        while (p1.next!=meetingNode){
            p1=p1.next;
            nodeInLoop++;
        }

        //移动p1，步数为环中节点的数目
        p1=pHead;
        for(int i=0;i<nodeInLoop;i++) {
            p1 = p1.next;

        }

        //移动p2，
        ListNode p2=pHead;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;

    }

//    同一思路，简化后的代码
//    第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
//    第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
//    可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。

//﻿   ListNode EntryNodeOfLoop(ListNode pHead){
//        if(pHead == null || pHead.next == null)
//            return null;
//        ListNode p1 = pHead;
//        ListNode p2 = pHead;
//        while(p2 != null && p2.next != null ){
//            p1 = p1.next;
//            p2 = p2.next.next;
//            if(p1 == p2){
//                p2 = pHead;
//                while(p1 != p2){
//                    p1 = p1.next;
//                    p2 = p2.next;
//                }
//                if(p1 == p2)
//                    return p1;
//            }
//        }
//        return null;
//    }


}
