package leetcode;


import java.util.Arrays;

/**
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf,

 but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 找出全部二叉树中和为某一值得路径(不一定以root开头叶子结尾)


 */
public class P437 {

    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }

        return findPath(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);

    }

    private int findPath(TreeNode root,int sum){
        int res=0;
        if(root==null){
            return 0;
        }
        if(sum==root.val){
            res++;
        }
        res+=findPath(root.left,sum - root.val);
        res+=findPath(root.right,sum - root.val);
        return res;

    }
}
