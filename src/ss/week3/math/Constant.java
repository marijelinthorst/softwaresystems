package ss.week3.math;

public class Constant implements Integrable {
	private double constant;
	
	public Constant (double constant) {
		this.constant=constant;
	}
	
	//commands
	@Override
	public double apply(double argument) {
		return constant;
	}
	
	@Override
	public Function derivative() {
		return new Constant(0.0);
	}
	
	@Override
	public String toString() {
		return Double.toString(constant);
	}
	
	@Override
	public Integrable integral () {
		return new Product(new Constant(constant), new Identity());
	}
	
	//main
	public static void main (String[] argv) {
		Print.print(new Constant(2.0));
	}

}
