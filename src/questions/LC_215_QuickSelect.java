package questions;

import java.util.NoSuchElementException;

public class LC_215_QuickSelect {

	// find the k-th lowest element

	// Similar to
	// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/
	// In this case: k = nums.length - k;
	
	// int[] nums = new int[] { 2, 3, 4, 5, 11, 7, 8, 9, 10, 6 };
	// int k = 11;
	// System.out.println(LC_215_QuickSelect.solveRecuservely(nums, k));

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

	public static int solveRecuservely(int[] nums, int k) throws NoSuchElementException {
		k--;
		return helper(nums, 0, nums.length - 1, k);
	}

	private static int helper(int[] nums, int start, int end, int k) throws NoSuchElementException {
		if (start < end) {
			int pivot = partition(nums, start, end);
			if (pivot == k) {
				return nums[pivot];
			}
			
			if (pivot > k) {
				return helper(nums, start, pivot - 1, k);
			} else {
				return helper(nums, pivot + 1, end, k);
			}
		}
		throw new NoSuchElementException();
	}

	private static int partition(int[] nums, int start, int end) {
		int temp;

		while (start < end) {
			if (nums[start] > nums[end]) {
				temp = nums[end];
				nums[end] = nums[start];
				nums[start] = nums[end - 1];
				nums[end - 1] = temp;
				end--;
			} else {
				start++;
			}
		}

		return end;

	}

}
