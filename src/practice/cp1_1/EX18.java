package practice.cp1_1;

public class EX18 {
	public static int mystery(int a, int b) {
		if (b == 0) return 1;
		if (b % 2 == 0) return mystery(a + a, b/2);
		return mystery(a+a, b/2) * a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		System.out.println(mystery(2, 25));
		System.out.println(mystery(3, 11));
	}

}
