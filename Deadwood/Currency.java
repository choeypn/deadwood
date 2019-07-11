package Deadwood;

public class Currency {
	
	//fields 
	private int dollar;
	private int credit;
	
	//constructor
	public Currency(int d,int c) {
		this.dollar = d;
		this.credit = c;
	}
	
	
	//methods
	public int getDollar() {
		return dollar;
	}
	public int getCredit() {
		return credit;
	}
	public void addDollar(int d) {
		dollar += d;
	}
	public void removeDollar(int d) {
		dollar -= d;
	}
	public void addCredit(int c) {
		credit += c;
	}
	public void removeCredit(int c) {
		credit -= c;
	}
}