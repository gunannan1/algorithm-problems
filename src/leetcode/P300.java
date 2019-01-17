package leetcode;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

 最长递增子序列
 普通动态规划O（n²），加上二分查找后O（nlogn）
 */
public class P300 {
    //普通动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=1;
        int res=1;
        for(int i=1;i<nums.length;i++){
            int max=0;
            for(int j=0;j<=i;j++){
                if(nums[i]>nums[j]){
                    max=Math.max(dp[j],max);
                }
            }
            dp[i]=max+1;
            res=Math.max(dp[i],res);
        }
        return res;

    }

    //加上二分查找后
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


}
