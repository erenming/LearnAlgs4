package practice.cp1_1;

public class EX20 {
	public static double ln(int N) {
		if (N == 0) {
			return 0;
		}
		else {
			return Math.log(N) + ln(N - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ln(10));
	}

}
