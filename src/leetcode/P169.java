package leetcode;

/**
 *Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
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
