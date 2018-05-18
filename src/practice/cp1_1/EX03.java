package practice.cp1_1;

import edu.princeton.cs.algs4.StdIn;

public class EX03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = StdIn.readInt();
		int b = StdIn.readInt();
		int c = StdIn.readInt();
		
		if (a == b && b == c) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}

}
