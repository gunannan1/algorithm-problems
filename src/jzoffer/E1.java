package jzoffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class E1 {
    //占用内存
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i<length;i++){
            if(!hashSet.add(numbers[i])){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;

    }

    //好的解法
//    public boolean duplicate(int numbers[],int length,int [] duplication) {
//        int temp;
//        if(length<=1)
//            return false;
//        for(int i=0;i<length;i++) {
//            while(numbers[i]!=i) {
//                if(numbers[numbers[i]]!=numbers[i]) {
//                    temp=numbers[numbers[i]];
//
//                    numbers[numbers[i]]=numbers[i];
//                    numbers[i]=temp;
//                }
//                else {
//                    duplication[0]=numbers[i];
//                    return true;
//                }
//
//            }
//
//
//        }
//        return false;
//
//    }

}
