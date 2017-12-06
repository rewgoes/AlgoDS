package questions;

import java.util.Stack;

public class UnmatchParentheses {
	
	//System.out.println(UnmatchParentheses.solve(")(((abc))((d)))((())("));
	
	public static String solve(String input) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> parentheses = new Stack<>();
		
		int index;
		for (index = 0; index < input.length(); index++) {
			if (input.charAt(index) == '(') {
				parentheses.push(index);
				sb.append('0');
			} else if (input.charAt(index) == ')') {
				if (!parentheses.isEmpty() && input.charAt(parentheses.peek()) == '(') {
					parentheses.pop();
				} else {
					parentheses.push(index);
				}
				sb.append('1');
			} else {
				sb.append(input.charAt(index));
			}
		}
		
		while (!parentheses.isEmpty()) {
			index = parentheses.pop();
			sb.setCharAt(index, '1');
			sb.insert(index, '-');
		}		
		
		return sb.toString();
	}

}
