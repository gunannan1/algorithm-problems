package leetcode;

/**
 *You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 *
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 *
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 *
 * of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * 数组，不能选相邻元素，问所选元素最大值(强盗抢劫)
 */
public class P198 {

//    public int rob(int[] nums) {
//        return rob(nums, nums.length - 1);
//    }
//    private int rob(int[] nums, int i) {
//        if (i < 0) {
//            return 0;
//        }
//        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//    }


    //更好的办法，O(1)空间，O(n)时间
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    //好理解，但空间消耗大
//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        int[] memo = new int[nums.length + 1];
//        memo[0] = 0;
//        memo[1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int val = nums[i];
//            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
//        }
//        return memo[nums.length];
//    }

}
