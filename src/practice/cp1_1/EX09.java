package practice.cp1_1;

import edu.princeton.cs.algs4.StdOut;

public class EX09 {

	public EX09() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		for (int i = 18; i > 0; i /= 2)
		{
			s = (i % 2) + s;
		}
		StdOut.print(s);

	}

}
