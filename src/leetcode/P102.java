package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 层次遍历二叉树
 * 同 E35
 */
public class P102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int length=queue.size();
            List<Integer> sub=new ArrayList<>();
            for (int i=0;i<length;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                sub.add(node.val);
            }
            res.add(sub);
        }
        return res;

    }

}
