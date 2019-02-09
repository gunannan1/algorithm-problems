package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a binary search tree (BST) with duplicates,
 *
 * find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.

 没懂，或者可以直接遍历后，再对数组进行统计
 */
public class P501 {
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) curCnt++;
            else curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }
}
