
import java.util.ArrayList;

import questions.LC_267;

public class Main {

	public static void main(String[] args) {
		 ArrayList<String> permutations = LC_267.generatePalindromes("arara");
		 
		 for (String s : permutations) {
			 System.out.println(s);
		 }
	}

}
