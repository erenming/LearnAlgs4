package practice.cp2_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
	private int N;
	private int[] pq;    // binary heap using 1-based indexing
	private int[] qp;    // reverse of pq
	private Key[] keys;  // keys[i] = priority of i
	
	public IndexMinPQ(int NMAX) {
		keys = (Key[]) new Comparable[NMAX + 1];
		pq = new int[NMAX + 1];
		qp = new int[NMAX + 1];
		for (int i = 0; i<=NMAX; i++) qp[i] = -1;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean contains(int k) {
		return qp[k] != -1;
	}
	
	public int size() {
		return N;
	}
	
	// associate key with index k
	public void insert(int k, Key key) {
		if (contains(k)) throw new RuntimeException("item is already in pq");
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}

	// return the associated index of minimal key
	public int min() {
		if (N == 0 ) throw new RuntimeException("Priority queue underflow");
		return pq[1];
	}
	
	// delete minimal key and return its associated index
	public int delMin() {
		if (N == 0) throw new RuntimeException("Priority queue underflow");
		int min = pq[1];
		exch(1, N--);
		sink(1);
		qp[min] = -1;
		keys[pq[N+1]] = null;
		pq[N+1] = -1;
		return min;
	}
	
	public void change(int k, Key key) {
		if (!contains(k)) throw new RuntimeException("item is not in pq");
		keys[k] = key;
		swim(qp[k]);
		sink(qp[k]);
	}
	
	public void decrease(int k, Key key) {
        if (!contains(k)) throw new RuntimeException("item is not in pq");
        if (keys[k].compareTo(key) <= 0) throw new RuntimeException("illegal decrease");
        keys[k] = key;
        swim(qp[k]);
	}
	
	public void increase(int k, Key key) {
        if (!contains(k)) throw new RuntimeException("item is not in pq");
        if (keys[k].compareTo(key) >= 0) throw new RuntimeException("illegal decrease");
        keys[k] = key;
        sink(qp[k]);
	}
	
	private boolean greater(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}
	
	private void exch(int i, int j) {
		int swap = pq[i]; pq[i] = pq[j];pq[j] = swap;
		qp[pq[i]] = i; qp[pq[j]] = j;
	}
	
	private void swim(int k) {
		while (k > 1 && greater(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while (2*k < N) {
			int j = k*2;
			if (j < N && greater(j, j+1)) {
				j++;
			}
			if (greater(j, k)) break;
			exch(j, k);
			k = j;
		}
	}
	
	// Iterator
	public Iterator<Integer> iterator() { return new HeapIterator(); }
	
	private class HeapIterator implements Iterator<Integer> {
		// create a new pq
		private IndexMinPQ<Key> copy;
		
		public HeapIterator() {
			copy = new IndexMinPQ<Key>(pq.length - 1);
			for (int i = 1; i <= N; i++) {
				copy.insert(pq[i], keys[pq[i]]);
			}
		}
		
		public boolean hasNext() {
			return !copy.isEmpty();
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Integer next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.delMin();
		}
	}
	
	public static void main(String[] args) {
		String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };
		
		IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
		for (int i = 0; i < strings.length; i++) {
			pq.insert(i, strings[i]);
		}
		
		while (!pq.isEmpty()) {
			int i = pq.delMin();
			StdOut.println(i + " " + strings[i]);
		}
		StdOut.println();
		
		for (int i = 0; i < strings.length; i++) {
			pq.insert(i, strings[i]);
		}
		for (int i: pq) {
			StdOut.println(i + " " + strings[i]);
		}
        while (!pq.isEmpty()) {
            pq.delMin();
        }
	}
}
