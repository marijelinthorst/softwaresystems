package ss.week3.math;

public class Sum implements Integrable{
	private double value;
	private Function one;
	private Function two;
	
	public Sum (Function one, Function two) {
		this.one=one;
		this.two=two;
	}
	
	//commands
		@Override
		public double apply(double argument) {
			value = one.apply(argument) + two.apply(argument);
			return value;
		}
		
		@Override
		public Function derivative() {
			Function derivativeOne = one.derivative(); 
			Function derivativeTwo = two.derivative();
			return new Sum (derivativeOne, derivativeTwo);
		}
		
		@Override
		public String toString() {
			return one.toString() + "+" + two.toString();
		}
		
		@Override
		public Integrable integral() {
			if (one instanceof Integrable && two instanceof Integrable) {
				return new Sum(((Integrable)one).integral(), ((Integrable)two).integral());
			}
			else return null;
		}
		
		//main
		public static void main (String[] argv) {
			Print.print(new Sum(new Constant(2.0), new Constant (3.0)));
		}

}
