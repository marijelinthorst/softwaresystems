package ss.week3.math;

public class LinearProduct extends Product implements Integrable{
	private Constant one;
	
	public LinearProduct (Constant one, Function two) {
		super(one, two);
		this.one=one;
	}
	
	@ Override
	public Function derivative () {
		Function derivativeTwo = two.derivative();
		return new LinearProduct(one, derivativeTwo);
	 }
	
	@Override 
	public Integrable integral() {
		if (two instanceof Integrable) {
			return new LinearProduct(one, ((Integrable)two).integral());
		}
		else return null;
	}
	
	//main
	public static void main (String[] argv) {
		Print.print(new LinearProduct(new Constant(2.0), new Constant (3.0)));
	}

}
