package questions;

public class Knapsack {

	public static int solve(int[] values, int[] weights, int maxWeight) {
		int[][] dp = new int[values.length + 1][maxWeight + 1];

		int item = 1;
		int subWeight = 1;

		for (item = 1; item <= values.length; item++) {
			for (subWeight = 1; subWeight <= maxWeight; subWeight++) {
				if (weights[item - 1] <= subWeight) {
					dp[item][subWeight] = Math.max(values[item - 1] + dp[item - 1][subWeight - weights[item - 1]],
							dp[item - 1][subWeight]);
				} else {
					dp[item][subWeight] = dp[item - 1][subWeight];
				}
			}
		}

		return dp[values.length][maxWeight];
	}

}
