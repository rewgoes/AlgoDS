package questions;

public class Knapsack {
	
//	int[] values = new int[] { 1, 4, 5, 7, 2 };
//	int[] weights = new int[] { 1, 3, 4, 5, 1 };
//	int maxWeight = 7;
//	System.out.println(Knapsack.solve(values, weights, maxWeight));
//	//10

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
	
	public static int solveLessSpace(int[] values, int[] weights, int maxWeight) {
		int[] dp = new int[maxWeight + 1];

		int item = 1;
		int subWeight = 1;

		for (item = 1; item <= values.length; item++) {
			for (subWeight = maxWeight; subWeight >= weights[item - 1]; subWeight--) {
				if (weights[item - 1] <= subWeight) {
					dp[subWeight] = Math.max(values[item - 1] + dp[subWeight - weights[item - 1]], dp[subWeight]);
				} else {
					dp[subWeight] = dp[subWeight];
				}
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println("\n");

		return dp[maxWeight];
	}

}
