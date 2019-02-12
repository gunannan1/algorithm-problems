package jzoffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

 */
public class E23 {
//    public void reOrderArray(int [] array) {
//        for(int i=1;i<array.length;i++){
//            if(array[i]%2==1){
//                int target=array[i];
//                int j=i;
//                while(j>0&&array[j-1]%2==0){
//                    array[j] = array[j-1];
//                    j--;
//                }
//                array[j]=target;
//            }
//        }
//
//    }

    public void reOrderArray(int [] array) {
        if(array.length==0||array.length==1) return;
        int oddCount=0;
        int oddBegin=0;
        int[] newArray=new int[array.length];
        for(int i=0;i<array.length;i++){
            if((array[i]%2)==1){
                oddCount++;
            }
        }
        for(int i=0;i<array.length;i++){
            if((array[i]%2)==1){
                newArray[oddBegin]=array[i];
                oddBegin++;
            }
            else{
                newArray[oddCount]=array[i];
                oddCount++;
            }
        }
        for(int i=0;i<array.length;i++){
            array[i]=newArray[i];
        }

    }
}
