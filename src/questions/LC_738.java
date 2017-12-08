package questions;

public class LC_738 {
	
	//https://leetcode.com/problems/monotone-increasing-digits/description/
	
	public static int monotoneIncreasingDigits(int N) { // 333234

		char[] digits = String.valueOf(N).toCharArray();
		int i = 1;

		while (i < digits.length && digits[i - 1] <= digits[i]) { // 333 2 34
			i++;
		}

		while (i > 0 && i < digits.length && digits[i - 1] > digits[i]) { // 333234 -> 332234 -> 322234 -> 222234
			digits[--i]--;
		}

		for (int j = i + 1; j < digits.length; ++j) { // 299999
			digits[j] = '9';
		}

		return Integer.parseInt(String.valueOf(digits));
	}
}
