package jzoffer;

/**
 * 从给定的字符串中找到最长不含重复字符的子字符串，返回该子字符串的长度。
 * 假设字符中只有‘a-z’.例如“asadsfgdf”的最长子字符串是“adsfg ”应该返回 5。
 */
public class E52 {
    public static int lengthOfLongestSubstring(String s) {
        int max=1;
        int len=1;
        int begin=0;
        if(s.equals("")){
            return 0;
        }
        for(int i=1;i<s.length();i++){
            if(!s.substring(begin,i).contains(String.valueOf(s.charAt(i)))){
                len++;
            }
            else{
                begin=begin+s.substring(begin,i).indexOf(String.valueOf(s.charAt(i)))+1;
                len=s.substring(begin,i).length()+1;
            }
            if(len>max){
                max=len;
            }
        }
        return max;

    }
}
