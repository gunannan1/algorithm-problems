package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.

 Each number in candidates may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [10,1,2,7,6,1,5], target = 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 Example 2:

 Input: candidates = [2,5,2,1,2], target = 5,
 A solution set is:
 [
 [1,2,2],
 [5]
 ]
 */
public class P40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), result, 0, target, candidates);
        return result;


    }

    private void backtracking(List<Integer> tempList, List<List<Integer>> result,
                              int start, int target, final int[] candidates) {
        if(target==0){
            result.add(new ArrayList<>(tempList));
        }
        else {
            for(int i=start;i<candidates.length;i++){
                if(i>start&&candidates[i]==candidates[i-1]){
                    continue;
                }
                if(target>=candidates[i]){
                    tempList.add(candidates[i]);
                    backtracking(tempList,result,i+1,target-candidates[i],candidates);
                    tempList.remove(tempList.size()-1);
                }
            }

        }

    }



}
