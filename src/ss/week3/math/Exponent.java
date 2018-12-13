package ss.week3.math;

public class Exponent implements Integrable{
	private int n;
	
	// @ requires n>=0
	public Exponent (int n) {
		assert(n>=0);
		this.n=n;
	}
	
	//commands
	@Override
	public double apply (double argument) {
		 return Math.pow(argument, this.n);
	 }
	 
	 @Override
	public Function derivative () {
		 return new LinearProduct(new Constant(n), new Exponent(n-1));
	 }
	 
	 @Override
	public String toString() {
		 return "x^" + this.n;
	 }
	 
	 @Override
	public Integrable integral() {
		 double value = (1/((double)n+1));
		 return new Product(new Constant(value), new Exponent(n+1));
	 }
	 
	 //main
	 public static void main (String[] argv) {
			Print.print(new Exponent(3));
		}

}
