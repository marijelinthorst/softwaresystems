package ss.week2;
/**
 * 
 * @author marije.linthorst
 * Models a simple three-way lamp with off, low, 
 * medium and high settings 
 */
public class ThreeWayLamp2_7 {

	// private componants:
	private possibleSettings setting; // current setting
	
	public enum possibleSettings {OFF, LOW, MEDIUM, HIGH}
	
	//@ invariant (setting()==possibleSettings.OFF || setting()==possibleSettings.LOW || setting()==possibleSettings.MEDIUM || setting()==possibleSettings.HIGH);
	
	
	
	// constructor:
	/**
	 * Create a new ThreeWayLamp, initially off
	 */
	// @ ensures setting()=OFF;
	public ThreeWayLamp2_7 () {
		setting = possibleSettings.OFF;
	}
	
	// Quaries:
	/**
	 * The current setting of the lamp.
	 * Returns ThreeWayLamp.OFF, ThreeWayLamp.LOW, 
	 * ThreeWayLamp.MEDIUM or ThreeWayLamp.HIGH
	 */
	// @ ensures(\result==OFF || \result==LOW || \result==MEDIUM || \result==HIGH);
	/*@ pure*/ public possibleSettings setting (){
		return setting;
	}
	// Commands:
	/**
	 * Changes to the next setting
	 */ 
	// @ ensures (\old(setting())==OFF ==> setting()==LOW);
	// @ ensures (\old(setting())==LOW ==> setting()==MEDIUM);
	// @ ensures (\old(setting())==MEDIUM ==> setting()==HIGH);
	// @ ensures (\old(setting())==HIGH ==> setting()==OFF);
	public void change () {
		switch (setting) {
		case OFF:
			setting=possibleSettings.LOW;
		case LOW:
			setting=possibleSettings.MEDIUM;
		case MEDIUM:
			setting=possibleSettings.HIGH;
		case HIGH:
			setting=possibleSettings.OFF;
		
		}
		//assert setting()==OFF || setting()==LOW || setting()==MEDIUM || setting()==HIGH;
		//setting = (setting + 1) % 4;
	}
}
