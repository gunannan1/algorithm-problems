package jzoffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

 */
public class E14 {
    public int movingCount(int threshold, int rows, int cols) {
        if(threshold<0||rows<=0||cols<=0){
            return 0;
        }
        boolean[] visited=new boolean[rows*cols];
        return movingCountCore(threshold,rows,cols,0,0,visited);

    }

    private int movingCountCore(int threshold, int rows, int cols,
                                int row,int col,boolean[] visited) {
        //如果判断客户继续走，则设定该点已访问，且返回1+四个方向一共能走的步数之和，不然返回0
        if(row>=0&&row<rows&&col>=0&&col<cols&&checkSum(threshold,row,col)&&!visited[row*cols+col]) {
            visited[row*cols+col]=true;
            return 1+movingCountCore(threshold, rows, cols,row,col+1,visited)
                    +movingCountCore(threshold, rows, cols,row,col-1,visited)
                    +movingCountCore(threshold, rows, cols,row+1,col,visited)
                    +movingCountCore(threshold, rows, cols,row-1,col,visited);
        }
        return 0;


    }

    //判断是否满足行坐标列坐标之和的条件
    private boolean checkSum(int threshold, int row, int col) {
        int sum=0;
        while(row!=0){
            sum+=row%10;
            row=row/10;
        }
        while(col!=0){
            sum+=col%10;
            col=col/10;
        }
        if(sum>threshold) return false;
        return true;
    }
}
