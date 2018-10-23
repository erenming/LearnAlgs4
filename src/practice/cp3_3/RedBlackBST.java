package practice.cp3_3;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {
		Key key;
		Value val;
		Node left, right;
		int N;
		boolean color;
		
		Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x) {
		if (x == null) return false;
		return x.color == RED;	
	}
}
