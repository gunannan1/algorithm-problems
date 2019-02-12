package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个。

 在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，

 如果等于，并且前一个元素还未访问，那么就跳过这个元素。

 */
public class P47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visted=new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(new ArrayList<>(),result,visted,nums);
        return result;

    }

    private void backtracking(List<Integer> templist, List<List<Integer>> result, boolean[] visited, final int[] nums) {
        if(templist.size()==nums.length){
            result.add(new ArrayList<>(templist));
        }
        else {
            for(int i = 0; i < nums.length; i++){
                if(i!=0&&nums[i]==nums[i-1]&&!visited[i-1]){
                    continue;
                }
                if(visited[i]){
                    continue;
                }
                visited[i]=true;
                templist.add(nums[i]);
                backtracking(templist,result,visited,nums);
                templist.remove(templist.size()-1);
                visited[i]=false;
            }

        }


    }



}
