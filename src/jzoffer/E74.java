package jzoffer;

import java.util.LinkedList;

/**
 *﻿0，1，...，n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里剔除第m个数字，求剩下的最后一个数字

 */
public class E74 {
    //时间复杂度On，空间复杂度On
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }
        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }
        return list.get(0);
    }
    //时间复杂度On，空间复杂度O1
    public int LastRemaining_Solution2(int n,int m) {
        if(n==0) return -1;
        int s=0;
        for(int i=2;i<=n;i++){
            s=(s+m)%i;
        }
        return s;
    }

    //时间复杂度Onm，空间复杂度On
    public static int findLastNumber(int n,int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if (i >= n) {
                i = 0;  //模拟环。
            }
            if (array[i] == -1) {
                continue; //跳过被删除的对象。
            }
            step++;                     //记录已走过的。
            if (step == m) {               //找到待删除的对象。
                array[i] = -1;
                step = 0;
                count--;
            }

        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素

    }

}
