package leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.

 二维数组查找
 */
public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int i=row-1;
        int j=0;
        while(i>=0&&j<col){
            if(target>matrix[i][j]){
                j++;
            }
            else if(target<matrix[i][j]){
                i--;
            }
            else{
                return true;
            }

        }
        return false;

    }

}
