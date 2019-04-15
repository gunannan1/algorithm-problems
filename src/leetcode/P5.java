package leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"

 最长连续回文串

 */

public class P5 {

    //动态规划
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";

        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }


    //暴力解
    public String longestPalindrome(String s){
        if(s.equals("")){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        int max=0;
        String res=s.substring(0,1);
        for(int i=s.length();i>=0;i--){
            for(int j=0;j<s.length()&&i+j<=s.length();j++){
                String sub=s.substring(j,i+j);
                int count=0;
                for(int k=0;k<sub.length()/2;k++){
                    if(sub.charAt(k)==sub.charAt(sub.length()-1-k)){
                        count++;

                    }
                    else {
                        break;
                    }
                }
                if(count==sub.length()/2&&count>max){
                    max=count;
                    res=sub;
                }


            }
        }
        return res;
    }



    public static void main(String[] args) {
        P5 p5=new P5();
        System.out.println(p5.longestPalindrome("bb"));

    }
}
