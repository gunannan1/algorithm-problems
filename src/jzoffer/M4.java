package jzoffer;

import java.util.Stack;

/**
 * 逆序操作一个栈，除了递归不用别的数据结构
 */
public class M4 {
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int res=stack.pop();
        if(stack.isEmpty()){
            return res;
        }
        else {
            int last=getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }

    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);


    }


}
