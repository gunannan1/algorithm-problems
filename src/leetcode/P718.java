package leetcode;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

 Example 1:
 Input:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 Output: 3
 Explanation:
 The repeated subarray with maximum length is [3, 2, 1].



 answer：
 Since a common subarray of A and B must start at some A[i] and B[j], let dp[i][j] be the longest common prefix of A[i:] and B[j:].
 Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1. Also, the answer is max(dp[i][j]) over all i, j.

 We can perform bottom-up dynamic programming to find the answer based on this recurrence.
 Our loop invariant is that the answer is already calculated correctly and stored in dp for any larger i, j.
 */
public class P718 {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        //以A[i] 和 B[j] 作为公共子数组的开头
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) {
                        ans = memo[i][j];
                    }
                }
            }
        }
        return ans;

    }
}
