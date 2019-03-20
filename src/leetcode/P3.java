package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.

 字符串中最长不含重复字符的子字符串 同 E52
 */

public class P3 {
//    public static int lengthOfLongestSubstring(String s) {
//        int max=1;
//        int len=1;
//        int begin=0;
//        if(s.equals("")){
//            return 0;
//        }
//        for(int i=1;i<s.length();i++){
//            if(!s.substring(begin,i).contains(String.valueOf(s.charAt(i)))){
//                len++;
//            }
//            else{
//                begin=begin+s.substring(begin,i).indexOf(String.valueOf(s.charAt(i)))+1;
//                len=s.substring(begin,i).length()+1;
//            }
//            if(len>max){
//                max=len;
//            }
//        }
//        return max;
//
//    }
    public static int lengthOfLongestSubstring(String s) {
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

        public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
