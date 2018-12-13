package ss.week3.pw;

public class Password {
/**
 * Representation of a password. Lab exercise Software systems.
 */
	public static final String INITIAL = "strawberry1"; //The standard initial password.
	private String password;
	protected Checker checker;
	protected String factoryPassword;
	
	// Constructor
	/**
	 * Constructs a Password with the initial word provided in INITIAL.
	 */
	public Password(Checker checker) {
		this.checker=checker;
		factoryPassword=INITIAL;
		this.password = factoryPassword;
	}
	
	public Password() {
		this(new BasicChecker());
	}
	
	//Commands
	/**
	 * Test if a given string is an acceptable password.
	 * @param suggestion password
	 * @return true/false
	 */
	public boolean acceptable (String suggestion) {
		if (suggestion.length()>=6 && suggestion.contains (" ") == false)
			return true;
		else return false;
	
	}
	/**
	 * Changes this password.
	 * @param oldpass
	 * @param newpass§
	 * @return true/false
	 */
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(password) && acceptable(newpass)== true) {
			this.password = newpass;
			return true;
		}	
		else return false;
	}
	/**
	 * Tests if a given word is equal to the current password.
	 * @param test
	 * @return true/false
	 */
	/*@ pure*/ public boolean testWord (String test) {
		if (test.equals(password))
			return true;
		else return false;
	}
	
	public Checker checker() {
		return checker;
	}
	
	public String factoryPasswordReturn() {
		return factoryPassword;
	}
}
