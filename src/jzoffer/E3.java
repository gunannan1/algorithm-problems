package jzoffer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class E3 {
//    public String replaceSpace(StringBuffer str) {
//        if(str==null){
//            return null;
//        }
//        int start=0;
//        int end=0;
//        while(start<str.length()){
//            if(str.charAt(start)!=' '){
//                start++;
//                end++;
//            }
//            else{
//                end++;
//                str.replace(start,end,"%20");
//                start+=3;
//                end=start;
//            }
//        }
//        return str.toString();
//    }

      //不用replace，新开辟一个字符串
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }



    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append(" hello  world ");
        E3 e3=new E3();
        System.out.println(e3.replaceSpace(sb));
    }
}
