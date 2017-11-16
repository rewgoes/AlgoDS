package questions;

import java.util.Stack;

// https://techdevguide.withgoogle.com/paths/advanced/compress-decompression/#!
/*
The Challenge

In this exercise, you're going to decompress a compressed string.

Your input is a compressed string of the format number[string] and the decompressed output form should be the string written number times. For example:

The input

3[abc]4[ab]c

Would be output as

abcabcabcababababc

Other rules

Number can have more than one digit. For example, 10[a] is allowed, and just means aaaaaaaaaa

One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab

Characters allowed as input include digits, small English letters and brackets [ ].

Digits are only to represent amount of repetitions.

Letters are just letters.

Brackets are only part of syntax of writing repeated substring.

Input is always valid, so no need to check its validity.

Learning objectives

This question gives you the chance to practice with strings, recursion, algorithm, compilers, automata, and loops. It’s also an opportunity to work on coding with better efficiency.

 */

public class DecompressString {

	public static String solution(String input) {
		Stack<Substring> substrings = new Stack<>();
		String output = "";
		String num = "";

		if (input != null) {
			for (char c : input.toCharArray()) {
				if (c >= 'a' && c <= 'z') {
					if (substrings.isEmpty()) {
						output += c;
					} else {
						substrings.peek().value += c;
					}
				} else if (c >= '0' && c <= '9') {
					num += c;
				} else if (c == '[') {
					int repetition = Integer.parseInt(num);
					num = "";
					substrings.push(new Substring(repetition));
				} else if (c == ']') {
					Substring sub = substrings.pop();
					if (substrings.isEmpty()) {
						for (int i = 0; i < sub.repetition; i++) {
							output += sub.value;
						}
					} else {
						Substring head = substrings.peek();
						for (int i = 0; i < sub.repetition; i++) {
							head.value += sub.value;
						}
					}
				}
			}
		}

		return output;
	}

}

class Substring {
	String value = "";
	int repetition;

	public Substring(int repetition) {
		this.repetition = repetition;
	}
}
