package questions;

import java.util.Scanner;

/**
 * 有一个长度为N的序列。一开始，这个序列是1, 2, 3,... n - 1, n的一个排列。

 对这个序列，可以进行如下的操作：

 每次选择序列中k个连续的数字，然后用这k个数字中最小的数字替换这k个数字中的每个数字。

 我们希望进行了若干次操作后，序列中的每个数字都相等。请你找出需要操作的最少次数。


 输入描述:
 第一行：两个数字n, k，含义如题，满足2 <= k <= n <= 105；

 第二行：n个数字，是1, 2, 3,...n的一个排列。

 */
public class Q8 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        scanner.nextLine();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=scanner.nextInt();
        }

        if(n<=k){
            System.out.println(1);
        }
        else {
            int temp=((n-k)%(k-1))==0?(n-k)/(k-1):(n-k)/(k-1)+1;
            System.out.println(1+temp);

        }


    }
}
