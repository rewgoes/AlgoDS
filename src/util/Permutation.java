package util;

import java.util.ArrayList;

//abcd bacd cabd dabc
//abdc badc cadb dacb
//acbd bcad cbad dbac
//acdb bcda cbda dbca
//adbc bdac cdab dcab
//adcb bdca cdba dcba

public class Permutation {

	public static ArrayList<String> permutation(String str) {
		ArrayList<String> permutations = new ArrayList<>();
		permutation(permutations, "", str);
		return permutations;
	}

	private static void permutation(ArrayList<String> permutations, String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutation(permutations, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}
	
	// Cracking the code interview - 5th edtion
	public static ArrayList<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { //base case
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0); //get the first character
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	private static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
