package leetcode;

/**
 *Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 数组中出现次数超过一半的数字（这个数一定存在），同 E43（E43中此数不一定存在，需要二次判断）
 */
public class P169 {
    public int majorityElement(int[] nums) {
        int len=nums.length;
        int element=Integer.MAX_VALUE;
        int count=0;
        for(int i=0;i<len;i++){
            if(count==0){
                element=nums[i];
                count=1;
            }
            else if(element!=nums[i]){
                count--;
                if(count==0){
                    element=Integer.MAX_VALUE;
                }

            }
            else {
                count++;
            }

        }
        return element;

    }

}
