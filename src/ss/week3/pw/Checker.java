package ss.week3.pw;

public interface Checker {
	default public boolean acceptable(String testpassword) {
		if (testpassword.length()>=6 && testpassword.contains (" ") == false)
			return true;
		else return false;
	}
	public String generatePassword();

}
