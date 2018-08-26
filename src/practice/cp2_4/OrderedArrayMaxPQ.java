package practice.cp2_4;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	public OrderedArrayMaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN];
	}
	public boolean idEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	public void insert(Key v) {
		int i = N-1;
		for (; i>0 && pq[i].compareTo(v) > 0; i--) {
			pq[i+1]= pq[i];
		}
		pq[i+1] = v;
		N++;
	}
	
	public Key delMax() {
		Key key = pq[--N];
		pq[N] = null;
		return key;
	}
}
