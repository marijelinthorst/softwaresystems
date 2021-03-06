package ss.week3.math;

public class Product implements Integrable{
	protected Function one;
	protected Function two;
	
	 public Product (Function one, Function two) {
		 this.one=one;
		 this.two=two;
	 }
	 
	 //commands
	 @Override
	public double apply (double argument) {
		 return one.apply(argument)*two.apply(argument);
	 }
	 
	 @Override
	public Function derivative () {
		 Function derivativeOne = one.derivative();
		 Function derivativeTwo = two.derivative();
		 return new Sum(new Product(derivativeOne, two), new Product(one, derivativeTwo));
	 }
	 
	 @Override
	public String toString() {
		 return one.toString() + "*" + two.toString();
	 }
	 
	 @Override
	public Integrable integral() {
		 return null;
	 }
	 
	 
	 //main
	 public static void main (String[] argv) {
			Print.print(new Product(new Constant(2.0), new Constant (3.0)));
		}

}
