package questions;

public class LC_474 {

	// https://leetcode.com/problems/ones-and-zeroes/description/

	public static int findMaxForm(String[] strs, int m, int n) {
		int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
		int[] zerosOnes = new int[2];

		for (int string = 1; string <= strs.length; string++) {
			countZeroOne(strs[string - 1], zerosOnes);
			for (int zeros = 1; zeros <= m; zeros++) {
				for (int ones = 1; ones <= n; ones++) {
					if (zeros >= zerosOnes[0] && ones >= zerosOnes[1]) {
						dp[string][zeros][ones] = Math.max(1 + dp[string - 1][zeros - zerosOnes[0]][ones - zerosOnes[1]], 
								dp[string - 1][zeros][ones]);
					} else {
						dp[string][zeros][ones] = dp[string - 1][zeros][ones];
					}
				}
			}
		}

		return dp[strs.length][m][n];
	}

	private static void countZeroOne(String string, int[] result) {
		result[0] = 0;
		result[1] = 0;
		for (char c : string.toCharArray()) {
			if (c == '0')
				result[0]++;
			else
				result[1]++;
		}
	}

}
