package ss.week2;
/**
 * 
 * @author marije.linthorst
 * Models a simple three-way lamp with off, low, 
 * medium and high settings 
 */
public class ThreeWayLamp {
	// Named constants:
	/**
	 * The lamp is switched off 
	 */
	public static final int OFF = 0;
	/**
	 * The lamp is switched to low 
	 */
	public static final int LOW = 1;
	/**
	 * The lamp is switched to medium 
	 */
	public static final int MEDIUM = 2;
	/**
	 * The lamp is switched to high 
	 */
	public static final int HIGH = 3;
	
	// private componants:
	private int setting; // current setting
	
	//@ invariant OFF==0;
	//@ invariant LOW==1;
	//@ invariant MEDIUM==2;
	//@ invariant HIGH==3;
	//@ invariant (setting()==OFF || setting()==LOW || setting()==MEDIUM || setting()==HIGH);
	
	// constructor:
	/**
	 * Create a new ThreeWayLamp, initially off
	 */
	// @ ensures setting()=OFF;
	public ThreeWayLamp () {
		setting = OFF;
	}
	
	// Quaries:
	/**
	 * The current setting of the lamp.
	 * Returns ThreeWayLamp.OFF, ThreeWayLamp.LOW, 
	 * ThreeWayLamp.MEDIUM or ThreeWayLamp.HIGH
	 */
	// @ ensures(\result==OFF || \result==LOW || \result==MEDIUM || \result==HIGH);
	/*@ pure*/ public int setting (){
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
		assert setting()==OFF || setting()==LOW || setting()==MEDIUM || setting()==HIGH;
		setting = (setting + 1) % 4;
	}
}
