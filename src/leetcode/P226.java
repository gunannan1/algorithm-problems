package leetcode;

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
