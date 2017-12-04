package questions;

public class CC1_6 {
	
	//CrackingTheCodinglnterview - 5th edtion - 1.6
	
//	int[][] matrix4 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
//	int[][] matrix5 = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
//			{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
//			
//	int[][] matrix = matrix4;
//	
//	for (int i = 0; i < matrix.length; i++) {
//		for (int j = 0; j < matrix.length; j++) {
//			System.out.printf("%2d ", matrix[i][j]);
//		}
//		System.out.println("");
//	}
//	
//	System.out.println("");
//
//	CC1_6.rotate90(matrix);
//
//	for (int i = 0; i < matrix.length; i++) {
//		for (int j = 0; j < matrix.length; j++) {
//			System.out.printf("%2d ", matrix[i][j]);
//		}
//		System.out.println("");
//	}
	
	public static void rotate90(int[][] matrix) {
		int line, col, temp;
		int n = matrix.length - 1;
		int half = (matrix.length / 2) + (matrix.length % 2);
		for (line = 0; line < half - (matrix.length % 2); line++) {
			for (col = 0; col < half; col++) {
				temp = matrix[line][col];
				matrix[line][col] = matrix[n - col][line];
				matrix[n - col][line] = matrix[n - line][n - col];
				matrix[n - line][n - col] = matrix[col][n - line];
				matrix[col][n - line] = temp;
			}
		}
	}

}
