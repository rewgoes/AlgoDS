package questions;

public class MedianTwoSortedArraysSameLength {


//	int[] a1 = new int[] {1,3,6,7,8,30,41,61,756,1332,1400};
//	int[] a2 = new int[] {-1,2,5,87,90,96,450,569,990,1000,1400};
//	
//	int[] a1 = new int[] {1,2,3,4,5,6,7,8,9,10};
//	int[] a2 = new int[] {11,12,13,14,15,16,17,18,19,20};
	
	public static double solve(int[] a1, int[] a2) {
		return solve(a1, 0, a1.length - 1, a2, 0, a2.length - 1);
	}

	private static double solve(int[] a1, int l1, int h1, int[] a2, int l2, int h2) {
		if (l1 == h1) {
			return (a1[l1] + a2[l2]) / 2.0;
		}

		if (h1 - l1 == 1) {
			System.out.println(l1 + " - " + h1 + "; " + l2 + " - " + h2);
			return (Math.max(a1[l1], a2[l2]) + Math.min(a1[h1], a2[h2])) / 2.0;
		}

		double m1 = median(a1, l1, h1);
		double m2 = median(a2, l2, h2);

		if (m1 == m2) {
			return m1;
		}

		int length = h1 - l1 + 1;
		if (m1 < m2) {
			return solve(a1, l1 + (length / 2), h1, a2, l2, h2 - (length / 2));
		} else {
			return solve(a1, l1, h1 - (length / 2), a2, l2 + (length / 2), h2);
		}
	}

	private static double median(int[] a, int low, int high) {
		int length = high - low + 1;
		if (length == 1) {
			return a[low];
		} else {
			int half = low + (length / 2);
			if (length % 2 == 0) {
				return (a[half] + a[half + 1]) / 2.0;
			} else {
				return a[half + 1];
			}
		}
	}

}
