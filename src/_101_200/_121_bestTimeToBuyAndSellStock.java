package _101_200;

public class _121_bestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = { 1, 7, 1, 5, 3, 6, 4 };
		
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int len = prices.length;

		int maxIndex = 0;
		int minIndex = 0;
		int maxProfit = 0;

		for (int i = 1; i < len; i++) {
			if (prices[i] < prices[minIndex]) {
				maxProfit = Math.max(maxProfit, prices[maxIndex] - prices[minIndex]);
				minIndex = i;
				maxIndex = minIndex;
			}
			
			if (prices[i] > prices[maxIndex]) {
				maxIndex = i;
			}
		}
		
		maxProfit = Math.max(maxProfit, prices[maxIndex] - prices[minIndex]);

		return maxProfit;
	}
}
