package leetcode;

/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * 二进制中1的个数 同 E16
 */
public class P191 {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask)!= 0) {
                bits++;
            }
            mask<<=1;
        }
        return bits;


    }

//    简单解法
//把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。
// 如 110100 - 1 =110011 ，两个数与一下为 110000，少了一个1 。
//那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }



}
