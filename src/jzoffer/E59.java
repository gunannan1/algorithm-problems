package jzoffer;

/**
 * 给定一个升序的整数数组A，让你在数组中找到任意下标x，使得A[x] == x。（数组下标从0开始）

 */
public class E59 {
    public int findValueEqualIndex(int[] data)
    {
        if (data == null||data.length==0){
            return -1;
        }
        int low=0;
        int high=data.length-1;
        while (low <= high)
        {
            int mid = (high-low)/2;

            if (data[mid] == mid) {
                return mid;
            }
            else if (data[mid] > mid)  {
                high= mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;

    }


}
