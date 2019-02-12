package jzoffer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是连续的。大小王可以看做任何数字，或者看成0更方便
 */
public class E73 {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length <= 0){
            return false;
        }
        Arrays.sort(numbers);
        int numOfZero = 0;
        int numOfInterval = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            //统计0的个数
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            //如果是对子，直接返回
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            //统计间隔数目
            numOfInterval += numbers[i + 1] - numbers[i] - 1;

        }
        if (numOfZero >= numOfInterval) {
            return true;
        }
        return false;

    }
}
