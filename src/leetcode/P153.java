package leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 You may assume no duplicate exists in the array.

翻转数组中最小的数字
 */
public class P153 {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int medium=low+1/2*(high-low);
            if(nums[medium]<=nums[high]){
                high=medium;
            }
            else{
                low=medium+1;
            }
        }
        return nums[low];


    }
}
