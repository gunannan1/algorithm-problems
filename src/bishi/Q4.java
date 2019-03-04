package bishi;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            int d=in.nextInt();

            StringBuilder v1S=new StringBuilder();
            StringBuilder v2S=new StringBuilder();


            for(int i=0;i<b;i++){
                v1S.append(a);
            }
            for(int i=0;i<d;i++){
                v2S.append(c);
            }
        String v1=v1S.toString();
        String v2=v2S.toString();

        if(v1.length()>v2.length()){
            System.out.println("Greater");
        }
        else if(v2.length()>v1.length()){
            System.out.println("Less");

        }
        else {
            if(v1.compareTo(v2)>0){
                System.out.println("Greater");
            }
            else if(v1.compareTo(v2)<0){
                System.out.println("Less");

            }
            else {
                System.out.println("Equal");

            }
        }






    }
}
