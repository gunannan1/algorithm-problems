package leetcode;

public class P69 {
    public static int mySqrt(int x) {
        int lo=0;
        int hi=x;
        while(lo<=hi){
            long mid=(long)(lo+hi)/2;
            if(mid*mid<x){
                lo=(int)mid+1;
            }
            else if(mid*mid>x){
                hi=(int)mid-1;
            }
            else{
                return (int)mid;
            }
        }
        return hi;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }


}
