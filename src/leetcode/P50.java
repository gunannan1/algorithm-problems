package leetcode;

/**
 * 同 E17，
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class P50 {
//    public double myPow(double x, int n) {
////        return Math.pow(x,n);
//        if(n==0){
//            return 1;
//        }
//        boolean negative=false;
//
//        if(n<0){
//            negative=true;
//            n=-n;
//        }
//
//        double res=myPow(x*x,n/2);
//        if(n%2==1){
//            res*=x;
//        }
//        return negative?1/res:res;
//
//    }
    public double myPow(double x, int n) {
        if(n<0) return 1/x * myPow(1/x, -(n+1));
        if(n==0) return 1;
        if(n==2) return x*x;
        if(n%2==0) return myPow( myPow(x, n/2), 2);
        else return x*myPow( myPow(x, n/2), 2);
    }


    public static void main(String[] args) {
        P50 p50=new P50();
        System.out.println(p50.myPow(2.00000,
                -2147483648));
    }
}
