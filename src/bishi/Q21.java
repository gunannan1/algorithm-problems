package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/5d314ef72996433da302d46df12ceb9f
 * 来源：牛客网
 *
 * 最近天气太热了，牛牛每天都要吃雪糕。雪糕有一盒一份、一盒两份、一盒三份这三种包装，牛牛一天可以吃多盒雪糕，但是只能吃六份，
 * 吃多了就会肚子疼，吃少了就会中暑。而且贪吃的牛牛一旦打开一盒雪糕，就一定会把它吃完。请问牛牛能健康地度过这段高温期么？
 * 输入描述:
 * 每个输入包含多个测试用例。
 * 输入的第一行包括一个正整数，表示数据组数T(1<=T<=100)。
 * 接下来N行，每行包含四个正整数，表示高温期持续的天数N(1<=N<=10000)，一盒一份包装的雪糕数量A(1<=A<=100000)，
 * 一盒两份包装的雪糕数量B(1<=B<=100000)，一盒三份包装的雪糕数量C(1<=A<=100000)。
 *
 *
 * 输出描述:
 * 对于每个用例，在单独的一行中输出结果。如果牛牛可以健康地度过高温期则输出"Yes"，否则输出"No"。
 *
 *
 * 输入
 * 4
 * 1 1 1 1
 * 2 0 0 4
 * 3 0 2 5
 * 4 24 0 0
 * 输出
 * Yes
 * Yes
 * No
 * Yes
 */
public class Q21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int ans = C/2;
            if(C%2==1){
                if(A>=1&&B>=1){
                    A--;
                    B--;
                    ans++;
                }
                else{
                    if(A>=3){
                        A=A-3;
                        ans++;
                    }
                }
            }

            ans=ans+A/6;
            ans=ans+B/3;
            if(B%3*2+A%6>=6){
                ans++;
            }
            if(ans>=N){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }

        }

    }



}
