package practice.cp1_1;

import edu.princeton.cs.algs4.StdOut;

public class EX19 {
	public static double[] F(int N) {
		double[] fib = new double[N + 1];
		if (N == 0)
			return fib;
		fib[1] = 1;
		if (N == 1)
			return fib;
		for (int i=2; i <= N; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib;
		
	}

	public static void main(String[] args) {
		double[] fibonacci = F(99);
		for (int N = 0; N < fibonacci.length; N++) {
			StdOut.println(N + " " + fibonacci[N]);
		}
	}

}
