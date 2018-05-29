package practice.cp1_1;

import edu.princeton.cs.algs4.StdIn;

public class EX30 {
	public static int isCoprime(int p, int q) {
		if (p == 0 || q == 0) {
			return 1;
		}
		if (p == 1 && q == 1) {
			return 1;
		}
		if (p < q)
		{
			int t = q;
			q = p;
			p = t;
		}
		if (p % q == 0)
		{
			return q;
		}
		else {
			return isCoprime(q, p % q);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
		boolean[][] a = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = isCoprime(i, j) == 1;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
