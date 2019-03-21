package jzoffer;

/**
 * 例如，“student. a am I”。
 * 正确的句子应该是“I am a student.”。
 *
 * 同 P151
 */
public class E67 {
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();

        //先反转每个字符
        reverse(chars,0,chars.length - 1);
        int blank = -1;
        //然后遍历反转后的字符串，遇到空格表示这是单词分界线，分别反转每个单词
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行反转
        return new String(chars);
    }

    public void reverse(char[] chars,int low,int high){
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

}
