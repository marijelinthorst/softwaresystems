package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.Polynomial;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

public class PolynomialTest {
  
  private static final double DELTA = 1e-15;
  private static final double[] array = {5,6,7};
  private static final double[] array2 = {-5,-6,-7,-8};
  private static final double[] array3 = {0,1,2};
  private Polynomial poly;
  private Polynomial poly2;
  private Polynomial poly3;
  private double answer11 = 5+6+7;
  private double answer12 = 5;
  private double answer13 = 5-6+7;
  
  private double answer21 = -5-6-7-8;
  private double answer22 = -5;
  private double answer23 = -5+6-7+8;
  
  private double answer31 = 0+1+2;
  private double answer32 = 0;
  private double answer33 = 0-1+2;
  
  
  
  @Before
  public void setUp() {
    poly = new Polynomial(array);
    poly2 = new Polynomial(array2);
    poly3 = new Polynomial(array3);
  }
  
  @Test
  public void testApply() {
    assertEquals("array 5,6,7", answer11, poly.apply(1), DELTA);
    assertEquals("array 5,6,7", answer12, poly.apply(0), DELTA);
    assertEquals("array 5,6,7", answer13, poly.apply(-1), DELTA);
    
    assertEquals("array -5,-6,-7,-8", answer21, poly2.apply(1), DELTA);
    assertEquals("array -5,-6,-7,-8", answer22, poly2.apply(0), DELTA);
    assertEquals("array -5,-6,-7,-8", answer23, poly2.apply(-1), DELTA);
    
    assertEquals("array 0,1,2", answer31, poly3.apply(1), DELTA);
    assertEquals("array 0,1,2", answer32, poly3.apply(0), DELTA);
    assertEquals("array 0,1,2", answer33, poly3.apply(-1), DELTA);
    System.out.println("end test");
  }
  
}
