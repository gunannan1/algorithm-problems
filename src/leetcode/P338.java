package leetcode;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number
 *
 * of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * 统计从 0 ~ n 每个数的二进制表示中 1 的个数
 *
 * An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
 */
public class P338 {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1; i <= num; i++){
            ret[i] = ret[i&(i-1)] + 1;
        }
        return ret;
    }

    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }


}
