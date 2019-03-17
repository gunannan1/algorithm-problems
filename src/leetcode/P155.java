package leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * 最小栈
 * 同 E32
 */
public class P155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

}
class MinStack {
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        min=Integer.MAX_VALUE;

    }

    //如果x小于min，则先把min压进去，再压入x
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);

    }

    //弹出的时候，先弹出最小值，之后再弹出第二小的，赋值给min
    public void pop() {
        if(stack.pop() == min) {
            min=stack.pop();
        }

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min;

    }
}
