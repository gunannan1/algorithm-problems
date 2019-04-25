package leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: You are not suppose to use the library's sort function for this problem.

 Example:

 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]

 把0，1，2三个数排序（荷兰国旗问题）

 */
public class P75 {
    public void sortColors(int[] nums) {
        int index=0;
        int p0=0;
        int p2=nums.length-1;
        while(index<=p2){
            if(nums[index]==0){
                nums[index]=nums[p0];
                nums[p0]=0;
                p0++;
            }
            if(nums[index]==2){
                nums[index]=nums[p2];
                nums[p2]=2;
                p2--;
                index--;
            }
            index++;
        }

    }

    //另一种方便的做法，遍历一遍统计3个数每个的个数，然后再遍历一遍数组依次写入


}
