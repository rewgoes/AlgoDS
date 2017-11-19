package questions;

// https://leetcode.com/problems/longest-absolute-file-path/description/

import java.util.HashMap;

public class LC_388 {

	public static int lengthLongestPath(String input) {
		HashMap<Integer, Integer> filePath = new HashMap<>();
		int longestPath = 0;
		int level = 0;
		int curNameLength = 0;
		boolean foundSlash = false;
		boolean foundFile = false;

		for (char c : input.toCharArray()) {
			if (c == '\\') {
				foundSlash = true;
				foundFile = false;
				if (curNameLength > 0) {
					Integer pathSize = filePath.get(level - 1);
					if (pathSize == null) {
						filePath.put(level, curNameLength + 1);
					} else {
						filePath.put(level, curNameLength + 1 + pathSize);
					}
				}
				curNameLength = 0;
			} else if (c == 'n' && foundSlash) {
				foundSlash = false;
				level = 0;
			} else if (c == 't' && foundSlash) {
				foundSlash = false;
				level++;
			} else if (c == '.') {
				foundFile = true;
				curNameLength++;
			} else {
				curNameLength++;
				if (foundFile) {
					Integer pathSize = filePath.get(level - 1);
					if (pathSize != null) {
						if (longestPath < pathSize + curNameLength) {
							longestPath = pathSize + curNameLength;
						}
					} else {
						if (longestPath < curNameLength) {
							longestPath = curNameLength;
						}
					}
				}
			}
		}

		return longestPath;
	}

}
