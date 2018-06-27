package practice.cp1_3;

public class ResizingArrayQueueOfStrings {
	private String[] a = new String[1];
	private int N = 0;
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int Size() {
		return N;
	}
	
	private void resize(int max) {
		String[] temp = new String[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void enqueue(String s) {
		if (N == a.length) resize(a.length * 2);
		a[N++] = s;
	}
	
	public String dequeue() {
		String item = a[0];
		for (int i = 0; i < N; i++) {
			a[i] = a[i + 1];
		}
		N--;
		if (N > 0 && a.length < N/4) resize(a.length / 2);
		return item;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
