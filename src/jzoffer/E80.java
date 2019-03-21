package jzoffer;

/**
 * 输入两个树节点，求它们的最低公共祖先节点。
 *
 * 二叉查找树同 P235，普通树同 P236

 */
public class E80 {
    //二叉查找树，二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
            return root;
        if(root.val>p.val&&root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }

    //普通树，在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

}
