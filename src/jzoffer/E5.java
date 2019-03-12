package jzoffer;

/**
 *
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

 和P105一样
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class E5 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null||pre.length==0||in.length==0){
            return null;
        }

        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree(int[] pre,int pre_start,int pre_end,int[] in,int in_start,int in_end){
        if(pre_start>pre_end||in_start>in_end){
            return null;
        }

        TreeNode root=new TreeNode(pre[pre_start]);
        for(int i=in_start;i<=in_end;i++){
            if(in[i]==pre[pre_start]){
                root.left=reConstructBinaryTree(pre,pre_start+1,pre_start+i-in_start,in,in_start,i-1);
                root.right=reConstructBinaryTree(pre,pre_start+i+1-in_start,pre_end,in,i+1,in_end);
            }
        }
        return root;
    }
}
