package sort;

/**
 * 插入排序，
 *
 *
 直接插入排序（Straight Insertion Sorting）的基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，

 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。

 代码实现：

 首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。

 设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。

 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。

 将当前数放置到空着的位置，即j+1。


 时间复杂度O(n²),(最好情况O(n),最坏情况O(n²))
 空间复杂度O(1)
 稳定

 */
public class InsertionSort {
    public void insertSort(int[] a){
        int length=a.length;//数组长度，将这个提取出来是为了提高速度。
        int insertNum;//要插入的数
        for(int i=1;i<length;i++){//插入的次数
            insertNum=a[i];//要插入的数
            int j=i-1;//已经排序好的序列元素个数
            while(j>=0&&a[j]>insertNum){//序列从后到前循环，将大于insertNum的数向后移动一格
                a[j+1]=a[j];//元素移动一格
                j--;
            }
            a[j+1]=insertNum;//将需要插入的数放在要插入的位置。
        }
    }


}
