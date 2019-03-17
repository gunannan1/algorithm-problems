package jzoffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 同 P946

 */
public class E33 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0){
            return false;
        }
        Stack<Integer> stack=new Stack<>();
        int popIndex=0;

        //按压入顺序压入，然后判断能否按弹出顺序弹出。如果最后全部弹出，栈为空，则返回true。
        for(int i = 0; i< pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty()&&stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }

        }
        return stack.isEmpty();

    }

}
