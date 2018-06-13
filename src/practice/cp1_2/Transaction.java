package practice.cp1_2;

import edu.princeton.cs.algs4.Date;

public class Transaction {
	private String who;
	private Date when;
	private double amount;
	
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	public String getWho() {
		return who;
	}
	
	public Date getWhen() {
		return when;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setWho(String who) {
		this.who = who;
	}
	
	public void setWhen(Date when) {
		this.when = when;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
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
		Transaction that = (Transaction) obj;
		if (!this.who.equals(that.who)) {
			return false;
		}
		if (!this.when.equals(that.when)) {
			return false;
		}
		if (this.amount != that.amount) {
			return false;
		}
		return true;
	}
	
	public Transaction(String transaction) {
		String[] fileds = transaction.split("\\s+");
		who = fileds[0];
		when = new Date(fileds[1]);
		amount = Double.parseDouble(fileds[2]);
	}
	
	public static void main(String[] args) {
		Transaction t1 = new Transaction("Turing", new Date(5, 22, 1939), 11.99);
		Transaction t2 = new Transaction("Turing 5/22/1939 11.99");
		System.out.println(t1.equals(t2));

	}

}
