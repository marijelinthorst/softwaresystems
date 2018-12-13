package ss.week3.math;

public class Identity implements Integrable{
	private double argument;
	
	public Identity () {
	}
	
	//commands
	@Override
	public double apply (double argument) {
		this.argument =argument;
		return argument;
	}
	
	@Override
	public Function derivative() {
		return new Constant(1.0);
	}
	
	@Override
	public String toString() {
		return Double.toString(argument);
	}
	
	@Override
	public Integrable integral () {
		return new Product (new Constant (0.5), new Exponent(2));
	}
	
	//main
	public static void main (String[] argv) {
		Print.print(new Identity());
	}

}
