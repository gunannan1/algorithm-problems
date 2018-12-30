package jzoffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。

 */

public class E29 {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.right!=null){
            Mirror(root.right);
        }
        if(root.left!=null){
            Mirror(root.left);
        }

    }
}
