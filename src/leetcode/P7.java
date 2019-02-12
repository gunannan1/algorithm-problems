package leetcode;

public class P7 {
	 public static int reverse(int x) {
			 	int l;
			    if(x<0){
			    	l=String.valueOf(x).length()-1;
			    }else{
			    	l=String.valueOf(x).length();

			    }
		        int b=String.valueOf(x).length();
		        int sum=0;
		        for(int i=0;i<b;i++){
		   		 	if(sum>=2147483647||sum<=-2147483648||x>=2147483647||x<=-2147483647){return 0;};
		   			sum=(int) (sum+(int)(x/Math.pow(10, l-1))*Math.pow(10, i));
			   	    if(sum>=2147483647||sum<=-2147483648||x>=2147483647||x<=-2147483647){return 0;};
		        	System.out.println("sum "+sum);
		        	x=(int) (x-(int)(x/Math.pow(10, l-1))*Math.pow(10, l-1));
		        	System.out.println("x "+x);
		        	l--;
		        	System.out.println("l "+l);
		        	System.out.println("b "+b);
		        }
		        return sum;
	       
	    }
	 public static void main(String[] args) {
		System.out.println(reverse(1147483647));
	
	}

}
