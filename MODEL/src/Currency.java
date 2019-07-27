package MODEL.src;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - CURRENCY CLASS                                 //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

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
