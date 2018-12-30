package leetcode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 根据前序遍历和中序遍历重建二叉树
 */
public class P105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reConstructBinaryTree(preorder,inorder,0,inorder.length-1,0,preorder.length-1);

    }

    public TreeNode reConstructBinaryTree(int[] preorder, int[] inorder,int inStart,int inEnd,int preStart,int preEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }

        }

        root.left=reConstructBinaryTree(preorder,inorder,inStart,index-1,preStart+1,preStart+index-inStart);
        root.right=reConstructBinaryTree(preorder,inorder,index+1,inEnd,preStart+index-inStart+1,preEnd);
        return root;

    }

}
