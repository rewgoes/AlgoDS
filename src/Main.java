import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

	}

	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

		if (words1.length == words2.length) {
			HashMap<String, Set<String>> hashPairs = new HashMap<>();
			Set<String> set;

			for (String[] strings : pairs) {
				set = hashPairs.getOrDefault(strings[0], new HashSet<>());
				set.add(strings[1]);
				hashPairs.put(strings[0], set);

				set = hashPairs.getOrDefault(strings[1], new HashSet<>());
				set.add(strings[0]);
				hashPairs.put(strings[1], set);
			}

			for (int i = 0; i < words1.length; i++) {
				set = hashPairs.getOrDefault(words1[i], new HashSet<>());

				if (!words1[i].equals(words2[i]) && !set.contains(words2[i])) {
					return false;
				}
			}

			return true;
		}

		return false;
	}

	public int[] asteroidCollision(int[] asteroids) {
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
