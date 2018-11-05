package practice.cp3_4;

public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int N;
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
    
    private void resize() {
		
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
}
