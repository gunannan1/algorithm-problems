package bishi;

import java.util.Scanner;

/**
 * 输出描述:

 对于每组数据，输出移位后的字符串。


 输入例子1:
 AkleBiCeilD

 输出例子1:
 kleieilABCD
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        for(int i=0;i<line.length();i++){
            if(Character.isUpperCase(line.charAt(i))){
                s1.append(line.charAt(i));
            }
            else {
                s2.append(line.charAt(i));
            }

        }

        System.out.println(s2.toString()+s1.toString());

    }
}
