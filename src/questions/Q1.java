package questions;

import java.util.Scanner;

/**
 *
 计算字符串最后一个单词的长度，单词以空格隔开。
 输入描述:
 一行字符串，非空，长度小于5000。

 输出描述:
 整数N，最后一个单词的长度。
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] sss=line.split(" ");
        System.out.println(sss[sss.length-1].length());
    }
}
