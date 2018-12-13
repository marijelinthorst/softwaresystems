package ss.week3.pw;

public class TimedPassword extends Password {
	protected int validTime;
	protected long passedTime;
	protected long startTime;
	
	
	public TimedPassword(int validTime) {
		this.validTime=validTime;
		startTime=System.currentTimeMillis();
	}
	
	public TimedPassword() {
		this(3700);
	}
	
	public boolean isExpired() {
		passedTime= System.currentTimeMillis()-startTime;
		if (passedTime>validTime) {
			return true;
		}
		else return false;
	}
	@Override
	public boolean setWord(String oldpass, String newpass) {
		super.setWord(oldpass, newpass);
		startTime=System.currentTimeMillis();
		return true;
	}

}
