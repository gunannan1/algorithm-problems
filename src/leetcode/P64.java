package leetcode;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:

 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */
public class P64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] map=new int[m][n];
        map[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            map[i][0]=map[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            map[0][j]=map[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                map[i][j]=Math.min(map[i-1][j],map[i][j-1])+grid[i][j];

            }
        }
        return map[m-1][n-1];

    }
}
