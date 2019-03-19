package leetcode;

import java.util.Arrays;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * 排列数字生成最大的数
 *
 * 同 E50（求最小的数字）
 */
public class P179 {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        int len = nums.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str,(o1,o2)->(o2+o1).compareTo(o1+o2));

        if(str[0].equals("0"))
            return "0";

        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();

    }
}
