package questions;

public class S2 {

	private static int[] boxes;
	private static boolean[][] stacks;
	private static int size;
	private static int max;
	private static int count;

	public static int solve(int[] boxes) {
		S2.boxes = boxes;
		size = boxes.length;
		max = 0;
		for (int box : boxes) {
			max += box;
		}

		// Start recursive topDown
		stacks = new boolean[max + 1][max + 1];
		stacks[0][0] = true;

		count = 0;
		solveTopDown(0, 0, 0);

		int result = 0;
		for (int i = max; i >= 0; i--) {
			if (stacks[i][i]) {
				result = i;
				break;
			}
		}
		System.out.println("Max: " + max + ", length: " + boxes.length);
		System.out.println("Recursive topDown: " + count + " iterations (expected: " + (int) (3 * Math.pow(3, size) / 2)
				+ "). Result: " + result);
		//Geometric progression: 3, 9, 27, 81, ...
		//a1 * (q^n -1)

		// Start iterative bottomUp
		stacks = new boolean[max + 1][max + 1];
		stacks[0][0] = true;

		count = 0;
		solveBottomUp();

		result = 0;
		for (int i = max; i >= 0; i--) {
			if (stacks[i][i]) {
				result = i;
				break;
			}
		}
		System.out.println("Iterative bottomUp: " + count + " iterations (expected: "
				+ (int) Math.pow(max + 1, 2) * size + "). Result: " + result);

		return result;
	}

	private static void solveTopDown(int stack1, int stack2, int box) {
		count++;
		if (stack1 == stack2)
			stacks[stack1][stack2] = true;
		if (box < size) {
			solveTopDown(stack1, stack2, box + 1);
			solveTopDown(stack1 + boxes[box], stack2, box + 1);
			solveTopDown(stack1, stack2 + boxes[box], box + 1);
		}
	}

	private static void solveBottomUp() {
		for (int box = 0; box < size; box++) {
			for (int stack1 = max; stack1 >= 0; stack1--) {
				for (int stack2 = max; stack2 >= 0; stack2--) {
					count++;
					if (stacks[stack1][stack2]) {
						stacks[stack1 + boxes[box]][stack2] = true;
						stacks[stack1][stack2 + boxes[box]] = true;
					}
				}
			}
		}

	}

}
