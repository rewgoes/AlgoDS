package questions;

public class BoxStackWithRotation {

	public static int solve(int[][] boxes) {
		Box[][] boxesRotations = new Box[boxes.length][3];
		
		for (int i = 0; i < boxes.length; i++) {
			boxesRotations[i][0] = new Box(boxes[i][0], boxes[i][1], boxes[i][2]);
			boxesRotations[i][1] = new Box(boxes[i][2], boxes[i][0], boxes[i][1]);
			boxesRotations[i][2] = new Box(boxes[i][1], boxes[i][2], boxes[i][0]);
		}

		boolean[] visited = new boolean[boxes.length];
		
		//TODO: add some dynamic programming here

		return helper(boxesRotations, visited, -1, -1);
	}

	private static int helper(Box[][] boxes, boolean[] visited, int baseBox, int baseBoxRotation) {
		int max = 0;

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (baseBox == -1) {
					for (int rotation = 0; rotation < 3; rotation++) {
						int height = helper(boxes, visited, i, rotation) + boxes[i][rotation].h;
						max = height > max ? height : max;
					}
				} else {
					for (int rotation = 0; rotation < 3; rotation++) {
						int height;
						if (boxes[baseBox][baseBoxRotation].isBaseOf(boxes[i][rotation])) {
							height = helper(boxes, visited, i, rotation) + boxes[i][rotation].h;
						} else {
							height = helper(boxes, visited, baseBox, baseBoxRotation);
						}
						max = height > max ? height : max;
					}
				}
				visited[i] = false;
			}
		}

		return max;
	}

	public static class Box {
		int w, l, h;

		Box(int w, int l, int h) {
			this.w = w;
			this.l = l;
			this.h = h;
		}

		boolean isBaseOf(Box b) {
			return (w >= b.w && l >= b.l) || (l >= b.w && w >= b.l);
		}
	}

}
