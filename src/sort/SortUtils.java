package sort;

public class SortUtils {
	
	public static void quickSort(int[] array) {
		if (array != null) {
			quickSort(array, 0, array.length - 1);
		}
	}

	private static void quickSort(int[] array, int lo, int hi) {
		if (lo < hi) {
			int index = partition(array, lo, hi);
			quickSort(array, lo, index - 1);
			quickSort(array, index + 1, hi);			
		}
	}
	
	private static int partition(int[] array, int lo, int hi) {
		int temp;
		
		while (lo < hi) {
			if (array[lo] > array[hi]) {
				temp = array[hi];
				array[hi] = array[lo];
				array[lo] = array[hi - 1];
				array[hi - 1] = temp;
				hi--;
			} else {
				lo++;
			}
		}
		
		return hi;
	}
	
}
