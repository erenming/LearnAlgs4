package practice.cp4_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPahts {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;    // marked[v] = is there an s-v path
	private int[] edgeTo;        // edgeTo[v] = previous edge on shortest s-v path
	private int[] distTo;        // distTo[v] = number of edges shortest s-v path
	
	public BreadthFirstPahts(Graph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
		
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		distTo[s] = 0;
		queue.enqueue(s);
		while (!queue.isEmpty())
		{
			int v = queue.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					distTo[w] = distTo[v] + 1;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x = v; distTo[x] != 0; x = edgeTo[x])
		{
			path.push(x);
		}
		path.push(x);
		return path;
	}
}
