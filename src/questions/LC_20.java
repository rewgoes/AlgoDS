package questions;

import java.util.Stack;

public class LC_20 {
	
	public boolean isValid(String s) {
		final Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;
			default:
				if (stack.pop() != c)
					return false;
			}
		}
		return stack.isEmpty();
	}
}
