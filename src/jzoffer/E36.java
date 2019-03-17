package jzoffer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 同 P103
 */
public class E36 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> finalResult=new ArrayList<>();
        if(pRoot==null){
            return finalResult;
        }

        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        int layer=1;

        s1.push(pRoot);

        while (!s1.isEmpty()||!s2.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            if(layer%2!=0){
                while (!s1.isEmpty()){
                    TreeNode treeNode=s1.pop();
                    temp.add(treeNode.val);
                    if(treeNode.left!=null){
                        s2.push(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        s2.push(treeNode.right);
                    }
                }
            }
            else {
                while (!s2.isEmpty()){
                    TreeNode treeNode=s2.pop();
                    temp.add(treeNode.val);
                    if(treeNode.right!=null){
                        s1.push(treeNode.right);
                    }
                    if(treeNode.left!=null){
                        s1.push(treeNode.left);
                    }
                }
            }
            if(!temp.isEmpty()){
                finalResult.add(temp);
                layer++;
            }

        }
        return finalResult;

    }

}
