package jzoffer;

/**
 *
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

 和 P79一样
 */
public class E13 {

    //P79解法，看着舒服
//    boolean[][] visited;
//
//    public boolean exist(char[][] board, String word) {
//        int rows=board.length;
//        int cols=board[0].length;
//        char[] words=word.toCharArray();
//        visited=new boolean[rows][cols];
//
//        //把数组中每个数当成起点来搜索
//        for(int i=0 ; i<rows ; i++) {
//            for (int j = 0; j < cols; j++) {
//                if(exist(board,words,i,j,0)){
//                    return true;
//                }
//
//            }
//        }
//        return false;
//
//    }
//
//    private boolean exist(char[][]board, char[] words, int i, int j, int index){
//        //如果index长度等于字符串长度，则搜索成功
//        if(index == words.length){
//            return true;
//        }
//        //搜索失败的条件
//        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != words[index] || visited[i][j]){
//            return false;
//        }
//
//        //该字符已访问
//        visited[i][j] = true;
//
//        //该字符匹配，网该字符的前后左右分别进行搜索看是否匹配
//        if(exist(board, words, i-1, j, index+1) ||
//                exist(board, words, i+1, j, index+1) ||
//                exist(board, words, i, j-1, index+1) ||
//                exist(board, words, i, j+1, index+1)){
//            return true;
//        }
//
//        //如果搜索失败，则消息该字符的已访问状态
//        visited[i][j] = false;
//        return false;
//
//
//    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null||str==null||rows<1||cols<1){
            return false;
        }

        //建立矩阵放判断所有点是否访问过
        boolean[] visited=new boolean[rows*cols];

        int pathLength=0;

        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                if(hasPathCore(matrix, rows, cols, str, i, j, visited, pathLength)) {
                    return true ;
                }
            }
        }

        return false ;


    }

    public boolean hasPathCore(char[] matrix,int rows, int cols, char[] str,
                               int row,int col,boolean[] visited,int pathLength){
        boolean hasPath=false;
        if(row>=0&&row<rows&&col>=0&&col<cols&&!visited[row*cols+col]&&matrix[row*cols+col]==str[pathLength]){
            pathLength++;
            visited[row*cols+col]=true;
            if (pathLength==str.length){
                return true;
            }
            hasPath=hasPathCore(matrix, rows, cols, str, row, col+1, visited, pathLength)  ||
                    hasPathCore(matrix, rows, cols, str, row+1, col, visited, pathLength)  ||
                    hasPathCore(matrix, rows, cols, str, row, col-1, visited, pathLength)  ||
                    hasPathCore(matrix, rows, cols, str, row-1, col, visited, pathLength) ;

            if(!hasPath){
                pathLength--;
                visited[row*cols+col] = false;
            }


        }

        return hasPath;

    }


}
