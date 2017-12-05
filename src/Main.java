import questions.LongestCommonSequence;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		System.out.println(LongestCommonSequence.solve("BATD", "BABACDTD"));

		long end = System.currentTimeMillis();

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);

	}

}
