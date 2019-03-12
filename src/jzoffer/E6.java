package jzoffer;


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}


/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 如果一个节点有右子树，下个节点是右子树的最左子节点。
 * 如果没右子树，如果这个节点是父节点的左子节点，那么下个节点是父节点。
 * 如果不是，那么沿着父节点向上遍历，找到一个是它父节点左子节点的节点。这个节点的父节点是我们想要的。
 * 复杂度最坏o（logn），最好应该是o（1）
 */
public class E6 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null){
            return null;
        }
        else if(pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        else{
            while (pNode.next!=null){
                if(pNode.next.left==pNode){
                    return pNode.next;
                }
                pNode=pNode.next;

            }
            return null;
        }
    }
}
