package leetcode;

import java.util.Arrays;

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
