package practice.cp1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

	public static void main(String[] args) {
		Stack<String> par = new Stack<String>();
		boolean flag = true;
		while (!StdIn.isEmpty()) {
			String s =StdIn.readString();
			if (s.equals("("))      par.push(s);
			else if (s.equals("[")) par.push(s);
			else if (s.equals("{")) par.push(s);
			else {
				String top = par.pop();
				if      (top.equals("(") && s.equals(")")) continue;
				else if (top.equals("[") && s.equals("]")) continue;
				else if (top.equals("{") && s.equals("}")) continue;
				else {
					flag = true;
					break;
				}
			}
		}
		if (flag == true) {
			if (par.isEmpty()) {
				StdOut.println("true");
			}
			else {
				StdOut.println("flase");
			}
		}
		else {
			StdOut.println("flase");
		}
		
	}

}
