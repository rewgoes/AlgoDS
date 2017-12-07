package questions;

import java.util.Arrays;

public class LC_741 {

	//https://leetcode.com/problems/cherry-pickup/description/
	
	//Greedy algorithm (trace the best path and then trace another path) does not work for the following case
	//Both paths must be calculated at the same time
	
//	int[][] grid = new int[][] {
//		{1,1,1,1,0,0,0},
//		{0,0,0,1,0,0,0},
//		{0,0,0,1,0,0,0},
//		{0,0,0,1,0,0,1},
//		{1,0,0,1,0,0,0},
//		{0,0,0,1,0,0,0},
//		{0,0,0,1,1,1,1},	
//	};
//	System.out.println(LC_741.cherryPickup(grid));
	
	private static int N = 0;

	public static int cherryPickup(int[][] grid) {
		N = grid.length;

		if (N == 0)
			return 0;

		int[][][] dp = new int[N][N][N];

		for (int[][] layer : dp)
			for (int[] row : layer)
				Arrays.fill(row, Integer.MIN_VALUE);

		return Math.max(0, helper(grid, dp, 0, 0, 0));
	}

	private static int helper(int[][] grid, int[][][] dp, int r1, int c1, int c2) {
		// Consider t steps, r1 + c1 = t and r2 + c2 = t => r2 = r1 + c1 - c2;
		int r2 = r1 + c1 - c2;
		if (r1 == N || c1 == N || r2 == N || c2 == N || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
			return Integer.MIN_VALUE - 1;
		} else if (r1 == N - 1 && c1 == N - 1) {
			return grid[r1][c1];
		} else if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
			return dp[r1][c1][c2];
		} else {
			dp[r1][c1][c2] = grid[r1][c1];
			
			//if two paths cross, do not count it twice
			if (c1 != c2) {
				dp[r1][c1][c2] += grid[r2][c2];
			}
			
			/** 4 possible movements:
			 * 1 goes down and 2 goes right
			 * 1 goes down and 2 goes down
			 * 1 goes right and 2 goes right
			 * 1 goes right and 2 goes down
			 */
			dp[r1][c1][c2] += Math.max(Math.max(helper(grid, dp, r1 + 1, c1, c2), helper(grid, dp, r1, c1 + 1, c2)),
					Math.max(helper(grid, dp, r1 + 1, c1, c2 + 1), helper(grid, dp, r1, c1 + 1, c2 + 1)));

			return dp[r1][c1][c2];
		}
	}

}
