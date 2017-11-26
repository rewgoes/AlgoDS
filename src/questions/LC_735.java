package questions;

import java.util.Stack;

public class LC_735 {
	// https://leetcode.com/problems/asteroid-collision/description/
	// https://leetcode.com/contest/weekly-contest-60/problems/asteroid-collision/
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> values = new Stack<>();

		int i = 0;
		Integer top;
		boolean push, stop;
		for (i = 0; i < asteroids.length; i++) {
			do {
				if (values.isEmpty()) {
					top = null;
				} else {
					top = values.peek();
				}

				if (top == null) {
					push = true;
					stop = true;
				} else {
					if (asteroids[i] > 0) {
						push = true;
						stop = true;
					} else {
						if (top < 0) {
							stop = true;
							push = true;
						} else if (asteroids[i] == top * -1) {
							stop = true;
							push = false;
							values.pop();
						} else if (asteroids[i] < top * -1) {
							values.pop();
							stop = false;
							push = true;
						} else {
							stop = true;
							push = false;
						}
					}
				}
			} while (!stop);

			if (push) {
				values.push(asteroids[i]);
			}
		}

		int[] val = new int[values.size()];

		for (int j = 0; j < values.size(); j++) {
			val[j] = values.get(j);
		}

		return val;
	}
}
