package leetcode;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:

 Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 Any right parenthesis ')' must have a corresponding left parenthesis '('.
 Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 An empty string is also valid.
 Example 1:
 Input: "()"
 Output: True
 Example 2:
 Input: "(*)"
 Output: True
 Example 3:
 Input: "(*))"
 Output: True
 */
public class P678 {

    public static void main(String[] args) {
        System.out.println(checkValidString1("())"));

    }
    //不加*号的简易版，非leetcode原题
    public static boolean checkValidString1(String s) {
        if(s==null||s.equals("")){
            return false;
        }
        char[] chars=s.toCharArray();
        int num=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]!='('&&chars[i]!=')'){
                return false;
            }
            if(chars[i]==')'&&--num<0){
                return false;
            }
            if(chars[i]!=')'){
                num++;
            }
        }
        return num==0;

    }


    public boolean checkValidString2(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }

    //backtracking
    public boolean checkValidString3(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) return false;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }

        return count == 0;
    }


}
