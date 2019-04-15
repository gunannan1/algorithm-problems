package leetcode;

import java.util.*;

/**
 *
 Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 在字符串数组中，找到字母相同的字符串，并分组输出
 */
public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String newStr=String.valueOf(c);
            if(!ans.containsKey(newStr)) {
                ans.put(newStr, new ArrayList());
            }
            ans.get(newStr).add(s);

        }
        for (String s:ans.keySet()){
            res.add(ans.get(s));
        }
        return res;

    }


}
