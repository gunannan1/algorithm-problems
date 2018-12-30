package leetcode;

public class P14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        return prefix;

    }

    public static void main(String[] args) {
        String a="leetcode";
        String b="leets";
        System.out.println(b.indexOf(a));
        while(b.indexOf(a) != 0) {
            a = a.substring(0, a.length() - 1);
            System.out.println(a);
        }

        System.out.println(a);
    }
}
