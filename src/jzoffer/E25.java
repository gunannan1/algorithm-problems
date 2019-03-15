package jzoffer;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * ﻿第一步判断有没有环，设定一个快指针每次走2步，慢指针每次走一步，如果快指针追上慢指针，则有环。
 第二步找到环中节点数量，从上一步相遇节点出发，看再次回到这个节点走了几步
 第三步找到入口，令快指针先走环中节点数量的步数，慢指针再出发，快慢指针相遇点即为环入口

 时间复杂度 o（n）

 判断有环部分 同P141
 */
public class E25 {


    //    同一思路，简化后的代码
//    第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
//    第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
//    可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。

    public ListNode EntryNodeOfLoop2(ListNode head) {
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


    //判断是否存在环
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


    //找出环的头节点
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



}
