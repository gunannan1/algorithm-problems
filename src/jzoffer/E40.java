package jzoffer;

/**
 *
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

 类似P114，不过P114二叉树不是搜索树
 */
public class E40 {
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return;
        }
        //递归左子树，找到最小的点，即头节点
        ConvertSub(pRootOfTree.left);
        if(head==null){
            head=pRootOfTree;
            realHead=pRootOfTree;
        }
        else {
            head.right=pRootOfTree;
            pRootOfTree.left=head;
            head=pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }


}
