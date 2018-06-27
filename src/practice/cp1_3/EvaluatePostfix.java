package practice.cp1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Double> vals = new Stack<Double>();

		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			
			if      (s.equals("+")) vals.push(vals.pop() + vals.pop());
			else if (s.equals("-")) vals.push(-vals.pop() + vals.pop());
			else if (s.equals("*")) vals.push(vals.pop() * vals.pop());
			else if (s.equals("/")) vals.push(1/vals.pop() * vals.pop());
			else    vals.push(Double.parseDouble(s));
		}
		StdOut.print(vals.pop());
	}

}
