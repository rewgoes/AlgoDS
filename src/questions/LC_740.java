package questions;

public class LC_740 {

	//https://leetcode.com/problems/delete-and-earn/
	
	public static int deleteAndEarn(int[] nums) {
		// nums[i] is an integer in the range [1, 10000] (K = 10000)
		
		//count number of k
		int[] count = new int[10001];
		for (int x : nums) {
			count[x]++;
		}
		int avoid = 0, using = 0, prev = -1;

		for (int k = 0; k <= 10000; k++) {
			if (count[k] > 0) {
				int m = Math.max(avoid, using);
				if (k - 1 != prev) {
					using = k * count[k] + m;
					avoid = m;
				} else {
					using = k * count[k] + avoid;
					avoid = m;
				}
				prev = k;
			}
		}

		return Math.max(avoid, using);
	}

}
