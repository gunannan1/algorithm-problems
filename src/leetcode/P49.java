package leetcode;

import java.util.*;

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

    public static void main(String[] args) {


    }

}
