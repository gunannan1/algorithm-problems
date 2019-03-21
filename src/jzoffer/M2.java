package jzoffer;

/**
 给定两个字符串str1和str2, 长度分别M和N,返回两个字符串的最长公共子串
 程序员面试指南 213页
 子串和 M1子序列的区别是，子串要求连续


 */
public class M2 {

    public static int[][] getdp(String str1,String str2){
        int la=str1.length();
        int lb=str2.length();
        char[] str1array=str1.toCharArray();
        char[] str2array=str2.toCharArray();
        //构建数组，找出不同位比较时，所有的连续子串数量
        //如果str1array[i-1]不等于str2array[j-1]，表示把这两个字符当做公共子串最后一个字符是不可能的，直接设为0
        int[][] dp=new int[la+1][lb+1];//防止溢出
        for (int i = 1; i <=la ; i++) {
            for (int j = 1; j <=lb ; j++) {
                if (str1array[i-1]==str2array[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
            }
        }
        return dp;
    }

    public static String lcst1(String str1,String str2){
        if (str1==null||str2==null||str1.equals("")||str2.equals("")){
            return "";
        }
        int[][]dp=getdp(str1,str2);
        int end=0;
        int max=0;

        //遍历数组，end为子串结束位置，max为子串长度，通过这两个值找到具体的公共子串
        for (int i = 1; i <=str1.length() ; i++) {
            for (int j = 1; j <=str2.length() ; j++) {
                if (dp[i][j]>max){
                    end=i;
                    max=dp[i][j];
                }
            }
        }
        return str1.substring(end-max,end);
    }



    public static void main(String[] args) {
        String str1="abcde";
        String str2="bebcd";
        System.out.println(lcst1(str1,str2));
    }




}
