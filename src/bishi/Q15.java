package bishi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        int totalNum=0;
        int[] array=new int[num];
        for(int i=0;i<num;i++){
            array[i]=scanner.nextInt();
        }
        Arrays.sort(array);

        for(int i=0;i<num;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }
            else {
                map.put(array[i],1);
            }
        }

        for(int i=num-1;i>=0;i--){
            int n=map.get(array[i]);
            if(n>0){
                for(Integer key : map.keySet()){
                    map.put(key,map.get(key)-n);
                }
                totalNum+=n;
            }

            else {
                continue;

            }
        }

        System.out.println(totalNum);


    }

}
