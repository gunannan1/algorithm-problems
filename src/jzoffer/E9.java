package jzoffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 等同于P70
 */
public class E9 {
    public int JumpFloor(int target) {
        if(target<2){
            return target;
        }
        else{
            int a=0;
            int b=1;
            int c=0;
            for (int i=1;i<=target;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }
    }

    //动态规划
    public int JumpFloor2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        E9 e9=new E9();
        System.out.println(e9.JumpFloor(2));
    }
}
