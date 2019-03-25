package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.


 给两个用链表表示的数，求他们的和

 */

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode crr=new ListNode(0);
    	int carry=0;
    	ListNode a=crr;
        while (l1 != null || l2 != null) {
        	int x,y;
        	if(l1!=null){
        		 x=l1.val;
        	}else{
        		 x=0;
        	}
        	if(l2!=null){
        		 y=l2.val;
        	}else{
        		 y=0;
        	}
        	crr.next=new ListNode((x+y+carry)%10);
        	crr=crr.next;
          	carry=(x+y+carry)/10;
        	l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        if (carry > 0) {
            crr.next = new ListNode(carry);
        }
        return a.next;
    }
}
