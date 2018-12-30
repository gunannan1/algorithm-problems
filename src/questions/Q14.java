package questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        int n=scanner.nextInt();
        while(n>=1){
            if(n % 2==0){
                list.add("3");
                n=(n-2)/2;
            }
            else {
                list.add("2");
                n=(n-1)/2;
            }
        }

        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i));

        }
    }

}
