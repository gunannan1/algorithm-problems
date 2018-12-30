package jzoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class E42 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }


    private static void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }
        else {
            for(int j = i; j < chars.length; ++j) {
                if(j == i || chars[j] != chars[i]) {
                    swap(chars,i,j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars,i,j);
                }

            }
        }

    }


    private static void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
