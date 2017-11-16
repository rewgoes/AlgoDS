package questions;

import java.util.HashSet;

// https://leetcode.com/problems/distribute-candies/description/

public class LC_575 {

	public int distributeCandies(int[] candies) {
		HashSet<Integer> candyType = new HashSet<>();

		final int length = candies.length;

		for (int i = 0; i < length; i++) {
			candyType.add(candies[i]);
		}

        return Math.min(candyType.size(), candies.length / 2);
	}

}
