package jzoffer;

import java.util.Stack;

/**
 * 用一个栈对另一个栈排序
 */
public class M5 {
    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> help=new Stack<>();
        while (!stack.isEmpty()){
            int a=stack.pop();
            //如果弹出的数小于辅助栈的栈顶数，就把辅助栈里的数重新亚回原栈，直到空比他更大，然后把a压入辅助栈
            while (!help.isEmpty()&&a<help.peek()){
                stack.push(help.pop());
            }
            help.push(a);

        }
        //把排完序的压回原来的栈，原栈中顶部为最小的数
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }
}
