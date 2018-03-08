package _101_200;

public class _122_bestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		int[] prices = { 1,9,6,9,1,7,1,1,5,9,9,9 };
		
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}
		
		int len = prices.length;
		int maxIndex = 0;
		int minIndex = 0;
		int maxProfit = 0;
		
		for(int i = 1; i < len; i++) {
			if(prices[i] >= prices[maxIndex]) {
				maxIndex = i;
			}
			
			if(prices[i] < prices[maxIndex]) {
				maxProfit += prices[maxIndex] - prices[minIndex];
				minIndex = i;
				maxIndex = i;
			}
		}
		
		if(maxIndex == len - 1) {
			maxProfit += prices[maxIndex] - prices[minIndex];
		}
		
		return maxProfit;
	}
}
