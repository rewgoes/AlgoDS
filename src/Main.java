import java.util.List;

import questions.LC_215_QuickSelect;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		int[] nums = new int[] { 2, 3, 4, 5, 11, 7, 8, 9, 10, 6 };
		int k = 11;
		System.out.println(LC_215_QuickSelect.solveRecuservely(nums, k));

		long end = System.currentTimeMillis();

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);

	}

	public static void bla(List<Integer> a) {

	}

}
