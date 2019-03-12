package jzoffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 复杂度O（m+n），也可以对每一行/列来一次二分查找，复杂度nlogn

 和P240一样
 */
public class E2 {
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length==0||array[0].length==0){
            return false;
        }
        int row=0;
        int column=array[0].length-1;
        while(row<=array.length-1&&column>=0){
            if(array[row][column]==target){
                return true;
            }
            else if(array[row][column]<target){
                row++;
            }
            else{
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] b={};
        E2 e=new E2();
        System.out.println(e.Find(7,b));

    }
}
