package practice.cp4_1;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class CC {
	private boolean[] marked;
	private int[]     id;   // id[v] = id of connected component containing v
	private int[]     size; // size[v] = number of vertices in component containing v
	private int       count; // number of connected component
	
	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}
	
	// depth first search
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		size[v]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public int count() {
		return count;
	}
}
