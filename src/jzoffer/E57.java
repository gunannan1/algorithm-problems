package jzoffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class E57 {

    //短的写法，不过k+1可能不存在?
    public int GetNumberOfK2(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }


    //比较长
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int first=getFirst(array,k,0,length-1);
        int last=getLast(array,k,0,length-1);
        if(first != -1 && last != -1){
            return last-first+1;
        }
        return 0;

    }


    //递归
    private int getFirst(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid=(start+end)/2;
        if(array[mid] > k){
            return getFirst(array,k,start,mid-1);
        }
        else if(array[mid]<k){
            return getFirst(array, k, mid+1, end);
        }
        else if(mid>=1&&array[mid-1]==k){
            return getFirst(array,k,start,mid-1);
        }
        else {
            return mid;
        }
    }


    //迭代
    private int getLast(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end)/2;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }
            else if(array[mid] < k){
                start = mid+1;
            }
            else if(mid+1 <length && array[mid+1] == k){
                start = mid+1;
            }
            else{
                return mid;
            }
            mid = (start + end)/2;
        }
        return -1;

    }


}
