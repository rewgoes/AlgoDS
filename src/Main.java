import questions.S2;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		// Output: 76, 158, 1181, 6897, 36700

		int[] boxes = new int[] { 4, 1, 3, 9, 5, 6, 7, 7, 4, 8, 3, 21, 7, 43, 25, 3, 6, 7, 24};

		System.out.println(S2.solve(boxes));
		long end = System.currentTimeMillis();

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);

	}
}
