package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  滑动窗口最大值，同 E69
 */
public class P239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0||nums.length==0){
            return new int[0];
        }

        //最大堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1, o2) -> o2-o1);
        int[] res=new int[nums.length-k+1];

        //
        for(int i=0;i<k;i++){
            maxHeap.add(nums[i]);
        }
        res[0]=maxHeap.peek();

        for(int i=k;i<nums.length;i++){
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
            res[i-k+1]=maxHeap.peek();
        }
        return res;

    }

    public static void main(String[] args) {
        P239 p=new P239();
        int[] a={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(p.maxSlidingWindow(a,3)));
    }

}
