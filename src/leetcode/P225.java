package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 */
public class P225 {

}

class MyStack {
    private Queue<Integer> q = new LinkedList<Integer>();

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
            q.add(q.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();


    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}