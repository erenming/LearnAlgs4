package practice.cp1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
