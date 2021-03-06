package jzoffer;

/**
 * ﻿输入一棵二叉树，判断该二叉树是否是平衡二叉树。任意节点左右子树深度相差不超过1就是平衡二叉树。
 * 同 P110
 */
public class E62 {


    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    //----------------------------------------------------------------
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution2(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }


    //    public int TreeDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int left=TreeDepth(root.left);
//        int right=TreeDepth(root.right);
//        return Math.max(left, right) + 1;
//    }
//
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//
//        int left=TreeDepth(root.left);
//        int right=TreeDepth(root.right);
//        int diff=left-right;
//        if(diff>1||diff<-1){
//            return false;
//        }
//
//        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
//
//    }
}