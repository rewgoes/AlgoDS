package questions;

// https://leetcode.com/problems/range-sum-query-immutable/description/

public class LC_303 {
	
	public static class NumArray {
		
		private int[] nums;
		
		public NumArray(int[] nums) {
			if (nums != null) {
				this.nums = new int[nums.length];
				this.nums[0] = nums[0];
				for (int i = 1; i < nums.length; i++) {
					this.nums[i] = this.nums[i - 1] + nums[i];
				}
			}	        
	    }
	    
	    public int sumRange(int i, int j) {
	    	if (nums != null) {
	    		return nums[j] - (i == 0 ? 0 : nums[i - 1]);
	    	}
	        return 0;
	    }
		
	}
	
}
