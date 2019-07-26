// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//                DEADWOOD - DIE CLASS                                 //
//  Programmers: Vlad Bugayev, Natthapong Choeypant                         //
//  Class: CSCI 345, Summer 2019                                            //
//                                                                          //
//                                                                          //
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //


//Singleton Class
public class Die {
	
	public static Die d;
	
	private Die() {}
	
	public static Die getD() {
		if(d == null) {
			d = new Die();
		}
		return d;
	}
	//a method that return random number between 1-6
	public int roll() {
		return (int)(Math.random()*5) + 1;
	}
}
