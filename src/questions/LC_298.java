package questions;

public class LC_298 {
	
	//https://hbisheng.gitbooks.io/leetcode-google/content/298-binary-tree-longest-consecutive-sequence.html
	//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence

	// LC_298.TreeNode root = new LC_298.TreeNode(3);
	// LC_298.TreeNode r = new LC_298.TreeNode(5);
	// LC_298.TreeNode rr = new LC_298.TreeNode(6);
	// LC_298.TreeNode rrr = new LC_298.TreeNode(7);
	// LC_298.TreeNode l = new LC_298.TreeNode(4);
	// LC_298.TreeNode lr = new LC_298.TreeNode(5);
	// LC_298.TreeNode lrl = new LC_298.TreeNode(10);
	// LC_298.TreeNode lrlr = new LC_298.TreeNode(11);
	// LC_298.TreeNode lrr = new LC_298.TreeNode(10);
	// LC_298.TreeNode lrrr = new LC_298.TreeNode(12);
	// LC_298.TreeNode ll = new LC_298.TreeNode(6);
	// LC_298.TreeNode llr = new LC_298.TreeNode(7);
	// LC_298.TreeNode llrr = new LC_298.TreeNode(8);
	// LC_298.TreeNode lll = new LC_298.TreeNode(7);
	// LC_298.TreeNode llll = new LC_298.TreeNode(8);
	// LC_298.TreeNode llllr = new LC_298.TreeNode(4);
	// LC_298.TreeNode llllrr = new LC_298.TreeNode(5);
	// LC_298.TreeNode llllrrr = new LC_298.TreeNode(6);
	// LC_298.TreeNode llllrrrr = new LC_298.TreeNode(7);
	// root.right = r;
	// r.right = rr;
	// rr.right = rrr;
	// root.left = l;
	// l.left = ll;
	// l.right = lr;
	// lr.left = lrl;
	// lr.right = lrr;
	// lrl.right = lrlr;
	// lrr.right = lrrr;
	// ll.left = lll;
	// ll.right = llr;
	// llr.right = llrr;
	// ll.left = lll;
	// lll.left = llll;
	// llll.right = llllr;
	// llllr.right = llllrr;
	// llllrr.right = llllrrr;
	// llllrrr.right = llllrrrr;
	//
	// System.out.println(LC_298.longestConsecutive(root));

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public static int longestConsecutive(TreeNode root) {
		return longestConsecutive(root, root.val - 1, 0);
	}

	private static int longestConsecutive(TreeNode node, int parentVal, int parentCount) {
		if (node == null) {
			return 0;
		} else {
			int sequence = node.val == parentVal + 1 ? parentCount + 1 : 1;

			return max(sequence, longestConsecutive(node.left, node.val, sequence),
					longestConsecutive(node.right, node.val, sequence));
		}
	}

	private static int max(int a, int b, int c) {
		if (a > b)
			if (a > c)
				return a;
			else
				return c;
		if (b > c)
			return b;
		else
			return c;
	}
}
