package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 *数组中一个数字出现1次，其他数字出现3次，找出那个数字
 * 同 P137
 */
public class E64 {

    //不太好的方法，但容易理解
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
            if (map.get(i) % 3 == 0){
                map.remove(i);
            }
        }
        return (int)map.keySet().toArray()[0];
    }

    public static int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;

    }

}
