package practice.cp3_5;

import java.util.HashSet;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DeDup {
	public static void main(String[] args) {
		HashSet<String> set;
		set = new HashSet<String>();
		while (!StdIn.isEmpty())
		{
			String key = StdIn.readString();
			if (!set.contains(key))
			{
				set.add(key);
				StdOut.print(key + " ");
			}
		}
	}
}
