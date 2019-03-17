package jzoffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 同 P155
 */
public class E32 {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    Integer temp=null;

    public void push(int node) {
        //如果temp已经有值了，当node是最小值时，把node压入min，temp赋值为最小值。同时node压入stack
        if(temp!=null){
            if(node<temp){
                minStack.push(node);
                temp=node;
            }
            stack.push(node);
        }
        //第一次压入时，node同时压入min和stack
        else {
            temp=node;
            minStack.push(node);
            stack.push(node);
        }


    }

    //min和stack同时弹出最上面元素，如果stack里不是最小数，就把min栈的数又放回去
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
