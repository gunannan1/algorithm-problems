package jzoffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class E32 {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    Integer temp=null;
    public void push(int node) {
        if(temp!=null){
            if(node<temp){
                minStack.push(node);
                temp=node;
            }
            stack.push(node);
        }
        else {
            temp=node;
            minStack.push(node);
            stack.push(node);
        }


    }

    public void pop() {
        int num1=stack.pop();
        int num2=minStack.pop();
        if(num1!=num2){
            minStack.push(num2);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();


    }


}
