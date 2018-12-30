package questions;

import java.util.Scanner;

/**
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，
 * 点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 *
 * 这里做法有误，应该是变态跳台阶问题，误认为最大点数是6，但答案对
 */
public class Q10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(findStep(n));


    }
    private static int findStep(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return findStep(n-1)+findStep(n-2)+findStep(n-3)+findStep(n-4)+findStep(n-5)+findStep(n-6);
    }
}
