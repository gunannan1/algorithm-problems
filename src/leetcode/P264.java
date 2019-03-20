package leetcode;

import java.util.ArrayList;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * 找到第n个丑数 同 E53
 */
public class P264 {

    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        ArrayList<Integer> result=new ArrayList<>();
        result.add(1);
        int i2=0;
        int i3=0;
        int i5=0;
        while (result.size()<index){
            int m2=result.get(i2)*2;
            int m3=result.get(i3)*3;
            int m5=result.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            result.add(min);
            if(min==m2){
                i2++;
            }
            if(min==m3){
                i3++;
            }
            if(min==m5){
                i5++;
            }
        }
        return result.get(index-1);


    }
}
