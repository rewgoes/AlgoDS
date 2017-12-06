package questions;

public class LC_106 {

	// int[] inOrder = new int[] { 4, 2, 5, 1, 6, 3, 7 };
	// int[] postOrder = new int[] { 4, 5, 2, 6, 7, 3, 1 };
	//
	// LC_106.buildTree(inOrder, postOrder);

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;
		return helper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
	}

	public static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
		if (inStart > inEnd || postEnd < 0) {
			return null;
		}

		// The last element (postEnd) in the postorder array is always the root
		TreeNode root = new TreeNode(postorder[postEnd]);

		// Find the element postorder[postEnd] in the inorder array, starting at inStart
		int inPos = inStart;
		while (inorder[inPos] != postorder[postEnd]) {
			inPos++;
		}

		// Find the left side: from inorder[inStart] to inorder[inPos - 1], root will
		// be: postEnd - (inEnd - inPos) - 1
		root.left = helper(inorder, postorder, inStart, inPos - 1, postEnd - (inEnd - inPos) - 1);

		// Find the right side: from inorder[inPos + 1] to inorder[inEnd], root will be:
		// postEnd - 1
		root.right = helper(inorder, postorder, inPos + 1, inEnd, postEnd - 1);

		return root;
	}

}
