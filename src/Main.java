import questions.LC_741;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		int[][] grid = new int[][] {
			{1,1,1,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,1},
			{1,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,1,1,1},	
		};
		System.out.println(LC_741.cherryPickup(grid));

		long end = System.currentTimeMillis();

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);
	}

}
