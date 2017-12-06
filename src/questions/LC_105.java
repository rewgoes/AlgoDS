package questions;

public class LC_105 {	

//	int[] inOrder = new int[] { 4, 2, 5, 1, 6, 3, 7 };
//	int[] preOrder = new int[] { 1, 2, 4, 5, 3, 6, 7 };
//
//	LC_105.buildTree(preOrder, inOrder);

	//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		return helper(preorder, inorder, 0, inorder.length - 1, 0);
	}

	public static TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart) {
		if (inStart > inEnd || preStart > preorder.length - 1) {
            return null;
        }
        
		// The first element (preStart) in the preorder array is always the root
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // Find the element preorder[preStart] in the inorder array, starting at inStart
        int inPos = inStart; 
        while (inorder[inPos] != preorder[preStart]) {
            inPos++;
        }
        
        // Find the left side: from inorder[inStart] to inorder[inPos - 1]
        root.left = helper(preorder, inorder, inStart, inPos - 1, preStart + 1);
        
        // Find the right side: from inorder[inPos + 1] to inorder[inEnd]
        root.right = helper(preorder, inorder, inPos + 1, inEnd, preStart + (inPos - inStart) + 1);
        
        return root;
	}

}
