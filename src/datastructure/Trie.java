package datastructure;

public class Trie {

	// Trie - Prefix Tree
	//https://leetcode.com/problems/implement-trie-prefix-tree/description/
	// LC 208
	
	Trie[] nodes = new Trie[26];
	boolean isWord = false;

	/** Initialize your data structure here. */
	public Trie() {
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie current = this;
		int index;
		for (char c : word.toCharArray()) {
			index = c - 'a';
			if (current.nodes[index] == null) {
				current.nodes[index] = new Trie();
			}
			current = current.nodes[index];
		}
		current.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie current = this;
		int index;
		for (char c : word.toCharArray()) {
			index = c - 'a';
			if (current.nodes[index] == null) {
				return false;
			}
			current = current.nodes[index];
		}
		return current.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie current = this;
		int index;
		for (char c : prefix.toCharArray()) {
			index = c - 'a';
			if (current.nodes[index] == null) {
				return false;
			}
			current = current.nodes[index];
		}
		return true;
	}

}
