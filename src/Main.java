
import datastructure.BinaryTree;

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

		System.out.println(binaryTree.diagonalTransverse());

	}

}
