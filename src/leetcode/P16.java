package leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

O(N2)
 找到三个和最接近target的数
 */
public class P16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3) {
            return 0;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int val = 0;
        for(int i=0;i<nums.length-2;i++){
            int lo=i+1;
            int hi=nums.length-1;
            while (lo<hi){
                int sum=nums[lo]+nums[hi]+nums[i];
                if(sum==target){
                    return sum;
                }
                else if(sum>target){
                    if(sum-target<min){
                        min=sum-target;
                        val=sum;
                    }
                    hi--;
                }
                else{
                    if(target-sum<min){
                        min=target-sum;
                        val=sum;
                    }
                    lo++;
                }

            }

        }
        return val;

    }
}
