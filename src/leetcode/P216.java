package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *Find all possible combinations of k numbers that add up to a number n,
 *
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Note:

 All numbers will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: k = 3, n = 7
 Output: [[1,2,4]]
 Example 2:

 Input: k = 3, n = 9
 Output: [[1,2,6], [1,3,5], [2,3,4]]

 从 1-9 数字中选出 k 个数不重复的数，使得它们的和为 n。

 */
public class P216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result =new ArrayList<>();
        backtracking(k,n,1,new ArrayList<>(),result);
        return result;

    }

    private void backtracking(int k, int n, int start,
                              List<Integer> tempList, List<List<Integer>> result) {
        if(k==0&&n==0){
            result.add(new ArrayList<>(tempList));
        }
        else if(k==0||n==0){
            return;
        }
        else {
            for (int i=start;i<=9;i++){
                tempList.add(i);
                backtracking(k-1,n-i,i+1,tempList,result);
                tempList.remove(tempList.size()-1);
            }
        }


    }

}
