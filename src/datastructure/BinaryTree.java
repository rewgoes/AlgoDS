package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class BinaryTree {

	private Node head;

	public void add(int value) {
		if (head == null) {
			head = new Node(value);
		} else {
			add(value, head);
		}
	}

	private void add(int value, Node node) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node(value);
			} else {
				add(value, node.left);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(value);
			} else {
				add(value, node.right);
			}
		}
	}

	public boolean hasValue(int value) {
		return hasValue(value, head);
	}

	private boolean hasValue(int value, Node node) {
		if (node == null) {
			return false;
		} else {
			if (node.value == value) {
				return true;
			} else if (value > node.value) {
				return hasValue(value, node.right);
			} else {
				return hasValue(value, node.left);
			}
		}
	}

	public String preOrder() {
		return preOrder(head);
	}

	private String preOrder(Node node) {
		if (node != null) {
			String result = Integer.toString(node.value);
			String left = preOrder(node.left);
			String right = preOrder(node.right);

			if (left != null) {
				result += " " + left;
			}

			if (right != null) {
				result += " " + right;
			}

			return result;
		} else {
			return null;
		}
	}

	public String inOrder() {
		return inOrder(head);
	}

	private String inOrder(Node node) {
		if (node != null) {
			String result = Integer.toString(node.value);
			String left = inOrder(node.left);
			String right = inOrder(node.right);

			if (left != null) {
				result = left + " " + result;
			}

			if (right != null) {
				result += " " + right;
			}

			return result;
		} else {
			return null;
		}
	}

	public String postOrder() {
		return postOrder(head);
	}

	private String postOrder(Node node) {
		if (node != null) {
			String result = Integer.toString(node.value);
			String left = postOrder(node.left);
			String right = postOrder(node.right);

			if (right != null) {
				result = right + " " + result;
			}

			if (left != null) {
				result = left + " " + result;
			}

			return result;
		} else {
			return null;
		}
	}

	public String diagonalTransverse() {
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

		diagonalTransverse(hashMap, head, 1);

		String result = "";
		for (Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
			for (int value : entry.getValue()) {
				result += value + " ";
			}
		}

		return result;
	}

	private void diagonalTransverse(HashMap<Integer, ArrayList<Integer>> hashMap, Node node, int index) {
		if (node != null) {
			ArrayList<Integer> list = hashMap.get(index);

			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(node.value);
			hashMap.put(index, list);

			diagonalTransverse(hashMap, node.left, index + 1);

			diagonalTransverse(hashMap, node.right, index);
		}
	}
	
	public String breadthSearch() {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(head);
		return breadthSearch(queue);
	}
	
	private String breadthSearch(Queue<Node> queue) {
		Node node = queue.poll();
		if (node != null) {
			queue.add(node.left);
			queue.add(node.right);
			String child = breadthSearch(queue);
			if (child == null) {
				return Integer.toString(node.value);
			} else {
				return node.value + " " + child;				
			}
		}
		return null;
	}

	class Node {
		private int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

}
