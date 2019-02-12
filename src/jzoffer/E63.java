package jzoffer;

/**
 *
 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class E63 {

    public void FindNumsAppearOnce2(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }


    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null ||array.length<2){
            return ;
        }
        int temp = 0;
        for(int i=0;i<array.length;i++){
            temp ^= array[i];
        }
        int indexOf1 = findFirstBitIs(temp);

        for(int i=0;i<array.length;i++){
            if(isBit(array[i], indexOf1)){
                num1[0]^=array[i];
            }
            else {
                num2[0]^=array[i];
            }
        }

    }
    public int findFirstBitIs(int num){
        int indexBit = 0;
        while(((num & 1)==0) && (indexBit)<32){
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    public boolean isBit(int num,int indexBit){
        num = num >> indexBit;
        return (num & 1) == 1;
    }

}
