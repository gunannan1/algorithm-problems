package leetcode;


/**
 *
 Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class P28 {
    public static int strStr(String haystack, String needle) {
        int l1=haystack.length();
        int l2=needle.length();
        if(l1<l2){
            return -1;
        }
        else if(l2==0){
            return 0;
        }
        else{
            int max=l1-l2;
            for(int i=0;i<=max;i++){
                if(haystack.substring(i,i+l2).equals(needle)){
                    return i;
                }
            }
        }
        return -1;

    }

    /*
    优秀解法
     */
//    public int strStr(String haystack, String needle) {
//        for (int i = 0;; i++) {
//            for (int j = 0;; j++) {
//                if (j == needle.length())
//                    return i;
//                if (i + j == haystack.length())
//                    return -1;
//                if (needle.charAt(j) != haystack.charAt(i + j))
//                    break;
//            }
//        }
//    }

    public static void main(String[] args) {
        String haystack="a";
        String needle="a";
        System.out.println(strStr(haystack,needle));
        System.out.println(haystack.substring(0,1).equals(needle));
    }
}
