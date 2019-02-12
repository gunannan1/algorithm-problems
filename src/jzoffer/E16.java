package jzoffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class E16 {
    //普通解法
//    public int NumberOf1(int n) {
//        int result=0;
//        int flag=1;
//        while (flag!=0){
//            if((n&flag)!=0){
//                result++;
//            }
//            flag=flag<<1;
//        }
//        return result;
//
//    }

    public int NumberOf1(int n) {
        int result=0;
        while (n!=0){
            result++;
            n=(n-1)&n;
        }
        return result;

    }



}
