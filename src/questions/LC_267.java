package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import util.Permutation;

public class LC_267 {

	// http://blog.csdn.net/sbitswc/article/details/51055153
	// https://kennyzhuang.gitbooks.io/leetcode-lock/content/267_palindrome_permutation_ii.html
	// https://techdevguide.withgoogle.com/paths/advanced/working-in-multiple-languages-palindrome-permutation-2/#!
	// TODO: learn about permutation
	
	public static ArrayList<String> generatePalindromes(String s) {
		ArrayList<String> palindromes = new ArrayList<>();
		HashMap<Character, Integer> repetitions = new HashMap<>();
		
		char[] chars = s.toCharArray();
		int odd = 0;
		
		// count repetitions
		for (char c : chars) {
			Integer repetition = repetitions.get(c);
			if (repetition == null) {
				repetitions.put(c, 1);
				odd++;
			} else {
				repetition++;
				repetitions.put(c, repetition);
				if ((repetition & 1) == 1) {
					odd++;
				} else {
					odd--;
				}
			}
		}

		if (odd <= 1) {
			String left = "";
			String middle = "";

			// generate left side and find any middle char
			for (Entry<Character, Integer> c : repetitions.entrySet()) {
				if ((c.getValue() & 1) == 1) {
					middle += c.getKey();
				}

				for (int i = 0; i < (c.getValue() / 2); i++) {
					left += c.getKey();
				}
			}
			
			// generate a set of all permutations
			HashSet<String> set = new HashSet<>(Permutation.permutation(left));
			
			// concatenate middle and right (mirror of leftSide) to left side in order to generate palindromes
			for (String leftSide : set) {
				String result = leftSide + middle;
				for (int i = leftSide.length() - 1; i >= 0; i--) {
					result += leftSide.charAt(i);
				}
				palindromes.add(result);
			}
		}
		
		return palindromes;
	}
	
}
