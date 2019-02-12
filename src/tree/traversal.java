package tree;

import java.util.*;

public class traversal {
    public void visit(TreeNode node){
        System.out.print(node.val+" ");
    }

    /**
     * 递归先序遍历
     * */
    public void preOrderRecursion(TreeNode node){
        if(node==null) //如果结点为空则返回
            return;
        visit(node);//访问根节点
        preOrderRecursion(node.left);//访问左孩子
        preOrderRecursion(node.right);//访问右孩子
    }


    /**
     * 非递归先序遍历二叉树
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList=new ArrayList<>();
        Stack<TreeNode> treeStack=new Stack<>();
        if(root==null) //如果为空树则返回
            return resultList;
        treeStack.push(root);
        while(!treeStack.isEmpty()){
            TreeNode tempNode=treeStack.pop();
            if(tempNode!=null){
                resultList.add(tempNode.val);//访问根节点
                treeStack.push(tempNode.right); //入栈右孩子
                treeStack.push(tempNode.left);//入栈左孩子
            }
        }
        return resultList;
    }

    /**
     * 递归中序遍历
     * */
    public void inOrderRecursion(TreeNode node){
        if(node==null) //如果结点为空则返回
            return;
        inOrderRecursion(node.left);//访问左孩子
        visit(node);//访问根节点
        inOrderRecursion(node.right);//访问右孩子
    }

    /**
     * 非递归中序遍历
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    /**
     * 递归后序遍历
     * */
    public void postOrderRecursion(TreeNode node){
        if(node==null) //如果结点为空则返回
            return;
        postOrderRecursion(node.left);//访问左孩子
        postOrderRecursion(node.right);//访问右孩子
        visit(node);//访问根节点

    }


    // 非递归后序遍历
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }



    /**
    * 层次遍历二叉树（非递归）
    */
    public void PrintBinaryTreeLayerUnrecur(TreeNode node)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        TreeNode current=node;
        while(!queue.isEmpty())
        {
            current=queue.poll();
            visit(current);
            if (current.left!=null)
                queue.add(current.left);
            if (current.right!=null)
                queue.add(current.right);
        }
    }





}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
    @Override
    public String toString(){
        return "val: "+val;
    }
}