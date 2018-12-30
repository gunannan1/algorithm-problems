package jzoffer;

import java.util.Stack;

/**
 * 给定一颗二叉搜索树，请找出其中的第k小的结点
 */
public class E60 {
    int index=0;
//    TreeNode KthNode(TreeNode pRoot, int k) {
//        if(pRoot!=null){
//            TreeNode node=KthNode(pRoot.left,k);
//            if(node!=null){
//                return node;
//            }
//            index++;
//            if(index==k){
//                return pRoot;
//            }
//            node = KthNode(pRoot.right,k);
//            if(node != null){
//                return node;
//            }
//
//        }
//        return null;
//
//    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null||k<=0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node=pRoot;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            TreeNode node2 = stack.pop();
            index++;
            if(index==k){
                return node2;
            }
            node=node2.right;
        }
        return null;
    }


}
