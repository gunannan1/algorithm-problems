package bishi;

import java.util.Arrays;
import java.util.Scanner;

public class Q23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int[] res=new int[num+1];

        for(int i=0;i<=num;i++){
//            res[i]=Integer.bitCount(i);
            int result=0;
            int j=i;
            while (j!=0){
                result++;
                j=(j-1)&j;
            }
            res[i]=result;
        }
        System.out.print("[");
        for (int k=0;k<num;k++){
            System.out.print(res[k]+",");
        }
        System.out.print(res[num]+"]");



//        System.out.println(Arrays.toString(res));
    }
}
