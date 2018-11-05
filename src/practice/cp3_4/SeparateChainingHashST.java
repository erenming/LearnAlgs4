package practice.cp3_4;

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
	
	// hash value between 0 and M -1
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	// return value associated with key, null if no such key
	public Value get(Key key) {
		int i = hash(key);
		return st[i].get(key);
	}
	
	public void put(Key key, Value val) {
		st[hash(key)].put(key, val);
	}
}
