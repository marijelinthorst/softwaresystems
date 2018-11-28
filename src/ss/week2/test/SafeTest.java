package ss.week2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week2.hotel.Safe;

class SafeTest {
	
	private Safe testsafe;

	@BeforeEach
	void setUp(){
		testsafe = new Safe();
		// testsafe which is open and activated and testsafe which is activated and closed
	}

	@Test
	void testInitial() {
		assertEquals(true, testsafe.isActive());
		assertEquals(true, testsafe.isOpen());
	}
	@Test
	void testActivateWrongPass() {
		testsafe.deactivate();
		testsafe.activate("wrongpass");
		assertEquals(false, testsafe.isActive());
	}
	@Test
	void testActivateWrongPassActiveSafe() {
		testsafe.activate("wrongpass");
		assertEquals(true, testsafe.isActive());
	}
	@Test
	void testActivateGoodPass() {
		testsafe.deactivate();
		testsafe.activate("strawberry");
		assertEquals(true, testsafe.isActive());
	}
	@Test
	void testDeactivate() {
		assertEquals(true, testsafe.isActive());
		testsafe.deactivate();
		assertEquals(false, testsafe.isActive());
	}
	@Test
	void testOpenWrongPass() {
		testsafe.close();
		testsafe.open("wrongpass");
		assertEquals(false, testsafe.isOpen());
	}
	@Test
	void testOpenWrongPassOpenSafe() {
		testsafe.open("wrongpass");
		assertEquals(true, testsafe.isOpen());
	}
	@Test
	void testOpenGoodPass() {
		testsafe.close();
		testsafe.open("strawberry");
		assertEquals(true, testsafe.isOpen());
	}
	@Test
	void testClose() {
		assertEquals(true, testsafe.isOpen());
		testsafe.close();
		assertEquals(false, testsafe.isOpen());
	}

}
