package ss.week1;
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
	
	// constructor:
	/**
	 * Create a new ThreeWayLamp, initially off
	 */
	public ThreeWayLamp () {
		setting = OFF;
	}
	
	// Quaries:
	/**
	 * The current setting of the lamp.
	 * Returns ThreeWayLamp.OFF, ThreeWayLamp.LOW, 
	 * ThreeWayLamp.MEDIUM or ThreeWayLamp.HIGH
	 */
	public int setting (){
		return setting;
	}
	// Commands:
	/**
	 * Changes to the next setting
	 */ 
	public void change () {
		setting = (setting + 1) % 4;
	}
}
