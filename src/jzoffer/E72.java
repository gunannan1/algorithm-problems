package jzoffer;

/**
 *﻿n个骰子的点数
 把n个骰子扔在地上，所有骰子朝上一面的点数之和为S。输入n，打印出S的所有可能的值出现的概率。
 */
public class E72 {
    public int getNSumCount(int n, int sum){
        if(n<1||sum<n||sum>6*n){
            return 0;
        }
        if(n==1){
            return  1;
        }
        int resCount=0;
        resCount=getNSumCount(n-1,sum-1)+getNSumCount(n-1,sum-2)+
                getNSumCount(n-1,sum-3)+getNSumCount(n-1,sum-4)+
                getNSumCount(n-1,sum-5)+getNSumCount(n-1,sum-6);
        return resCount;
    }
}
