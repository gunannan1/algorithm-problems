package leetcode;

public class P121 {
	public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
        	if(prices[i]<minprice){
        		minprice=prices[i];
        	}
        	else if(prices[i]-minprice>maxprofit){
        		maxprofit=prices[i]-minprice;
        	}
        	
        }
        return maxprofit;
        
    }
	public static void main(String[] args) {
		int[] a={7, 1, 5, 3, 6, 4};
		P121 b=new P121();
		int c=b.maxProfit(a);
		System.out.println(c);
	}

}
