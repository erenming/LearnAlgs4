package practice.cp2_5;

public class Record<Item> implements Comparable<Record> {
	private int N;
	private Item key;
	
	public Record(Item key) {
		this.key = key;
		N = 1;
	}
	
	public void addFreq() {
		N++;
	}
	
	public Item getWord() {
		return key;
	}
	
	public int getFreq() {
		return N;
	}

	@Override
	public int compareTo(Record o) {
		if (N > o.getFreq()) {
			return 1;
		} else if (N < o.getFreq()) {
			return -1;
		} else {
			return 0;
		}
	}
}
