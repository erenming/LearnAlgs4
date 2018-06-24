package practice.cp1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {
	private Item[] a;
	private int N;
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	public boolean isEmpty() {
		return 0 == N;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapacityStack<String> s;
		s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			}
			else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}

}
