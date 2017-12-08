package questions;

import java.util.Arrays;
import java.util.Stack;

public class LC_735 {
	// https://leetcode.com/problems/asteroid-collision/description/
	// https://leetcode.com/contest/weekly-contest-60/problems/asteroid-collision/

	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> survivals = new Stack<Integer>();

		for (int asteroid : asteroids) {
			if (survivals.isEmpty() || asteroid >= 0) {
				survivals.push(asteroid);
			} else {
				asteroid *= -1;
				while (!survivals.isEmpty() && survivals.peek() >= 0 && survivals.peek() < asteroid) {
					survivals.pop();
				}

				if (!survivals.isEmpty() && survivals.peek() == asteroid) {
					survivals.pop();
				} else if (survivals.isEmpty() || survivals.peek() < 0) {
					survivals.push(asteroid * (-1));
				}
			}
		}

		int[] result = new int[survivals.size()];
		Integer[] integerArray = Arrays.copyOf(survivals.toArray(), survivals.size(), Integer[].class);

		int index = 0;
		for (Integer i : integerArray) {
			result[index++] = i;
		}

		return result;
	}
}
