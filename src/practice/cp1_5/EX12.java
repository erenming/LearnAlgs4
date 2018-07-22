package practice.cp1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX12 {
	private int[] id;
	private int count;

	public EX12(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int find(int p) {
		int root = p;
		while (root != id[root]) {
			root = id[root];
		};
		while (id[p] != root) {
			int tmp = p;
			p = id[p];
			id[tmp] = root;
		}
		return root;
	}
	
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (qRoot == pRoot) return;
		id[qRoot] = pRoot;
		count--;
	}
	
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		EX12 uf = new EX12(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
	}

}
