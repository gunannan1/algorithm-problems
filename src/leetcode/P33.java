package leetcode;

public class P33 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <=hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] <nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            else  {
                if (target > nums[mid] && target <=nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return -1;

    }


    public static void main(String[] args) {
        int[] a={4,5,6,7,0,1,2};
        System.out.println(search(a,0));
    }



}
