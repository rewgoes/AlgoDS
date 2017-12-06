package questions;

import java.util.Stack;

public class LC_230 {
	
	//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
	
	// TreeNode root = new TreeNode(10);
	// root.left = new TreeNode(5);
	// root.left.left = new TreeNode(1);
	// root.left.right = new TreeNode(8);
	// root.left.left.right = new TreeNode(3);
	// root.right = new TreeNode(15);
	// root.right.left = new TreeNode(11);
	// root.right.left.right = new TreeNode(13);
	// root.right.right = new TreeNode(17);
	// root.right.right.left = new TreeNode(16);
	//
	// System.out.println(LC_230.kthSmallest(root, 10));

	public static class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1;
	}

}
