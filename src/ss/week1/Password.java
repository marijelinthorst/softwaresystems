package ss.week1;

public class Password {
/**
 * Representation of a password. Lab exercise Software systems.
 */
	public static final String INITIAL = "strawberry"; //The standard initial password.
	private String password;
	
	// Constructor
	/**
	 * Constructs a Password with the initial word provided in INITIAL.
	 */
	public Password() {
		this.password = INITIAL;
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
	public boolean testWord (String test) {
		if (test.equals(password))
			return true;
		else return false;
	}
}
