package jzoffer;

/**
 *
 在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。
 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 1    10   3    8
 12   2    9    6
 5    7    4    11
 3    7    16   5
 礼物的最大价值为1+12+5+7+7+16+5=53。

 矩阵最大价值和基本同 P64（最小价值和）
 */
public class E51 {
    public static int getMaxVaule(int[][] data){
        if(data.length==0||data[0].length==0){
            return 0;
        }
        int[][] max=new int[data.length][data[0].length];
        for(int i=0;i<data.length;i++){
            for (int j=0;j<data[0].length;j++){
                int left=0;
                int up=0;
                if(i>0){
                    left=max[i-1][j];
                }
                if(j>0){
                    up=max[i][j-1];
                }
                max[i][j]=Math.max(left,up)+data[i][j];

            }
        }
        return max[data.length-1][data[0].length-1];


    }

    public static void main(String[] args){
        int[][] data = {
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}};
        System.out.println(getMaxVaule(data));
    }



}
