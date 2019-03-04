package bishi;

import java.util.Scanner;

public class Q16 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        long max=0;
        long total=0;
        if(num%2==0){
            max=num/2;
        }
        else {
            max=num/2+1;
        }

        for(int i=0;i<max;i++) {
            total+=compute(i+1,num);
        }
        System.out.println(total+1);
    }

    private static long compute(long k,long n){
        long num1=1;
        long num2=1;

        for(int i=1;i<=k;i++){
            num1*=i;
            num2*=n-k+2-i;
        }
        return num2/num1;


    }

}
