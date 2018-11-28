package ss.week1;

public class Test3_8 {
	/**
	 * @author marije.linthorst
	 * Run a ThreeWayLampTest
	 */
	public static void main (String[] argv) {
			ThreeWayLampTest test;
			test = new ThreeWayLampTest();
			test.runTest();
	}
}

/**
 * A tester for the class ThreeWayLamp
 */
class ThreeWayLampTest {
	private ThreeWayLamp lamp; // the object to test
	
	/** 
	 * Create a ThreeWayLampTest
	 */
	public ThreeWayLampTest () {
		// create a lamp to test:
		lamp = new ThreeWayLamp();
	}
	/**
	 * Run the test.
	 */
	public void runTest() {
		testInitialState();
		testChange();
	}
	/**
	 * Test the ThreeWayLamp's initial state.
	 */
	private void testInitialState() {
		System.out.println("testInitialState:");
		System.out.println("Initial light:" + lamp.setting());
	}
	/**
	 * Test the method change.
	 */
	private void testChange() {
		System.out.println("testChange:");
		System.out.println("Starting setting:" + lamp.setting());
		lamp.change();
		System.out.println("After 1 change:" + lamp.setting());
		lamp.change();
		System.out.println("After 2 changes:" + lamp.setting());
		lamp.change();
		System.out.println("After 3 changes:" + lamp.setting());
		lamp.change();
		System.out.println("After 4 changes:" + lamp.setting());
	}
}
