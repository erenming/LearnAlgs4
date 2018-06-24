package practice.cp1_3;

import java.util.Iterator;

public class ResizingArraysStack<Item> implements Iterable<Item>{
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	public void push(Item item) {
		if (N == a.length) resize(a.length * 2);
		a[N++] = item;
	}
	public Item pop() {
		Item item = a[--N];
		a[N] = null;   // ±ÜÃâ¶ÔÏóÓÎÀë
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		@Override
		public boolean hasNext() { return i > 0;}
		@Override
		public Item next() {
			return a[--N];
		}
		@Override
		public void remove() {
			
		}
	}
}
