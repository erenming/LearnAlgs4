package practice.cp3_4;

import java.awt.Checkbox;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int N;                 // number of key-value pairs in the symbol table
    private int M;
    private Key[] keys;
    private Value[] vals;
    
    public LinearProbingHashST() {
		this(INIT_CAPACITY);
	}
    
    // create linear proving hash table of given capacity
    public LinearProbingHashST(int capacity) {
        M = capacity;
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
    }
    
    private int hash(Key key) {
    	return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public int size() {
		return N;
	}
    
    private void resize(int capacity) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null) {
				temp.put(keys[i], vals[i]);
			}
		}
		keys = temp.keys;
		vals = temp.vals;
		M = temp.M;
	}
    
    public void put(Key key, Value val) {
		if (N >= M/2) resize(2*M);
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
    
    public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				return vals[i];
			}
		}
		return null;
	}
    
    public boolean contains(Key key) {
		return get(key) != null;
	}
    
    public void delete(Key key) {
		if (!contains(key)) return;
		
		// find position of key
		int i = hash(key);
		while (!key.equals(keys[i])) {
			i = (i + 1) % M;
		}
		
		// delete key and associated vale
		keys[i] = null;
		vals[i] = null;
		
		// rehash all keys in same cluster
		i = (i + 1) % M;
		while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
			Key    keyToRefresh = keys[i];
			Value  valToRefresh = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRefresh, valToRefresh);
			i = (i + 1) % M;
		}
		N--;
		
		if (N > 0 && N <= M/8) resize(M/2);
		
		assert check();
	}
    
    public Iterable<Key> keys() {
    	Queue<Key> queue = new Queue<Key>();
    	for (int i = 0; i < M; i++) {
    		if (keys[i] != null) queue.enqueue(keys[i]);
    	}
    	return queue;
    }
    
    // integrity check - don't check after each put() because
    // integrity not maintained during a delete()
    private boolean check() {
    	// check that hash is at most %50 full
    	if (M < 2*N) {
    		System.err.println("Hash table size M = " + M + "; array size N = " + N);
    		return false;
    	}
    	
    	// check that each key in table can by found by key
    	for (int i = 0; i < M; i++) {
    		if (keys[i] == null) continue;
    		else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
    		}
    	}
    	return true;
    }
}
