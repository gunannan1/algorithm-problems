package leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.
 */
public class P70 {

    //Time complexity : O(n)O(n). Size of recursion tree can go upto nn.
    // Space complexity : O(n)O(n). The depth of recursion tree can go upto nn.
//    public int climbStairs(int n) {
//        int[] memo = new int[n + 1];
//        return climb_Stairs(0, n, memo);
//    }
//
//    public int climb_Stairs(int i, int n, int[] memo) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        if (memo[i] > 0) {
//            return memo[i];
//        }
//        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
//        return memo[i];
//    }

    //Dynamic Programming
//    Time complexity : O(n)O(n). Single loop upto nn.
//    Space complexity : O(n)O(n). dpdp array of size nn is used.
    public int climbStairs(int n) {
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





}
