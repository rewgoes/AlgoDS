import questions.LC_294;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		System.out.println(LC_294.canWin("-+++++-+--+++--++++"));
		long end = System.currentTimeMillis();

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);
		
	}
}
