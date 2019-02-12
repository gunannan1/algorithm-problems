package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。

 输入例子1:
 6
 45 12 45 32 5 6

 输出例子1:
 1 2


 */
public class Q2 {
    public static int getLow(int[] array){
        Arrays.sort(array);
        int min=Integer.MAX_VALUE;
        int num=0;
        for(int i=0;i<array.length-1;i++){
            int temp=array[i+1]-array[i];
            if(temp<min){
                min=temp;
                num=1;
            }else if(temp==min){
                num++;
            }
            if(min==0){
                break;
            }
        }
        if(min==0){
            num=0;
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<array.length;j++){
                if(map.containsKey(array[j])){
                    map.put(array[j],map.get(array[j])+1);
                }
                else {
                    map.put(array[j],1);
                }
            }
            for(Integer key:map.keySet()){
                int val = map.get(key);
                System.out.println(val);
                if(val>1){
                    num+= (val * (val-1))/2;
                }

            }
        }

        return num;

    }

    public static int getHigh(int[] array){
        int high=0;
        int low=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==array[0]){
                low++;
            }
            else {
                break;
            }
        }
        for(int i=array.length-1;i>=0;i--){
            if(array[i]==array[array.length-1]){
                high++;
            }
            else {
                break;
            }
        }
        return high*low;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arrary = new int[n];
            for (int i = 0; i < n; i++) {
                arrary[i] = sc.nextInt();
            }
            System.out.println(getLow(arrary));
            System.out.println(getHigh(arrary));
        }


    }
}
