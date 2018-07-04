package practice.cp1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import practice.cp1_3.List.Node;

public class EX29<Item> implements Iterable<Item> {
	private int N;
	private Node last;
	
	public class Node {
		private Item item;
		private Node next;
	}
	
	public EX29(){
		last = null;
	}
	
	public boolean isEmpty() {
		return last == null;
	}
	
	public int size() {
		return N;
	}
	
	public Item peek() {
		if (isEmpty()) throw new RuntimeException("Queue underflow");
		return last.next.item;
	}
	
	public void enqueue(Item item) {
		Node x = new Node();
		x.item = item;
		if (isEmpty())
			x.next = x;
		else {
			x.next = last.next;
			last.next = x;
		}
		last = x;
		N++;
	}
	
	public Item dequeue() {
		if (isEmpty()) throw new RuntimeException("Queue underflow");
		Item item = last.next.item;
		last.next = last.next.next;
		N--;
		return item;
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
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item> {
		private int n = N;
		private Node current = last;
		@Override
		public boolean hasNext() {
			return n > 0;
		}
		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.next.item;
			current = current.next;
			n--;
			return item;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
