import questions.CC11_1;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		int[] a = new int[] { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 };
		int[] b = new int[] { 4, 5, 6, 7, 10 };
		int lastA = a.length - b.length - 1;
		int lastB = b.length - 1;

		CC11_1.merge(a, b, lastA, lastB);

		long end = System.currentTimeMillis();

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);

	}

}
