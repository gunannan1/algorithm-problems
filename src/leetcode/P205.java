package leetcode;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 *
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * 字符串同构(同为aba aab ...构型)
 */
public class P205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)) {
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                if(!map.containsValue(b)){
                    map.put(a,b);
                }
                else {
                    return false;
                }

            }
        }
        return true;

    }

    public boolean isIsomorphic2(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
}
