package jzoffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 最简单的方法：Integer.bitcount 函数
 *
 * 同 P191
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

    //把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。
    // 如 110100 - 1 =110011 ，两个数与一下为 110000，少了一个1 。
    //那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
    public int NumberOf1(int n) {
        int result=0;
        while (n!=0){
            result++;
            n=(n-1)&n;
        }
        return result;

    }



}
