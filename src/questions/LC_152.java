package questions;

public class LC_152 {

	// int[] nums = new int[] { 1, 2, -4, 5, 3, -2, 8, 9, -10 };
	// System.out.println(LC_152.maxProduct(nums));

	public static int maxProduct(int[] nums) {
		int r = nums[0];
		int temp;

		// max/min stores the of the subarray until current number A[i]
		for (int i = 1, max = r, min = r; i < nums.length; i++) {
			// multiplied by a negative makes big number smaller, small number bigger
			if (nums[i] < 0) {
				temp = max;
				max = min;
				min = temp;
			}

			// max/min product for the current number is either the current number itself
			// or the max/min by the previous number times the current one
			max = Math.max(nums[i], max * nums[i]);
			min = Math.min(nums[i], min * nums[i]);

			// the newly computed max value is a candidate max result
			r = Math.max(r, max);
		}
		return r;
	}

}
