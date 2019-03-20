package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 从给定的字符串中找到最长不含重复字符的子字符串，返回该子字符串的长度。
 * 假设字符中只有‘a-z’.例如“asadsfgdf”的最长子字符串是“adsfg ”应该返回 5。
 * 同 P3
 */
public class E52 {

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


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
