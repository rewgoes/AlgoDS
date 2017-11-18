package questions;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class LC_121 {

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else if (prices[i] - min > maxProfit) {
				maxProfit = prices[i] - min;
			}
		}

		return maxProfit;
	}

}
