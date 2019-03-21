package leetcode;

/**
 * 判断是否平衡二叉树 任意节点左右子树深度相差不超过1就是平衡二叉树。
 * 同 E62
 */
public class P110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) > -1;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left), right = getHeight(root.right);
        if(Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;
        return Math.max(left + 1, right + 1);
    }
}
