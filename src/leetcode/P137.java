package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 数组中一个数字出现1次，其他数字出现3次，找出那个数字
 *
 * 同 E64
 */
public class P137 {

    //难理解
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }

    //容易理解
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
            if (map.get(i) % 3 == 0){
                map.remove(i);
            }
        }
        return (int)map.keySet().toArray()[0];
    }
}
