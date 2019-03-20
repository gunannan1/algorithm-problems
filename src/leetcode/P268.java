package leetcode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * array没排序
 *
 *0到n中找到缺少的数字
 * 同 E58


 */
public class P268 {
    public int missingNumber(int[] nums) {
        //因为是递增数组，算出正常来说数组的和
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        //算出现有数组的和
        for (int num : nums) actualSum += num;
        //减一减就是缺少的那个数的值
        return expectedSum - actualSum;
    }

}
