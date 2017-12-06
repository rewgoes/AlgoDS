package questions;

public class LC_42 {
	// https://leetcode.com/problems/trapping-rain-water/description/
	// https://techdevguide.withgoogle.com/paths/advanced/volume-of-water/#code-challenge

//	System.out.println(LC_42.trapSingleScan(new int[] { 1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2 })); //15
//	System.out.println(LC_42.trapSingleScan(new int[] { 1, 0, 2, 0, 1, 5, 1, 2, 5, 0 })); //11
		
	public static int trap(int[] height) {
		// scan left to right and right to left
		int volume = 0;
		int currentVolume = 0;
		
		int max = height[0];
		
		int i;

		//accumulate when find highest from left to right
		for (i = 1; i < height.length; i++) {
			if (height[i] >= max) {
				volume += currentVolume;
				currentVolume = 0;
				max = height[i];
			} else {
				currentVolume += max - height[i];
			}
		}
		
		//accumulate when find highest from right to left
		max = height[height.length - 1];
		currentVolume = 0;
		for (i = height.length - 2; i >= 0; i--) {
			if (height[i] >= max) {
				volume += currentVolume;
				currentVolume = 0;
				max = height[i];
			} else {
				currentVolume += max - height[i];
			}
		}
		
		return volume;
	}
	
	public static int trapSingleScan(int[] height) {
		// start from left and right at the same time
		int volume = 0;
		
		int indexLeft = 0;
		int indexRight = height.length -1;
		
		int maxLeft = height[indexLeft];
		int maxRight = height[indexRight];
		
		while (indexLeft < indexRight) {
			if (height[indexLeft] < height[indexRight]) {
				if (height[indexLeft] > maxLeft) {
					maxLeft = height[indexLeft];
				} else {
					volume += maxLeft - height[indexLeft];
				}
				indexLeft++;
			} else {
				if (height[indexRight] > maxRight) {
					maxRight = height[indexRight];
				} else {
					volume += maxRight - height[indexRight];
				}
				indexRight--;
			}
		}
		
		return volume;
	}
}
