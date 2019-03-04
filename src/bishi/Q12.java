package bishi;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/b1112516673e463c9ed8943ae96e53f6
 来源：牛客网

 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。

 思想：
 创建一张二维表，本来这张表是用来存储字符A[i]和B[j]是否相等然后将表中(i,j)位置置为1。
 遍历结束后，计算所有的对角线上连续1的个数，取最大值就是结果。但是现在，换种方法，
 遍历的同时，计算当前斜对角的值，然后用一个变量res记录最大的值即可。
 它的公式为：如果A[i - 1] == B[j - 1]，那么dp[i][j] = dp[i - 1][j - 1] + 1;
 其中dp[0][...]和dp[...][0]都是0，这是初始状态。
 */
public class Q12 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.next();
        String s2=scanner.next();

        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();

        int len1=s1.length();
        int len2=s2.length();

        int now=0;
        int max=0;

        for(int i=0;i<Math.min(len1,len2);i++){
            if(c1[i]==c2[i]){
                now++;
            }
            else {
                max=Math.max(now,max);
                now=0;
            }
        }
        max=Math.max(now,max);
        System.out.println(max);

    }

}

