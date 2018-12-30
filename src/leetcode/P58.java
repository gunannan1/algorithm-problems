package leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class P58 {
    public static int lengthOfLastWord(String s) {
        int len=0;
        int spacenum=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)!=' '){
               if(spacenum!=0){
                   spacenum=0;
                   len=0;
               }
               len++;
           }
            else{
               spacenum++;
           }
        }

        return len;

    }

//简单做法
//    public int lengthOfLastWord(String s) {
//        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
//    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" a "));
    }
}
