package practice.cp1_3;

import java.awt.Frame;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;
import javax.swing.tree.AbstractLayoutCache.NodeDimensions;

import edu.princeton.cs.algs4.StdOut;

public class List<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	
	class Node{
		private Item item;
		private Node next;
	}
	
	public List() {
		first = null;
		last = null;
	}
	
	public List(Item[] a) {
		for (Item t:a) {
			append(t);
		}
	}
	
    public List(Iterable<Item> coll)
    {
        for (Item t : coll)
            append(t);
    }
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public Item first() {
		if (isEmpty()) throw new RuntimeException("List is empty");
		return first.item;
	}
	
	public Item last() {
		if (isEmpty()) throw new RuntimeException("List is empty");
		return last.item;
	}
	
	public Item removeFirst() {
		if (isEmpty()) throw new RuntimeException("List is empty");
		Item res = first();
		first = first.next;
		N--;
		if (isEmpty()) last = null;
		return res;
	}
	
	public void append(Item item) {
		Node n = new Node();
		n.item = item;
		n.next = null;
		if (isEmpty()) {first= n; last = n;}
		else {
			last.next = n;
			last = n;
		}
		N++;
	}
	
	public void prepend(Item item) {
		Node node = new Node();
		node.item = item;
		if (isEmpty()) {first= node; last = node;}
		else {
			node.next = first;
			first = node;
		}
		N++;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item: this) {
			s.append(item + " ");
		}
		return s.toString();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>{
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	/*
	 * Exercise 1.3.19
	 */
	public Item removeLast() {
		if (isEmpty()) throw new RuntimeException("List is empty");
		if (first == last) removeFirst();
		Node pre = null;
		Node current = first;
		while (current.next != null) {
			pre = current;
			current = current.next;
		}
		last = pre;
		pre.next = null;
		N--;
		return last();
	}
	
	/*
	 * Exercise 1.3.20
	 */
	public Item delete(int k) {
		if (k < 1) return null;
		int index = 1;
		Node current = first;
		Node pre = null;
		
		while(index < k && current != null) {
			pre = current;
			current = current.next;
			index++;
		}
		
		if (current != null) {
			if (pre == null) {
				first = current.next;
			}
			else {
				pre.next = current.next;
			}
			
			if (current.next == null) {
				last = pre;
				pre.next = null;
			}
			N--;
			return current.item;
		}
		else {
			return null;
		}
	}
	
	/*
	 * Exercise 1.3.21
	 * rename find() to contains
	 */
	public boolean contains(Item key) {
		Node current = first;
		while (current != null && current.item != key) {
			current = current.next;
		}
		return current != null;
	}
	
	/*
	 * Exercise 1.3.25
	 */
	public void remove(Item item) {
		List<Integer> idx = new List<Integer>();
		int i = 1;
		
		for (Item x: this) {
			if (x.equals(item)) {
				idx.prepend(i);
			}
			i++;
		}
		
		for (int k: idx) {
			delete(k);
		}
	}
	
	private void setLastAndN()
	{
		last = first;
		N = 0;
		if (first != null) {
			N++;
			while (last.next != null) {
				last = last.next;
				N++;
			}
		}
	}
	
	
	/*
	 * Operation on nodes
	 */
	
	
	public Node node(int k) {
		if (k < 1) return null;
		int index = 1;
		Node current = first;
		
		while (index < k && current != null) {
			current = current.next;
			index++;
		}
		return current;
	}
	
	public Node createNode(Item item) {
		Node node = new Node();
		node.item = item;
		return node;
	}
	
	/*
	 * Exercise 1.3.24
	 */
	public void removeAfter(Node node) {
		if (node != null && node.next != null) {
			if (node.next.next == null) {
				last = node;
			}
			node.next = node.next.next;
			N--;
		}
	}
	
	/*
	 * Exercise 1.3.25
	 */
	public void insertAfter(Node a, Node b) {
		if (a != null && b != null) {
			if (last == a) {
				last = b;
			}
			b.next = a.next;
			a.next = b;
		}
	}
	
	/*
	 * Exercise 1.3.27
	 */
	public Item max(Node node) {
		if (node == null) throw new RuntimeException("List is empty");
		return max(node, null);
	}

	public Item max(Node node, Item def) {
		if (node == null) {
			return null;
		}
		
		Node current = node;
		Item max = node.item;
		
		while (current != null) {
			current = current.next;
            if (((Comparable<Item>)max).compareTo(current.item) < 0) {
            	max = current.item;
            }
		}
		return max;
	}
	
	/*
	 * Exercise 1.3.28
	 */
	public Item maxRec(Node node, Item def) {
		if (node == null) {
			return def;
		}
		else
			return maxRec(node);
	}
	
	public Item maxRec(Node node) {
		if (node == null) throw new RuntimeException("List is empty");
		
		if (node.next == null)
			return node.item;
		else {
			Item maxTail = maxRec(node.next);
			return ((Comparable<Item>)node.item).compareTo(maxTail) > 0 ? node.item : maxTail;
		}
	}

	/*
	 * Exercise 1.3.30
	 */
	public void reverse() {
		first = reverse(first);
		setLastAndN();
	}
	
	public Node reverse(Node x) {
		Node first = x;
		Node reverse = null;
		while (first != null) {
			Node second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}
	
	/*
	 * Exercise 1.3.30
	 * Recursive solution
	 */
	public void reverseRec() {
		first = reverseRec(first);
		setLastAndN();
	}
	
	public Node reverseRec(Node first) {
		if (first == null) return null;
		if (first.next == null) return first;
		Node seconde = first.next;
		Node rest = reverseRec(seconde);
		seconde.next = first;
		first.next = null;
		return rest;
	}
	
	public static void main(String[] args) {
		Integer[] a = {1, 2, 2, 3, 4, 5};
		List<Integer> list = new List<Integer>(a);
//		StdOut.println(list.delete(1));
//		StdOut.print(list);
		list.remove(2);
		StdOut.println(list);
		
	}

}
