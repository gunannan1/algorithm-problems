package bishi;

import java.util.Scanner;

/**
 * 牛牛很喜欢对数字进行比较，但是对于3 > 2这种非常睿智的比较不感兴趣。上了高中之后，学习了数字的幂，他十分喜欢这种数字表示方法，比如xy。
 由此，他想出了一种十分奇妙的数字比较方法，给出两个数字x和y，请你比较xy和yx的大小，如果前者大于后者，输出">"，小于则输出"<"，等于则输出"="。


 输入描述:
 两个数字x和y。

 满足1 <= x,y <= 109
 */
public class Q6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        double ab=b*Math.log(a);
        double ba=a*Math.log(b);
        String a="a";
        char c=' ';


        if(ab>ba){
            System.out.println(">");
        }
        else if(ab<ba){
            System.out.println("<");

        }
        else {
            System.out.println("=");

        }

    }
}
