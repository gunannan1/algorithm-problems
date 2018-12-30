package jzoffer;

/**
 *一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 * 在范围0~n-1内的n个数字中有且只有一个数字不再该数组中，请找出这个数字。
 */
public class E58 {
    public int missingNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>mid){
                high=mid-1;
            }
            else {
                low=mid+1;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        E58 e58=new E58();
        int[] array={0,1,2,3,4,6,7,8};
        System.out.println(e58.missingNumber(array));
    }

}
