package leetcode;

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
