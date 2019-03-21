package jzoffer;

import java.util.Stack;

/**
 * 逆序操作一个栈，除了递归不用别的数据结构
 */
public class M4 {
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        //如果最后一个数，就直接返回
        int res=stack.pop();
        if(stack.isEmpty()){
            return res;
        }
        //找到栈中最底的数，然后剩余的数原样压进去
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
        //通过递归，第一次压入最上面的数，最后压入最底层的数，实现逆序
        int i=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);

    }


}
