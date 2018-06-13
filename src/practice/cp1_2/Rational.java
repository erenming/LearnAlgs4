package practice.cp1_2;

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
		
	}
	
	public Rational minus(Rational b) {
		
	}
	
	public Rational minus(Rational b) {
		
	}
	
	public Rational divides(Rational b) {
		
	}
	
	@Override
	public boolean equals() {
		
	}
	
	@Override
	public String toString() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
