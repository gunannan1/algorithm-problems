package questions;

import java.util.Scanner;

/**
 * 3
 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。
 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 */
public class Q13 {
    public static int getMaxArea(int[] height) {
        int len = height.length;
        int max = 0;//存储最大面积的
        for(int i = 0;i<len;i++){//i表示依次遍历每一个高度
            int minHeight = height[i];//设i为最小高度
            for(int j=(i+1); j<len; j++){
                minHeight = Math.min(minHeight, height[j]);//找出i之后的最小高度
                max = Math.max(max, (j-i+1)*minHeight);//计算以最小高度为高度的最大面积值
            }
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(getMaxArea(arr));
    }
}
