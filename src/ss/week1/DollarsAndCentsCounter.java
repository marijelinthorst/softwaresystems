package ss.week1;

public class DollarsAndCentsCounter {
	private int dollars;
	private int cents;
	
	// constructor
	public DollarsAndCentsCounter () {
	}
	// Queries
	public int dollars() {
		return dollars;
	}
	public int cents() {
		return cents;
	}
	
	// Commands
	public void add (int dollars, int cents) {
		this.dollars = this.dollars + dollars;
		this.cents = this.cents + cents;
		if (this.cents + cents >= 100) {
			this.dollars = this.dollars + this.cents/100;
			this.cents = this.cents % 100;
			}
		}
		
	public void reset () {
		dollars = 0;
		cents = 0;
	}

}
