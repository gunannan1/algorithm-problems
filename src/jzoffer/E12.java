package jzoffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

 */
public class E12 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return -1;
        }
        int lo=0;
        int hi=array.length-1;
        while (lo<hi){
            int mid=(lo+hi)/2;
            if(array[mid]>array[hi]){
                lo=mid+1;
            }
            else if(array[mid]<array[hi]){
                hi=mid;
            }
            else {
                hi--;

            }
        }
        return array[lo];
    }








    public static void main(String[] args) {
        E12 e12=new E12();
//        int[] a={3,4,5,6,0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        int[] a={2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,1,2};

        System.out.println(e12.minNumberInRotateArray(a));
    }
}
