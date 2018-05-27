package practice.cp1_1;

public class EX14 {
	private static int lg(int n) {
		int shiftRightCount = 0;
		do {
			n >>= 1;
			shiftRightCount += 1;
		} while (n != 0);
		return shiftRightCount - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int value = 1025;
        System.out.printf("the result of method log is :%s\r\n", lg(value));
	}

}
