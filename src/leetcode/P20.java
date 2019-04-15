package leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true

 各种括号，判断是不是符合定义的
 */

public class P20 {
    public static boolean isValid(String s) {
        Stack<Character> a=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('|s.charAt(i)=='['|s.charAt(i)=='{'){
                a.push(s.charAt(i));
            }
            else{
                if(a.isEmpty()){
                    return false;
                }
                if(s.charAt(i)==')'&&a.pop()!='('){
                    return false;
                }
                if(s.charAt(i)==']'&&a.pop()!='['){
                    return false;
                }
                if(s.charAt(i)=='}'&&a.pop()!='{'){
                    return false;
                }
            }
        }
        return a.isEmpty();
    }

    //好方法
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (char c : s.toCharArray()) {
//            if (c == '(')
//                stack.push(')');
//            else if (c == '{')
//                stack.push('}');
//            else if (c == '[')
//                stack.push(']');
//            else if (stack.isEmpty() || stack.pop() != c)
//                return false;
//        }
//        return stack.isEmpty();
//    }

    public static void main(String[] args) {
        String s="()";
        System.out.println(isValid(s));
        System.out.println();
    }
}
