package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    //滑动窗口优化版
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

    //滑动窗口，好理解点，最坏情况O（2n）
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


        public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
