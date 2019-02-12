package leetcode;

/**
 * 贪婪
 */
public class P55 {
    public boolean canJump(int[] nums) {
        int last=nums.length-1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i+nums[i]>=last){
                last=i;
            }
        }
        return last==0;

    }

}
