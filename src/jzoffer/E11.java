package jzoffer;

/**
 *我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 大矩阵 2*1 有 1种 ，2*2有2种，推导下去

 */
public class E11 {
    public int RectCover(int target) {
        if(target<=0){
            return 0;
        }
        else if(target==1){
            return 1;
        }
        else {
            int a=0,c=0;
            int b=1;
            for (int i=1;i<=target;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }

    }
}
