package ss.week2.hotel;

public class Safe {
	/**
	 * Representation of a password. Lab exercise Software systems.
	 */
	//public static final String INITIALOPEN = "sunflower"; //The standard initial password.
	//public static final String INITIALACTIVE = "strawberry"; //The standard initial password.
	private boolean activated;
	private boolean opened;
	public Password passwordtoactivate;
	public Password passwordtoopen;
	
	public static void main (String[] argv) {
		Safe testsafe;
		testsafe = new Safe();
		testsafe.deactivate();
		testsafe.open("strawberry");
	}
		
	// Constructor
	/**
	 * Constructs a Password with the initial word provided in INITIAL.
	 */
	public Safe() {
		passwordtoactivate = new Password();
		passwordtoopen = new Password();
		this.activated = true;
		this.opened = true;
	}
	
	// Commands
	//@ requires test!=null;
	//@ ensures passwordtoactivate.testWord(test)==true ==>isActive()==true;
	//@ ensures passwordtoactivate.testWord(test)==false ==>isActive()==\old(isActive());
	public void activate (String test) {
		assert (test!=null);
		if (passwordtoactivate.testWord(test)==true)
			activated=true;
	}
	
	//@ ensures isActive()==false;
	//@ ensures isOpen()==false;
	public void deactivate () {
		opened=false;
		activated=false;
	}
	
	//@ requires test!=null;
	//@ requires isActive()==true;
	//@ ensures passwordtoopen.testWord(test)==true ==> isOpen()==true;
	//@ ensures passwordtoopen.testWord(test)==false ==> isOpen()==\old(isOpen());
	public void open (String test) {
		assert (test!=null);
		assert(isActive()==true);
		if (passwordtoopen.testWord(test)==true)
				opened=true;
	}
	
	//@ ensures isOpen()==false;
	public void close() {
		opened = false;
	}

	
	//Queries
	//@ ensures \result==false || \result==true;
	/*@ pure*/ public boolean isActive() {
		return this.activated;
	}
	
	//@ requires isActive()==true;
	//@ ensures \result==false || \result==true;
	/*@ pure*/ public boolean isOpen() {
		return this.opened;
	}
	
	//@ ensures \result==passwordtoactivate;
	/*@ pure*/ public Password getPasswordactivate() {
		return this.passwordtoactivate;
	}
	
	//@ ensures \result==passwordtoopen;
	/*@ pure*/ public Password getPasswordopen() {
		return this.passwordtoopen;
	}
}
