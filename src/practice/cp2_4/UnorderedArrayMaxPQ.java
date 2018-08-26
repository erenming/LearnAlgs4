package practice.cp2_4;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	
	public UnorderedArrayMaxPQ(int maxN) {
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
		pq[++N] = v;
	}
	
	public Key delMax() {
		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(max, i)) {
				max = i;
			}	
		}
		exch(max, N-1);
		Key key = pq[--N];
		pq[N] = null;
		return key;
	}
}
