package jzoffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class E17 {
//    public double Power(double base, int exponent) {
//        double result=1;
//        if(exponent==0){
//            return 1;
//        }
//
//        else if(exponent>0){
//            for(int i=0;i<exponent;i++){
//                result*=base;
//            }
//            return result;
//        }
//
//        else {
//            if(base==0){
//                System.out.println("分母不能为0");
//            }
//            for(int i=0;i<-exponent;i++){
//                result*=base;
//            }
//            return 1/result;
//
//        }
//    }

    public double Power(double base, int exponent) {

        int n=Math.abs(exponent);
        if(exponent==0){
            return 1;
        }
        if(exponent==1){
            return base;
        }
        double  result=Power(base,n>>1);
        result*=result;
        if((n&1)==1){
            result*=base;
        }
        if(exponent<0){
            result=1/result;
        }

        return result;


    }
}
