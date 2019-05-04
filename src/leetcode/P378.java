package leetcode;

import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 *
 * find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * 有序矩阵的第k大元素
 */
public class P378 {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) ->o2-o1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                queue.add(matrix[i][j]);
                if(queue.size()>k){
                    queue.poll();
                }
            }
        }
        return queue.peek();

    }

    //二分解法
    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] a={{1,2},{1,3}};
        int b=kthSmallest(a,1);
        System.out.println(b);

    }

}
