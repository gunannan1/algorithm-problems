package leetcode;


import java.util.HashMap;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 矩阵中的路径
 */
public class P79 {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        char[] words=word.toCharArray();
        visited=new boolean[rows][cols];
        for(int i=0 ; i<rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if(exist(board,words,i,j,0)){
                    return true;
                }


            }
        }
        return false;

    }

    private boolean exist(char[][]board, char[] words, int i, int j, int index){
        if(index == words.length){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != words[index] || visited[i][j]){
            return false;
        }

        visited[i][j] = true;

        if(exist(board, words, i-1, j, index+1) ||
                exist(board, words, i+1, j, index+1) ||
                exist(board, words, i, j-1, index+1) ||
                exist(board, words, i, j+1, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;




    }

}
