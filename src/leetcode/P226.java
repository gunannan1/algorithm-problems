package leetcode;

/**
 *Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 */
public class P226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.right!=null){
            invertTree(root.right);
        }
        if(root.left!=null){
            invertTree(root.left);
        }
        return root;

    }

    //
//
//    public TreeNode invertTree(TreeNode root) {
//
//        if (root == null) {
//            return null;
//        }
//
//        final TreeNode left = root.left,
//                right = root.right;
//        root.left = invertTree(right);
//        root.right = invertTree(left);
//        return root;
//    }
}
