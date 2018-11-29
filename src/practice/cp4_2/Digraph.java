package practice.cp4_2;

import javax.management.RuntimeErrorException;

import edu.princeton.cs.algs4.In;


import edu.princeton.cs.algs4.Bag;

public class Digraph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public Digraph(int V) {
		if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
    public Digraph(In in) {
        this(in.readInt()); 
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w); 
        }
    }
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public Digraph reverse() {
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++) {
			for (int w : adj(v))
				R.addEdge(w, v);
		}
		return R;
	}
}
