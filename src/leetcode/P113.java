package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 Note: A leaf is a node with no children.
 找出全部二叉树中和为某一值的路径
 同 E38
 */
public class P113 {
//    List<List<Integer>> paths=new ArrayList<>();
//    List<Integer> path=new ArrayList<>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        if(root==null){
//            return paths;
//        }
//        path.add(root.val);
//        sum-=root.val;
//        if(sum == 0 && root.left == null && root.right == null){
//            paths.add(new ArrayList<Integer>(path));
//        }
//        pathSum(root.left, sum);
//        pathSum(root.right, sum);
//        path.remove(path.size()-1);
//        return paths;
//
//    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths=new ArrayList<>();
        findPath(paths,new ArrayList<>(),root,sum);
        return paths;

    }


    private void findPath( List<List<Integer>> paths,List<Integer> path,TreeNode root, int sum){
        if(root==null){
            return;
        }
        path.add(root.val);
        sum-=root.val;
        if(sum == 0 && root.left == null && root.right == null){
            paths.add(new ArrayList<>(path));
        }
        findPath(paths,path,root.left, sum);
        findPath(paths,path,root.right, sum);
        path.remove(path.size()-1);


    }




}
