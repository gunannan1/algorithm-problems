package jzoffer;

/**
 * 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 *
 * 和 P343 一样
 */
public class E15 {

    public int maxAfterCutting(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                //不确定dp[X]和x哪个大
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }


//    public int maxAfterCutting(int length){
//        if(length<2)
//            return 0;
//        if(length==2)
//            return 1;
//        if(length==3)
//            return 2;
//        int[] f=new int[length+1];
//        f[0]=0;
//        f[1]=1;
//        f[2]=2;
//        f[3]=3;
//        int result = 0;
//        for(int i = 4;i<=length;i++){
//            int max = 0;
//            for(int j = 1;j<=i/2;j++){
//                int num = f[j]*f[i-j];
//                if(max<num)
//                    max = num;
//                f[i] = max;
//            }
//        }
//        result = f[length];
//        return result;
//
//    }




}
