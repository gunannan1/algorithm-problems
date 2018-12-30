package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempResult=new ArrayList<>();
        Arrays.sort(candidates);
        findSolution(result,tempResult,candidates,target,0);
        return result;

    }

    private void findSolution(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain<0){
            return;
        }
        else if(remain==0){
            list.add(new ArrayList<>(tempList));
        }
        else {
            for(int i=start;i<nums.length&&remain>=nums[i];i++){
                tempList.add(nums[i]);
                findSolution(list,tempList,nums,remain-nums[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }




}
