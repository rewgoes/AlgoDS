import questions.LC_230;
import questions.LC_230.TreeNode;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.left.left.right = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(11);
		root.right.left.right = new TreeNode(13);
		root.right.right = new TreeNode(17);
		root.right.right.left = new TreeNode(16);

		System.out.println(LC_230.kthSmallest(root, 10));

		long end = System.currentTimeMillis();

		System.out.println("\n\n\n");
		System.out.printf("Took: %d\n", end - start);

	}

}
