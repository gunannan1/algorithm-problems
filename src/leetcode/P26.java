package leetcode;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 去除数组中重复的元素，记录distinct元素的个数

 */
public class P26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,2,3,5};

        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));





    }
}
