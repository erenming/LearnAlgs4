package practice.cp2_2;

import edu.princeton.cs.algs4.StdOut;

public class InPlace {
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) return false;
		}
		return true;
	}
	
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		Comparable[] aux = new Comparable[a.length];
		
		for (int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++)
		{
			if      (i > mid)          a[k] = aux[j++];
			else if (j > hi)           a[k] = aux[i++];
			else if (less(a[j], a[i])) a[k] = aux[j++];
			else					   a[k] = aux[i++];
		}
	}
	
	public static void main(String[] args) {
		

	}

}
