package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class P77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        backtracking(new ArrayList<>(),result,1,k,n);
        return result;

    }

    private void backtracking(List<Integer> tempList, List<List<Integer>> result, int start, int k, final int n) {
        if(k==0){
            result.add(new ArrayList<>(tempList));
        }else {
            for (int i = start; i <= n - k + 1; i++) { // 剪枝 ,也可以i<=n,不过耗时更长
                tempList.add(i);
                backtracking(tempList,result,i+1,k-1,n);
                tempList.remove(tempList.size()-1);
            }
        }

    }




    }
