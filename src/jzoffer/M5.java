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
            while (!help.isEmpty()&&a<help.peek()){
                stack.push(help.pop());
            }
            help.push(a);

        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }
}
