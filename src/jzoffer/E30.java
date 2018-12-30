package jzoffer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class E30 {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }
        return comRoot(pRoot.left,pRoot.right);

    }

    boolean comRoot(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(right.val!=left.val){
            return false;
        }
        return comRoot(left.left,right.right)&&comRoot(left.right,right.left);

    }


}
