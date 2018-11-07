package practice.cp3_4;

import edu.princeton.cs.algs4.Queue;
import practice.cp3_1.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 997;

	private int N;                                  //  number of key-value pairs
	private int M;									// hash table size
	private SequentialSearchST<Key, Value>[] st;    // array of linked-list symbol tables
	
	public SeparateChainingHashST() {
		this(INIT_CAPACITY);
	}
	
	// create separate chaining hash table with M lists
	public SeparateChainingHashST(int M) {
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}
	
	private void resize(int chains) {
		SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
		for (int i = 0; i < M; i++) {
			for (Key key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}
		this.M = temp.M;
		this.N = temp.N;
		this.st = temp.st;
	}
	
	// hash value between 0 and M -1
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	// return value associated with key, null if no such key
	public Value get(Key key) {
		int i = hash(key);
		return st[i].get(key);
	}
	
	public void delete(Key key) {
		int i = hash(key);
		if (st[i].contains(key)) N--;
		st[i].delete(key);
        if (M > INIT_CAPACITY && N <= 2*M) resize(M/2);
	}
	
	public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
		
		st[hash(key)].put(key, val);
        // double table size if average length of list >= 10
        if (N >= 10*M) resize(2*M);
	}
	
    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    } 
}
