package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LC_736_TODO {

	// https://leetcode.com/contest/weekly-contest-60/problems/parse-lisp-expression/
	// https://leetcode.com/problems/parse-lisp-expression/description/
	private static final List<String> EXPRESSION = Arrays.asList(new String[] { "add", "mult", "let" });

	static class Expression {
		String expression;
		String left = null;
		String right = null;
		
		String evaluate(ArrayList<HashMap<String, Integer>> scope) {
			if (expression.equals("add")) {
				return Integer.toString(Integer.parseInt(left) + Integer.parseInt(right));
			} else {
				return Integer.toString(Integer.parseInt(left) * Integer.parseInt(right));				
			}
		}
		
		void setVal(String val) {
			if (left == null)
				left = val;
			else
				right = val;
		}
	}

	public static int evaluate(String expression) {
		ArrayList<String> tokens = tokenize(expression); // tokenization done

		ArrayList<HashMap<String, Integer>> scope = new ArrayList(); // keep scope variable here
		
		// TODO: evaluate for "let"
		Stack<Expression> expressions = new Stack<>();
		String val = null;

		for (String token : tokens) {
			if (token.equals("(")) {
				scope.add(new HashMap<>());
				expressions.add(new Expression());
			} else if (token.equals(")")) {
				val = expressions.pop().evaluate(scope);
				if (!expressions.isEmpty()) {
					expressions.peek().setVal(val);
				}
			} else if (EXPRESSION.contains(token)) {
				expressions.peek().expression = token;
			} else {
				if (!expressions.peek().expression.equals("let")) {
					expressions.peek().setVal(token);
				}
			}
		}

		return Integer.parseInt(val);
	}

	private static ArrayList<String> tokenize(String expression) {
		ArrayList<String> tokens = new ArrayList<>();

		String current = "";

		for (char c : expression.toCharArray()) {
			if (c == '(' || c == ')') {
				if (!current.equals("")) {
					tokens.add(current);
				}
				current = "";
				tokens.add(c + "");
			} else if (c == ' ') {
				if (!current.equals("")) {
					tokens.add(current);
					current = "";
				}
			} else {
				current += c;
			}
		}

		return tokens;
	}

}
