package ss.week3.pw;

public class BasicChecker implements Checker{
	public static String INITPASS= "strawberry1";
	
	
	public BasicChecker() {
	}
	
	@Override
	public String generatePassword() {
		return INITPASS;
	}

}
