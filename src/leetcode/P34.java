package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * 在排序数组里，找到target的最初和最后出现位置
 */
public class P34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        if(nums==null||nums.length==0){
            return result;
        }
        int len=nums.length;
        int lo=0;
        int hi=len-1;

        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            //如果找到答案了就结束循环
            if(result[0]!=-1&&result[1]!=-1){
                break;
            }
            if(nums[mid]>target){
                hi=mid-1;
            }
            else if(nums[mid]<target){
                lo=mid+1;
            }
            else {
                if(nums[lo]==target){
                    result[0]=lo;
                }
                else {
                    lo++;
                }
                if(nums[hi]==target){
                    result[1]=hi;
                }
                else {
                    hi--;
                }
            }

        }
        return result;


    }

    public static void main(String[] args) {
        int[] a={5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(a,8)));
    }


}
