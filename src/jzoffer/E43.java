package jzoffer;

/**
 *
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 同 P169（P169这个数必定存在）

 */
public class E43 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length<=0){
            return 0;
        }
        int result = array[0];
        int times = 1;
        for(int i=0;i<array.length;i++){
            if(times==0){
                result = array[i];
                times =1;
            }
            else if(array[i]==result){
                times++;
            }
            else {
                times--;
            }
        }
        int time = 0;
        for(int i=0;i<array.length;++i){
            if(array[i] == result)
                time++;
        }
        if(time*2<=array.length){
            System.out.println(time);
            return 0;
        }
        else{
            return result;
        }

    }
}
