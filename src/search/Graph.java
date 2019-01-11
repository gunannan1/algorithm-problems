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
//    void DFSTraverse() {
//        flag = new boolean[number];
//        for (int i = 0; i < number; i++) {
//            if (flag[i] == false) {// 当前顶点没有被访问
//                DFS(i);
//            }
//        }
//    }
//
//    void DFS(int i) {
//        flag[i] = true;// 第i个顶点被访问
//        System.out.print(vertexs[i] + " ");
//        for (int j = 0; j < number; j++) {
//            if (flag[j] == false && edges[i][j] == 1) {
//                DFS(j);
//            }
//        }
//    }
//
//    void DFS_Map(){
//        flag = new boolean[number];
//        Stack<Integer> stack =new Stack<Integer>();
//        for(int i=0;i<number;i++){
//            if(flag[i]==false){
//                flag[i]=true;
//                System.out.print(vertexs[i]+" ");
//                stack.push(i);
//            }
//            while(!stack.isEmpty()){
//                int k = stack.pop();
//                for(int j=0;j<number;j++){
//                    if(edges[k][j]==1&&flag[j]==false){
//                        flag[j]=true;
//                        System.out.print(vertexs[j]+" ");
//                        stack.push(j);
//                        break;
//                    }
//                }
//
//            }
//        }
//    }
//
//    void BFS_Map(){
//        flag = new boolean[number];
//        Queue<Integer> queue = new LinkedList<Integer>();
//        for(int i=0;i<number;i++){
//            if(flag[i]==false){
//                flag[i]=true;
//                System.out.print(vertexs[i]+" ");
//                queue.add(i);
//                while(!queue.isEmpty()){
//                    int k=queue.poll();
//                    for(int j=0;j<number;j++){
//                        if(edges[k][j]==1&&flag[j]==false){
//                            flag[j] = true;
//                            System.out.print(vertexs[j]+" ");
//                            queue.add(j);
//                        }
//                    }
//                }
//            }
//        }
//    }

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