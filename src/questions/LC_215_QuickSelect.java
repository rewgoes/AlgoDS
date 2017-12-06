package questions;

public class LC_215_QuickSelect {

	// find the k-th lowest element
	
	
	// Similar to https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/
	// In this case: k = nums.length - k;

	public static int solve(int[] nums, int k) {
		k--;
		int pivot = nums.length - 1;
		int start = 0;
		int previousPivot, previousStart, temp;
		boolean hasChanged = false;

		do {
			previousPivot = pivot;
			previousStart = start;
			while (start < pivot) {
				if (nums[start] <= nums[pivot]) {
					start++;
				} else {
					temp = nums[start];
					nums[start] = nums[pivot - 1];
					nums[pivot - 1] = nums[pivot];
					nums[pivot] = temp;
					pivot--;
				}
			}

			hasChanged = false;
			if (pivot > k) {
				start = previousStart;
				pivot--;
				hasChanged = true;
			} else if (pivot < k) {
				System.out.println("b");
				start = pivot + 1;
				pivot = previousPivot;
				hasChanged = true;
			}
		} while (pivot != k || hasChanged);

		return nums[k];
	}

}
