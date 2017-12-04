package questions;

import java.util.ArrayList;
import java.util.List;

//double start = System.currentTimeMillis();
//ArrayList<ArrayList<Integer>> subSets = CC9_4.getSubset(Arrays.asList(
//		new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 }));
//
//ArrayList<ArrayList<Integer>> subSets = CC9_4.getSubsetsBookSolution(Arrays.asList(
//		new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 }), 0);
////Size: 16777216, took: 33.566s
//
//ArrayList<ArrayList<Integer>> subSets = CC9_4.getSubsetsBookSolution2(Arrays.asList(
//		new Integer[] { 1, 2, 3, 4 }));
////Size: 16777216, took: 17.61s
//
//double end = System.currentTimeMillis();
//
//for (ArrayList<Integer> set : subSets) {
//	System.out.print("{");
//	for (Integer i : set) {
//		System.out.print(i + " ");
//	}
//	System.out.println("}");
//}
//
//System.out.println("Size: " + subSets.size() + ", took: " + (end - start) / 1000 + "s");

public class CC9_4 {

	private static ArrayList<ArrayList<Integer>> subsets;

	// CrackingTheCodinglnterview - 5th edtion - 9.4
	public static ArrayList<ArrayList<Integer>> getSubset(List<Integer> set) {
		subsets = new ArrayList<>();

		getSubsetHelper(set);
		subsets.add(new ArrayList<>()); // empty set;

		return subsets;
	}

	private static ArrayList<ArrayList<Integer>> getSubsetHelper(List<Integer> set) {
		if (set == null || set.isEmpty())
			return new ArrayList<>();
		else {
			ArrayList<ArrayList<Integer>> newSets = new ArrayList<>();
			ArrayList<Integer> current = new ArrayList<>();
			current.add(set.get(0));
			subsets.add(new ArrayList<>(current));
			newSets.add(current);

			ArrayList<ArrayList<Integer>> newSubSets = new ArrayList<>();

			newSubSets = getSubsetHelper(set.subList(1, set.size()));

			for (ArrayList<Integer> newSet : newSubSets) {
				newSets.add(new ArrayList<>(newSet));
				newSet.add(set.get(0)); // there's no need to be in the start
				newSets.add(newSet);
				subsets.add(new ArrayList<>(newSet));
			}

			return newSets;
		}
	}
	
	//BOOK SOLUTION 1

	public static ArrayList<ArrayList<Integer>> getSubsetsBookSolution(List<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) { // Base case - add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		} else {
			allsubsets = getSubsetsBookSolution(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	//END BOOK SOLUTION 1
	
	//BOOK SOLUTION 2
	
	public static ArrayList<ArrayList<Integer>> getSubsetsBookSolution2(List<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2 A n */
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}

	private static ArrayList<Integer> convertIntToSet(int x, List<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;

		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

	//END BOOK SOLUTION 2
}
