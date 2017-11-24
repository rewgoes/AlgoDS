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

}
