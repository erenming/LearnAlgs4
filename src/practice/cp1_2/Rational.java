package practice.cp1_2;

import edu.princeton.cs.algs4.StdIn;


public class Rational {
	private final int numerator;
	private final int denominator;
	private static int MAX = 2147483647;
	private static int MIN = -2147483647;
	
	public Rational(int n, int d) throws ArithmeticException {
		if (d == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		if (d < 0) {
			n -= n;
			d -= d;
		}
		int commonDivisor = euclid(n, d);
		numerator = n / commonDivisor;
		denominator = d / commonDivisor;
	}
	
	private int euclid(int p, int q) {
		if (p == 0 || q == 0) {
			return 1;
		}
		p = Math.abs(p);
		q = Math.abs(q);
		if (p < q) {
			int t = p;
			p = q;
			q = t;
		}
		if (p % q == 0) {
			return q;
		} else {
			return euclid(q, p % q);
		}
	}
	
	public Rational plus(Rational b) {
		assert isPlusOverflow(numerator * b.denominator, b.numerator * denominator) : "Plus overflow";
		assert isTimesOverflow(denominator, b.denominator) : "Times overflow";
		return new Rational(numerator * b.denominator + denominator * b.numerator, denominator*b.denominator);
	}
	
	private boolean isTimesOverflow(int a, int b) {
		if (a < 0) {
			a = -a;
		}
		if (b < 0) {
			b = -b;
		}
		if (a ==0 || b == 0) {
			return false;
		}else {
			return a * b < MAX;
		}
	}

	private boolean isPlusOverflow(int i, int j) {
		return i >= 0 ? i + j < MAX: i + j > MIN;
	}

	public Rational minus(Rational b) {
		assert isTimesOverflow(denominator, b.denominator) : "Times overflow";
		return new Rational(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
	}
	
	public Rational divides(Rational b) {
		assert isTimesOverflow(denominator, b.numerator) : "Times overflow";
		assert isTimesOverflow(numerator, b.denominator) : "Times overflow";
		return new Rational(numerator * b.denominator, denominator * b.numerator);
	}
	
	public Rational times(Rational b) {
		assert isTimesOverflow(numerator, b.numerator) : "Times overflow";
		assert isTimesOverflow(denominator, b.denominator) : "Times overflow";
		return new Rational(numerator * b.numerator, denominator * b.denominator);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Rational that = (Rational) obj;
		if (this.numerator != that.numerator) {
			return false;
		}
		if (this.denominator != that.denominator) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		if (Math.abs(numerator) % Math.abs(denominator) == 0) {
			return String.valueOf(numerator / denominator);
		} else {
			return numerator + "/" + denominator;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Rational a:");
		System.out.print("numerator: ");
		int numerator = StdIn.readInt();
		System.out.print("denominator: ");
		int denominator = StdIn.readInt();
		Rational a = new Rational(numerator, denominator);
		System.out.println("Rational b:");
		System.out.print("numerator: ");
		numerator = StdIn.readInt();
		System.out.print("denominator: ");
		denominator = StdIn.readInt();
		Rational b = new Rational(numerator, denominator);
		System.out.println("a plus b: " + a.plus(b));
		System.out.println("a minus b: " + a.minus(b));
		System.out.println("a times b: " + a.times(b));
		System.out.println("a divides b: " + a.divides(b));
		System.out.println("a equals b: " + a.equals(b));
	}

}
