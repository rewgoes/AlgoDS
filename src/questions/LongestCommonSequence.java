package questions;

import java.util.Arrays;

public class LongestCommonSequence {

	// https://www.youtube.com/watch?v=Qf5R-uYQRPk

	// Find the longest subsequence from two strings
	// The characters does not need to be continuos

	// Longest Common Subsequence
	// System.out.println(LongestCommonSequence.solve("BATD", "BABACDTD"));
	public static int solve(String a, String b) {
		int[][] dp = new int[a.length()][b.length()];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return solve(a, b, 0, 0, dp);
	}

	private static int solve(String a, String b, int indexA, int indexB, int[][] dp) {
		if (indexA == a.length() || indexB == b.length()) {
			return 0;
		}

		if (dp[indexA][indexB] != -1) {
			return dp[indexA][indexB];
		}

		int result;
		if (a.charAt(indexA) == b.charAt(indexB)) {
			result = 1 + solve(a, b, indexA + 1, indexB + 1, dp);
		} else {
			int moveA = solve(a, b, indexA + 1, indexB, dp);
			int moveB = solve(a, b, indexA, indexB + 1, dp);

			if (moveA > moveB) {
				result = moveA;
			} else {
				result = moveB;
			}
		}
		
		dp[indexA][indexB] = result;

		return result;
	}

	// int[][] dp = new int[a.length()][b.length()];
	// return solveHelper(dp, a, b, 0, 0);
	// }
	//
	// private static int solve(int[][] dp, String a, String b, int indexA, int
	// indexB) {
	// if (indexA == a.length() || indexB == b.length()) {
	// return 0;
	// }
	// if (a.charAt(indexA) == b.charAt(indexB)) {
	// return 1 + solve(dp, a, b, indexA++, indexB++);
	// } else {
	//
	// }
	// }

}
