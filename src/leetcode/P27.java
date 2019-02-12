package leetcode;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length
 */

public class P27 {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;

    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        P27 b=new P27();
        int c=b.removeElement(a,3);
        System.out.println(Arrays.toString(a));
        System.out.println(c);
    }

}
