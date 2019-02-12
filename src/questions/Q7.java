package questions;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 一般的括号匹配问题是这样的：

 给出一个字符串，判断这个括号匹配是不是合法的括号匹配。

 如"((" 和 "())"都不是合法的括号匹配，但是"()()()"，"(()())()"等就是合法的括号匹配。

 这个问题解决起来非常简单，相信大家都知道怎么解决。

 现在给出一个加强版的括号匹配问题： 给出n个由括号 '(' 和 ‘)’ 组成的字符串，请计算出这些字符串中有多少对字符串满足si + sj是合法的括号匹配。如果si + sj和sj + si都是合法的括号匹配(i ≠ j)，那么这两种搭配都需要计入答案；如果对于si，si + si是合法的括号匹配，那么也需要计入答案。


 输入描述:
 第一行是一个整数n，表示字符串的个数；

 接下来n行是n个非空字符串，全部由'('和')'组成。

 1 <= n <= 3 * 105，字符串的长度之和不超过3 * 105。



 输出描述:
 一个整数，表示满足条件的字符串对的数量。
 */
public class Q7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int result=0;
        int len=scanner.nextInt();
        int[] a=new int[len];
        scanner.nextLine();
        for(int i=0;i<len;i++){
            String temp=scanner.nextLine();
            int score=0;
            for(char c:temp.toCharArray()){
                if(temp.toCharArray()[0]==')'&&temp.toCharArray()[temp.length()-1]=='('){
                    score= Integer.MIN_VALUE;
                    break;
                }
                if(c=='('){
                    score++;
                }
                else {
                    score--;
                }
            }
            a[i]=score;
        }
        Arrays.sort(a);

//        for(int i=0;i<len;i++){
//            if(a[i]==0){
//                result++;
//            }
//            for(int j=0;j<len;j++){
//                if(a[i]+a[j]==0&&a[i]>=0&&a[j]<=0&&j!=i){
//                    result++;
//                }
//            }
//        }
        int zero=0;
        for(int i=0;i<len;i++){
            if(a[i]==0){
                zero++;
                continue;
            }
            if(a[i]<0){
                continue;
            }
            for(int j=0;j<len;j++){
                if(a[i]+a[j]==0){
                    result++;
                }
            }
        }
        result+=zero+zero*(zero-1);


        System.out.println(result);


    }
}
