package questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC_734 {
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
}
