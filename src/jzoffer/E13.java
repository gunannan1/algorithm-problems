package jzoffer;

/**
 *
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class E13 {
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
