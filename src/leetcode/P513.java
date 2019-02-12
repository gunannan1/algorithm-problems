package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *Given a binary tree, find the leftmost value in the last row of the tree.


 */
public class P513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
