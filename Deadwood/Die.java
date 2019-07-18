package Deadwood;

public class Die {
	
	public static Die d;
	
	private Die() {}
	
	public static Die getD() {
		if(d == null) {
			d = new Die();
		}
		return d;
	}
	
	public int roll() {
		return (int)(Math.random()*5) + 1;
	}
}
