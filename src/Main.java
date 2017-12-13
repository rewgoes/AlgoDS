import questions.BoxStackWithRotation;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		// Output: 76, 158, 1181, 6897, 36700

		int[][] boxes = new int[][] { { 910, 360, 610 }, { 10, 170, 730 }, { 9300, 730, 4160 }, { 280, 1950, 8610 },
				{ 2460, 8940, 2030 }, { 5190, 1370, 1930 }, { 3470, 2410, 7530 }, { 4960, 2770, 1990 },
				{ 2010, 1430, 2560 }, { 7570, 8030, 2270 }, { 790, 1430, 1270 }, { 8930, 260, 9160 },
				{ 8450, 670, 6490 }, { 4750, 350, 5180 }, { 750, 4970, 4870 } };

		System.out.println(BoxStackWithRotation.solve(boxes));
		long end = System.currentTimeMillis();

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);

	}
}
