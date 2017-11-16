
import datastructure.BinaryTree;
import questions.DecompressString;
import sort.SortUtils;

public class Main {

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(8);
		binaryTree.add(3);
		binaryTree.add(10);
		binaryTree.add(9);
		binaryTree.add(1);
		binaryTree.add(6);
		binaryTree.add(4);
		binaryTree.add(7);
		binaryTree.add(14);
		binaryTree.add(13);
		
		System.out.println("Binary tree");
		System.out.println(binaryTree.diagonalTransverse());
		
		int[] test = {1, 2, 3, 2};
		SortUtils.quickSort(test);
		
		System.out.println("");
		System.out.println("Quicksort:");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		

		System.out.println("\n");
		String string = "32[]";		
		System.out.println(DecompressString.solution(string));
	}

}
