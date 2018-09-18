package practice.cp3_1;

import java.awt.Container;

import javax.swing.SpringLayout.Constraints;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	public BinarySearchST(int capacity)
	{
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Comparable[capacity];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public Value get(Key key) {
		if (isEmpty()) return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) return vals[i];
		else 									  return null;
		
	}
	
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo);
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) hi = mid + 1;
			else if (cmp > 0) lo = mid - 1;
			else return mid;
		}
		return lo;
	}
	
	public void put(Key key, Value val)
	{
		if (val == null) {delete(key); return;}
		
		int i = rank(key);
		
		if (i < N && keys[i].compareTo(key) == 0)
		{ vals[i] = val; return;}
		
		if (N == keys.length) resize(2*keys.length);
		
		for (int j = N; j > i; j--)
		{
			keys[j] = keys[j-1]; vals[j] = vals[j-1];
		}
		keys[i] = key; vals[i] = val;
		N++;
	}
	
	private void resize(int capacity) {
		assert capacity >= N;
		Key[] tmpk = (Key[]) new Comparable[capacity];
		Value[] tmpv = (Value[]) new Object[capacity];
		for (int i = 0; i < N; i++)
		{
			tmpk[i] = keys[i];
			tmpv[i] = vals[i];
		}
		vals = tmpv;
		keys = tmpk;
	}
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[N-1];
	}
	
	public Key select(int k) {
		return keys[k];
	}
	
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
	
	public Key floor(Key key) {
		// practice 3.1.17
		int i  = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) return keys[i];
		if (i == 0) return null;
		else return keys[i - 1];
	}
	
	public void delete(Key key)
	{
		// practice 3.1.16
		if (isEmpty()) return;
		
		int i = rank(key);
		
		// key not in table
		if (i== N || keys[i].compareTo(key) != 0) return;
		
		for (int j = i; j < N - 1; j++) {
			keys[j] = keys[j+1];
			vals[j] = vals[j+1];
		}
		N--;
		keys[N] = null;
		vals[N] = null;
		
		// resize if 1/4 full
		if (N > 0 && N == keys.length/4) resize(2*keys.length);
		
		assert check();
		
	}
	
   /*****************************************************************************
    *  Check internal invariants
    *****************************************************************************/

    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }
	
	public Iterable<Key> keys(Key lo, Key hi)
	{
		Queue<Key> q = new Queue<Key>();
		for (int i = rank(lo); i < rank(hi); i++) {
			q.enqueue(keys[i]);
		}
		if (contains(hi))
			q.enqueue(keys[rank(hi)]);
		return q;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
}
