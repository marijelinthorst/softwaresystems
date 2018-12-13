package ss.week2.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import ss.week2.Rectangle;

/**
 * Test program for Rectangle.
 * Lab Exercise Software Systems
 * @author marije.linthorst
 */
public class RectangleTest {
	/** test variables*/
	private Rectangle rec00;
	private Rectangle rec01;
	private Rectangle rec10;
	private Rectangle rec12;
	
	 @Before
	    public void setUp() {
		 // initialisation of Rectangle-variables
		 rec00 = new Rectangle(0,0);
	     rec01 = new Rectangle(0,1);
	     rec10 = new Rectangle(1,0);
	     rec12 = new Rectangle(1,2);
	    }
	 /**
	  * Tests if the initial condition complies to the specification.
	  */
	 @Test
	 public void testInitialcondition() {
		 assertEquals(0, rec00.length());
		 assertEquals(0, rec00.width());
		 assertEquals(0, rec01.length());
		 assertEquals(1, rec01.width());
		 assertEquals(1, rec10.length());
		 assertEquals(0, rec10.width());
		 assertEquals(1, rec12.length());
		 assertEquals(2, rec12.width());
	    }
	 /**
	  * Test the area.
	  */
	 @Test
	 public void testArea() {
		 assertEquals(0,rec00.area());
		 assertEquals(0,rec01.area());
		 assertEquals(0,rec10.area());
		 assertEquals(2,rec12.area());
	 }
	 
	 /**
	  * Test the perimeter.
	  */
	 @Test
	 public void testPerimeter() {
		 assertEquals(0,rec00.perimeter());
		 assertEquals(2,rec01.perimeter());
		 assertEquals(2,rec10.perimeter());
		 assertEquals(6,rec12.perimeter());
	 }
	 
}
