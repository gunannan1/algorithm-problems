package leetcode;

/**
 *
 Given an array of numbers nums, in which exactly two elements appear only once and all the other

 elements appear exactly twice. Find the two elements that appear only once.

 Example:

 Input:  [1,2,1,3,2,5]
 Output: [3,5]

 两个不相等的元素在位级表示上必定会有一位存在不同。

 将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。

 diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
 利用这一位就可以将两个元素区分开来。
 */
public class P260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^= num;
        diff &= -diff;  // 得到最右一位
        int[] ret = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) ret[0] ^= num;
            else ret[1] ^= num;
        }
        return ret;
    }
}
