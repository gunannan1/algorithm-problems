package jzoffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class E35 {
    public ArrayList<ArrayList<Integer>> printTreeInLine(TreeNode root){
        ArrayList<ArrayList<Integer>> finalList=new ArrayList<>();
        if(root==null){
            return finalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nextPrint=0;
        int nowPrint=1;
        ArrayList<Integer> lineList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            if(treeNode.left!=null){
                queue.add(treeNode.left);
                nextPrint++;
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
                nextPrint++;
            }

            if(nowPrint>0){
                lineList.add(treeNode.val);
                nowPrint--;
            }
            if(nowPrint==0){
                nowPrint=nextPrint;
                nextPrint=0;
                finalList.add(lineList);
                lineList=new ArrayList<>();
            }

        }
        return finalList;
    }
}
