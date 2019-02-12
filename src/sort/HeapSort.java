package sort;

import java.util.Arrays;

/**
 * 堆排序
 * 对简单选择排序的优化。

 将序列构建成大顶堆。

 将根节点与最后一个节点交换，然后断开最后一个节点。

 重复第一、二步，直到所有节点断开。


 堆排序的方法：首先，将当前的数组调整为堆，也就是建立堆。
 然后把根与最后的元素交换，重新调整堆，然后再把调整后的根与倒数第二个元素交换，再重新调整堆，直到全部元素交换完毕。
 这样，对于大根堆，最大元素排列到了最后，是递增排序。而小根堆，最小元素排列到了最后，是递减排序。

 建堆的时间复杂度 O(n) 调整堆的时间复杂度 O(logn)


 各种情况时间复杂度都是O(nlogn)
 空间复杂度O(1)
 不稳定

 */
public class HeapSort {
    public void heapSort(int[] array){
        //建立一个最大堆
        buildHeap(array, array.length-1);
        //从最后一个元素开始对序列进行调整
        for (int i =array.length - 1; i > 0; i--){
            //交换堆顶元素array[0]和堆中最后一个元素
            swap(array,0,i);
            //每次交换堆顶元素和堆中最后一个元素之后，都要对堆进行调整
            HeapAdjust(array,0,i-1);
        }
    }

    //交换方法
    private void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }

    //第一次建堆,最大值在堆顶
    private void buildHeap(int[] array, int last) {
        //从最后一个节点的父节点开始
        for (int i = (last - 1) / 2; i >= 0; i--){
            HeapAdjust(array, i, last);
        }
    }


    private void HeapAdjust(int[] array,int root, int last){
        //当前根节点的左子节点的位置
        int child=2*root+1;
        while (child<=last){
            //如果根节点的右子节点存在且值大于左子节点
            if(child+1<=last&&array[child]<array[child+1]){
                //记录当前较大的子节点
                child++;
            }
            //如果子节点的值大于父节点
            if(array[child]>array[root]){
                //交换父子节点位置，把较大的值赋予父节点
                swap(array,child,root);
                //重新设置下个待调整节点的位置
                root=child;
                child=2*child+1;
            }
            //如果父节点比左右孩子都大，不用调整，直接退出
            else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        HeapSort hs=new HeapSort();
        int[] array={49,38,65,97,76,13,27,49,78,34,12,64,1,42,52,133,23,467,23,34};
        int[] array2={3,1,5,7,2,4,9,6,10,8};

        hs.heapSort(array);
        hs.heapSort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));


    }





}
