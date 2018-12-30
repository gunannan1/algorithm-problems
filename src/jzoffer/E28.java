package jzoffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

 */
public class E28 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1!=null&&root2!=null){
            //如果root1的值和root2相同，则从这个点开始匹配
            if(root1.val==root2.val){
                result=doesTree1HaveTree2(root1,root2);
            }
            //如果root不对应，则从左右子树按顺序匹配
            if(!result){
                result=HasSubtree(root1.right,root2);
            }
            if(!result){
                result=HasSubtree(root1.left,root2);
            }
        }
        return result;


    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if(node2==null&&node1==null){
            return true;
        }
        //1先遍历完的话，则不是
        if(node1==null||node2==null){
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        //根节点对应的话，匹配子节点
        return doesTree1HaveTree2(node1.left,node2.left)&&doesTree1HaveTree2(node1.right,node2.right);
    }
}
