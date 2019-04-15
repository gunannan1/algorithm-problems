package leetcode;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 * 在0，1矩阵中找到最大的由1组成的正方形,计算其面积
 *
 */
public class P221 {
    //DP矩阵记录以matrix[i-1][j-1]为右下角1的正方形的长度，这个长度等于其左，上，左上三格的最小值加1
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }

        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        int length=0;
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                    length=Math.max(dp[i][j],length);
                }

            }
        }
        return length*length;

    }

    //空间优化
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
