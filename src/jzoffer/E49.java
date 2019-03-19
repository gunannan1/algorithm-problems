package jzoffer;

/**
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。
 * 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 同 P91（A翻译成1），可以跳过
 */
public class E49 {
    public static int getTranslationCount(int number){
        if(number<0)
            return 0;
        if(number==1)
            return 1;
        return getTranslationCount(Integer.toString(number));
    }
    public static int getTranslationCount(String number) {
        int[] array=new int[number.length()+1];
        array[number.length()]=1;
        array[number.length()-1]=1;
        int g;
        for(int i=number.length()-2;i>=0;i--){
            if(Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))>=26){
                g=0;
            }
            else {
                g=1;
            }
            array[i]=array[i+1]+array[i+2]*g;

        }
        return array[0];
    }
    public static void main(String[] args){
        System.out.println(getTranslationCount(24));  //2
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
    }



}
