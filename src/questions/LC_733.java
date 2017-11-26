package questions;

public class LC_733 {
	private static int previousColor;
	private static int nc;
	private static boolean[][] visited;

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		previousColor = image[sr][sc];
		nc = newColor;
		if (previousColor != newColor) {
			visited = new boolean[image.length][image[0].length];
			paint(image, sr, sc);
		}
		return image;
	}

	private static void paint(int[][] image, int i, int j) {
		visited[i][j] = true;
		image[i][j] = nc;
		if (i - 1 >= 0 && image[i - 1][j] == previousColor && !visited[i - 1][j]) {
			paint(image, i - 1, j);
		}
		if (i + 1 < image.length && image[i + 1][j] == previousColor && !visited[i + 1][j]) {
			paint(image, i + 1, j);
		}
		if (j - 1 >= 0 && image[i][j - 1] == previousColor && !visited[i][j - 1]) {
			paint(image, i, j - 1);
		}
		if (j + 1 < image[0].length && image[i][j + 1] == previousColor && !visited[i][j + 1]) {
			paint(image, i, j + 1);
		}
	}
}
