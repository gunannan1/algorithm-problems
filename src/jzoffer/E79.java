package jzoffer;

/**
 *
 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 输入描述:
 输入一个字符串,包括数字字母符号,可以为空
 输出描述:
 如果是合法的数值表达则返回该数字，否则返回0
 */
public class E79 {

    public static int StrToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        int result = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        }
        else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return 0;
            }
            int sum= result * 10 + (int) (chars[i] - '0');

            //溢出判断
            if((sum-(int) (chars[i] - '0'))/10!=result){
                return 0;

            }
            result=result * 10 + (int) (chars[i] - '0');

        }
        result = (int) Math.pow(-1, symbol) * result;
        return result;

    }

    public static void main(String[] args) {
        System.out.println(StrToInt("123"));

    }
}
