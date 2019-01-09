package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 要求时间最快时。

 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。

 递归的将p左边和右边的数都按照第一步进行，直到不能递归。

 时间复杂度 平均和最好情况O(nlogn),最坏情况O(n²)，对于已经排完序的数组
 空间复杂度O（logn）
 不稳定

 */
public class QuickSort {
    //分开写


    public static void quickSort(int[] n, int l, int h) {
        if (n == null || n.length == 0)
            return;
        if (l < h) {
            int pivot = partition(n, l, h);
            quickSort(n, l, pivot - 1);
            quickSort(n, pivot + 1, h);
        }
    }

    private static int partition(int[] n, int start, int end) {
        int tmp;
        int val=n[start];
        int p=start;
        while (start < end) {
            while (n[end] >= val && start < end){
                end--;
            }
            while (n[start] <= val && start < end){
                start++;
            }
            tmp=n[end];
            n[end]=n[start];
            n[start]=tmp;

        }
        tmp=n[start];
        n[start]=val;
        n[p]=tmp;
        return start;
    }


    public static void main(String[] args) {
        int[] a={3,10,6,2,8,7,0,4,12,43,2,1};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }


//    //合在一起
//    public void quickSort(int[]a,int start,int end){
//        if(start<end){
//            int baseNum=a[start];//选基准值
//            int midNum;//记录中间值
//            int i=start;
//            int j=end;
//            do{
//                while((a[i]<baseNum)&&i<end){
//                    i++;
//                }
//                while((a[j]>baseNum)&&j>start){
//                    j--;
//                }
//                if(i<=j){
//                    midNum=a[i];
//                    a[i]=a[j];
//                    a[j]=midNum;
//                    i++;
//                    j--;
//                }
//            }while(i<=j);
//            if(start<j){
//                quickSort(a,start,j);
//            }
//            if(end>i){
//                quickSort(a,i,end);
//            }
//        }
//    }
}
