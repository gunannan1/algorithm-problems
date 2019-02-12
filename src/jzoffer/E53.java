package jzoffer;

import java.util.ArrayList;

/**
 *
 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class E53 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        ArrayList<Integer> result=new ArrayList<>();
        result.add(1);
        int i2=0;
        int i3=0;
        int i5=0;
        while (result.size()<index){
            int m2=result.get(i2)*2;
            int m3=result.get(i3)*3;
            int m5=result.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            result.add(min);
            if(min==m2){
                i2++;
            }
            if(min==m3){
                i3++;
            }
            if(min==m5){
                i5++;
            }
        }
        return result.get(index-1);


    }

}
