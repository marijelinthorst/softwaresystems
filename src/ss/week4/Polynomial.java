package ss.week4;

import ss.week3.math.Function;
import ss.week3.math.Integrable;
import ss.week3.math.*;

public class Polynomial implements Integrable {
  private double[] array;
  private Function result;
  
  // constructor
  public Polynomial (double[] array) {
    assert (array.length>0);
    this.array=array;
  }

  @Override
  public double apply(double argument) {
    this.result = new Constant (array[0]);
    for (int n=1; n < array.length; n++) {
      this.result =new Sum(this.result, new Product(new Constant(array[n]), new Exponent(n)));
    }
    return result.apply(argument);
  }

  @Override
  public Function derivative() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Integrable integral() {
    // TODO Auto-generated method stub
    return null;
  }
  

}
