package leetcode;

/**
 * 判断一棵树是不是另一颗的子树
 */
public class P572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        return judge(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);

    }


    public boolean judge(TreeNode s,TreeNode t){
        if(t==null&&s == null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        if(s.val!=t.val){
            return false;
        }
        return judge(s.left,t.left)&&judge(s.right,t.right);
    }

}
