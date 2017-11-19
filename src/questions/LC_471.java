package questions;

// http://massivealgorithms.blogspot.com.br/2016/12/leetcode-471-encode-string-with.html
// https://leetcode.com/problems/encode-string-with-shortest-length

public class LC_471 {

	public static String encode(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		String[][] dp = new String[s.length()][s.length()];

		for (int len = 0; len < s.length(); len++) {
			for (int i = 0; i + len < s.length(); i++) {
				int j = i + len;
				String subStr = s.substring(i, j + 1);
				dp[i][j] = subStr; // initialize
				if (len < 4)
					continue;
				for (int k = i; k < j; k++) {
					if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
						dp[i][j] = dp[i][k] + dp[k + 1][j];
					}
				}

				// check if subStr has repeat pattern
				for (int k = i; k < j; k++) {
					String repeat = s.substring(i, k + 1);
					if (subStr.length() % (k - i + 1) == 0 && subStr.replaceAll(repeat, "").length() == 0) {
						String ss = subStr.length() / repeat.length() + "[" + dp[i][k] + "]";
						if (ss.length() < dp[i][j].length())
							dp[i][j] = ss;
					}
				}
			}
		}
		return dp[0][s.length() - 1];
	}

}
