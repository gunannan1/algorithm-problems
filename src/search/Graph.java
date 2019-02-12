package search;


import java.util.*;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
//    private int number = 9;
//    private boolean[] flag;
//    private String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
//    private int[][] edges = {
//            { 0, 1, 0, 0, 0, 1, 1, 0, 0 },
//            { 1, 0, 1, 0, 0, 0, 1, 0, 1 },
//            { 0, 1, 0, 1, 0, 0, 0, 0, 1 },
//            { 0, 0, 1, 0, 1, 0, 1, 1, 1 },
//            { 0, 0, 0, 1, 0, 1, 0, 1, 0 },
//            { 1, 0, 0, 0, 1, 0, 1, 0, 0 },
//            { 0, 1, 0, 1, 0, 1, 0, 1, 0 },
//            { 0, 0, 0, 1, 1, 0, 1, 0, 0 },
//            { 0, 1, 1, 1, 0, 0, 0, 0, 0 }
//    };
//

    //广度优先迭代
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> lists=new ArrayList<Integer>();
        if(root==null)
            return lists;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tree=queue.poll();
            if(tree.left!=null)
                queue.offer(tree.left);
            if(tree.right!=null)
                queue.offer(tree.right);
            lists.add(tree.val);
        }
        return lists;
    }

    //深度优先迭代，深度优先递归等于前序遍历递归
    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> lists=new ArrayList<Integer>();
        if(root==null)
            return lists;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tree=stack.pop();
            if(tree.right!=null)
                stack.push(tree.right);
            if(tree.left!=null)
                stack.push(tree.left);
            lists.add(tree.val);
        }
        return lists;
    }




    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
//        Graph graph = new Graph();
//        System.out.println("DFS递归:");
//        graph.DFSTraverse();
//        System.out.println();
//        System.out.println("DFS非递归:");
//        graph.DFS_Map();
//        System.out.println();
//        System.out.println("BFS非递归:");
//        graph.BFS_Map();
    }
}