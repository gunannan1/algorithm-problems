package jzoffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。

 */
public class E8 {
    public int Fibonacci(int n) {
        int a=0;
        int b=1;
        int c=0;
        if (n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            for (int i=2;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
            }
        }
        return c;
    }
}
