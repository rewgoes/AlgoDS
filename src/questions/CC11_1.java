package questions;

public class CC11_1 {
	
//	int[] a = new int[] { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 };
//	int[] b = new int[] { 4, 5, 6, 7, 10 };
//	int lastA = a.length - b.length - 1;
//	int lastB = b.length - 1;
//
//	CC11_1.merge(a, b, lastA, lastB);
//
//	for (int i = 0; i < a.length; i++) {
//		System.out.print(a[i] + " ");
//	}
	
	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int index = lastA + lastB + 1;
		
		while (index >= 0) {
			if (lastA < 0) {
				a[index] = b[lastB];
				lastB--;				
			} else if (lastB < 0) {
				// after B finishes, there's no need to copy A, since it's already in place
				break;
			} else if (a[lastA] > b[lastB]) {
				a[index] = a[lastA];
				lastA--;
			} else {
				a[index] = b[lastB];
				lastB--;
			}
			index--;
		}
	}

}
