package questions;

public class CC9_1 {
	//CrackingTheCodinglnterview - 5th edtion - 9.1
	
	public static int countWays(int n) {
		int[] ways = new int[n + 1];
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = ways[1] + 1;
		ways[3] = ways[2] + ways[1] + 1;
		countWays(ways, n);
		
		return ways[n];
	}
	
	private static int countWays(int[] ways, int n) {
		if (ways[n] == 0 && n > 3)
			ways[n] = countWays(ways, n - 1) + countWays(ways, n - 2) + countWays(ways, n - 3);
		
		return ways[n];
	}

}
