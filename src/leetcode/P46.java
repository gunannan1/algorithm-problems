package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        findSolution(list, new ArrayList<>(), nums);
        return list;
    }

    private void findSolution(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                findSolution(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
