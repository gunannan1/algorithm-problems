package sort;

/**
 * 冒泡排序
 *
 很简单，用到的很少，据了解，面试的时候问的比较多！

 将序列中所有元素两两比较，将最大的放在最后面。

 将剩余序列中所有元素两两比较，将最大的放在最后面。

 重复第二步，直到只剩下一个数。

 时间复杂度平均情况O(n²)
 空间复杂度O(1)
 稳定

 */
public class BubbleSort {
    public void bubbleSort(int []a){
        int len=a.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
