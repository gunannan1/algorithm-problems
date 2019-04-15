package leetcode;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 找出完全二叉树节点数量
 *
 * 如果最左子树的长度等于最后子树的长度，说明是满二叉树，节点数量等于2的长度次方减去1
 * 如果不满足的话，递归
 */
public class P222 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=leftHeight(root);
        int right=rightHeight(root);
        if(left==right){
            //1<<left 结果为2的left次方
            return (1<<left)-1;
        }
        else {
            return 1+countNodes(root.left)+countNodes(root.right);
        }


    }

    public int rightHeight(TreeNode root){
        int height=1;
        while (root.right!=null){
            height++;
            root=root.right;
        }
        return height;
    }

    public int leftHeight(TreeNode root){
        int height=1;
        while (root.left!=null){
            height++;
            root=root.left;
        }
        return height;
    }




}
