package leetcode;

import java.util.Stack;

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

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);

    }

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
