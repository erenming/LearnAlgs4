package practice.cp1_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX08 {
	public static int rank(int key, int[] a, Counter counter) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi)
		{
			counter.increment();
			int mid = (lo + hi) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] whiltelist = In.readInts(args[0]);
		Counter counter = new Counter("bCounter");
		Arrays.sort(whiltelist);
		StdOut.println(rank(StdIn.readInt(), whiltelist, counter));
		StdOut.println("key has been call "+counter.tally()+" times");
	}
}
