package ss.week3.pw;

import java.lang.Character;

public class StrongChecker extends BasicChecker implements Checker {
	
	public StrongChecker() {
	}
	
	@Override
	public String generatePassword() {
		return "geenwachtwoord1";
	}
	
	@Override
	public boolean acceptable (String testpassword) {
		if (!(Character.isDigit(testpassword.charAt(testpassword.length()-1))) && Character.isDigit(testpassword.charAt(0)) && super.acceptable(testpassword)) {
			return true;
		}
		else return false;
	}

}


