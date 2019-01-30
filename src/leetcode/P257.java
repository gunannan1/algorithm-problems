package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 Note: A leaf is a node with no children.

 Example:

 Input:

 1
 /   \
 2     3
 \
 5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3

 */
public class P257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root!=null){
            construct_paths(root,"",res);
        }

        return res;


    }

    private void construct_paths(TreeNode root, String path, List<String> res) {
        if(root!=null){
            path+=root.val;
            if(root.left==null&&root.right==null){
                res.add(path);
            }
            else {
                path += "->";
                construct_paths(root.left, path, res);
                construct_paths(root.right, path, res);

            }
        }

    }

}
