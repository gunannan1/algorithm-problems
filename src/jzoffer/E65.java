package jzoffer;

import java.util.ArrayList;

/**
 *
 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

 同 P1
 */
public class E65 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int start=0,end=array.length-1;
        while(start<end){
            if(array[start]+array[end]==sum){
                list.add(array[start]);
                list.add(array[end]);
                return list;
            }
            else if(array[start]+array[end]<sum){
                start++;
            }else {
                end--;
            }
        }
        return list;

    }
}
